package com.rekent.tools.utils.torrent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rekent.tools.utils.json.JsonUtils;
import com.rekent.tools.utils.lang.StringUtils;

public class TorrentFile {
	private String hash; // 种子文件hash值，sha1
	private String magnetUri; // 种子文件对应的磁力链接
	private HashMap<String, Object> source; // 种子文件解析后的原始字典（会省略pieces字段）
	@JsonIgnore
	private String originalPieces; // 种子文件解析后的原始字典中的pieces完整字段

	public TorrentFile(HashMap<String, Object> map, String hash) {
		this.source = map;
		this.hash = hash;
		HashMap<String, Object> info = this.getInfo();
		if (info.containsKey("pieces") && StringUtils.isBlank(originalPieces)) {
			this.originalPieces = new String((String) info.get("pieces"));
			info.put("pieces", ((String) info.get("pieces")).substring(0, 10).concat("... ..."));
		}
	}

	public TorrentFile(HashMap<String, Object> map, String hash, String magnetUri) {
		this.source = map;
		this.hash = hash;
		this.magnetUri = magnetUri;
		HashMap<String, Object> info = this.getInfo();
		if (info.containsKey("pieces") && StringUtils.isBlank(originalPieces)) {
			this.originalPieces = new String((String) info.get("pieces"));
			info.put("pieces", ((String) info.get("pieces")).substring(0, 10).concat("... ..."));
		}
	}

	public String getAnnounce() {
		Object value = source.get(TorrentKey.ANNOUNCE.mapKey());
		return (String) (value == null ? null : value);
	}

	@SuppressWarnings("unchecked")
	public List<String> getAnnounceList() {
		List<String> standbyAnnounceList = new ArrayList<String>();
		Object value = source.get(TorrentKey.ANNOUNCE_LIST.mapKey());
		if (value == null) {
			return standbyAnnounceList;
		}
		List<List<String>> lists = (List<List<String>>) value;
		for (List<String> eachList : lists) {
			for (String element : eachList) {
				standbyAnnounceList.add(element);
			}
		}
		return standbyAnnounceList;
	}

	public String getComment() {
		Object value = source.get(TorrentKey.COMMENT.mapKey());
		return (String) (value == null ? null : value);
	}

	public Date getCreateDate() {
		Object value = source.get(TorrentKey.CREATE_DATE.mapKey());
		if (value == null) {
			return null;
		}
		Long timestamp = (Long) value * 1000;
		return new Date(timestamp);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Object> getInfo() {
		Object value = source.get(TorrentKey.INFO.mapKey());
		return (HashMap<String, Object>) (value == null ? null : value);
	}

	public String getName() {
		HashMap<String, Object> info = this.getInfo();
		if (info == null) {
			return null;
		}
		Object value = info.get("name");
		return (String) (value == null ? null : value);
	}

	public String print() throws IOException {
		HashMap<String, Object> info = this.getInfo();
		if (info.containsKey("pieces")) {
			info.put("pieces", ((String) info.get("pieces")).substring(0, 10).concat("... ..."));
		}
		return JsonUtils.serializeObject(this);
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @return the magnetUri
	 */
	public String getMagnetUri() {
		return magnetUri;
	}

	/**
	 * @return the source
	 */
	public HashMap<String, Object> getSource() {
		return source;
	}

	/**
	 * @return the originalPieces
	 */
	public String getOriginalPieces() {
		return originalPieces;
	}

	/**
	 * @param magnetUri the magnetUri to set
	 */
	public void setMagnetUri(String magnetUri) {
		this.magnetUri = magnetUri;
	}
}
