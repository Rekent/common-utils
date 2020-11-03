package com.rekent.tools.utils.torrent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rekent.tools.utils.digest.SHA1Utils;

public final class TorrentFileResovler {
	private byte[] torrentBytes;
	private int infoStart;
	private int infoEnd;
	private HashMap<String, Object> result;

	private TorrentFileResovler() {
	}

	public static TorrentFileResovler init(String path) throws IOException {
		TorrentFileResovler resovler = new TorrentFileResovler();
		resovler.torrentBytes = Files.readAllBytes(Paths.get(path));
		resovler.infoStart = 0;
		resovler.infoEnd = 0;
		return resovler;
	}

	public HashMap<String, Object> start() throws IOException {
		if (result != null) {
			return result;
		}
		TorrentSeekStruct bStruct = new TorrentSeekStruct(torrentBytes, 0);
		result = readMap(bStruct);
		return result;
	}

	public String hash() throws Exception {
		result = this.start();
		byte[] infoByte = new byte[infoEnd - infoStart + 1];
		System.arraycopy(torrentBytes, infoStart, infoByte, 0, infoEnd - infoStart + 1);
		return SHA1Utils.toSHA1(infoByte);
	}

	protected HashMap<String, Object> readMap(TorrentSeekStruct struct) {
		// 进方法时指向'd'，再向前一一位
		struct.offsetForward(1);
		char symbol = struct.getCharacter();
		HashMap<String, Object> map = new HashMap<String, Object>();
		String key = null;
		while (symbol != 'e') {
			if (symbol == 'l') {
				List<Object> list = readList(struct);
				map.put(new String(key), list);
				key = null;
			} else if (symbol == 'd') {
				boolean record = key.equals("info");
				if (record) {
					infoStart = struct.getOffset();
				}
				HashMap<String, Object> readMap = readMap(struct);
				if (record) {
					infoEnd = struct.getOffset() - 1;
				}
				map.put(new String(key), readMap);
				key = null;
			} else if (symbol == 'i') {
				Long num = readInt(struct);
				map.put(new String(key), num);
				key = null;
			} else if (symbol >= '0' && symbol <= '9') {
				String data = readString(struct);
				if (key == null) {
					key = data;
				} else {
					map.put(new String(key), data);
					key = null;
				}
			} else {
				throw new IllegalArgumentException("读取到不符合规范的标识符：" + struct.getCharacter());
			}
			symbol = struct.getCharacter();
		}
		if (struct.getCharacter() == 'e') {
			struct.offsetForward(1);
		}
		return map;
	}

	protected String readString(TorrentSeekStruct struct) {
		int readIndex = 1;
		byte[] messages = struct.getInfo();
		Integer offset = struct.getOffset();
		Character symbol = (char) messages[offset];
		StringBuilder builder = new StringBuilder();
		builder.append(symbol);
		while (messages[offset + readIndex] != ':') {
			builder.append((char) messages[offset + readIndex]);
			readIndex++;
		}
		Long length = Long.valueOf(builder.toString());
		if (length == null || length < 0) {
			throw new IllegalArgumentException("读取到不符合规范的字符串长度：" + length);
		}
		StringBuilder dataBuilder = new StringBuilder();
		readIndex++;
		int begin = offset + readIndex;
		for (int i = begin; i < begin + length; i++) {
			dataBuilder.append((char) messages[i]);
			readIndex++;
		}
		struct.setOffset(offset + readIndex);
		return dataBuilder.toString();
	}

	protected Long readInt(TorrentSeekStruct struct) {
		int readIndex = 1;
		StringBuilder integerBuilder = new StringBuilder();
		byte[] messages = struct.getInfo();
		Integer offset = struct.getOffset();
		while (messages[offset + readIndex] != 'e') {
			integerBuilder.append((char) messages[offset + readIndex]);
			readIndex++;
		}
		Long data = null;
		try {
			data = Long.valueOf(integerBuilder.toString());
		} catch (Exception e) {
			throw new IllegalArgumentException("读取到不符合规范的整形数据：" + data);
		}
		struct.setOffset(offset + readIndex + 1);
		return data;
	}

	protected List<Object> readList(TorrentSeekStruct struct) {
		// 进方法时指向'l'，再向前一一位
		struct.offsetForward(1);
		char symbol = struct.getCharacter();
		List<Object> list = new ArrayList<Object>();
		while (symbol != 'e') {
			if (symbol == 'l') {
				List<Object> readList = readList(struct);
				list.add(readList);
			} else if (symbol == 'd') {
				HashMap<String, Object> readMap = readMap(struct);
				list.add(readMap);
			} else if (symbol == 'i') {
				Long num = readInt(struct);
				list.add(num);
			} else if (symbol >= '0' && symbol <= '9') {
				String data = readString(struct);
				list.add(data);
			} else {
				throw new IllegalArgumentException("读取到不符合规范的标识符：" + struct.getCharacter());
			}
			symbol = struct.getCharacter();
		}
		if (symbol == 'e') {
			struct.offsetForward(1);
		}
		return list;
	}
}
