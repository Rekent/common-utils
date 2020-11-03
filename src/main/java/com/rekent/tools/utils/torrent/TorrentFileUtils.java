package com.rekent.tools.utils.torrent;

import java.util.HashMap;

import com.rekent.tools.utils.lang.StringUtils;

/**
 * 
 * 种子文件解析
 * 
 * @author chenhao.zhang
 *
 */
public final class TorrentFileUtils {

	public static TorrentFile resolve(String path) throws Exception {
		if (StringUtils.isBlank(path)) {
			throw new IllegalArgumentException("path 0 is null");
		}
		TorrentFileResovler resovler = TorrentFileResovler.init(path);
		HashMap<String, Object> result = resovler.start();
		String hash = resovler.hash();
		TorrentFile file = new TorrentFile(result, hash);
		String magnetUri = MagnetUriGerenator.init(file).gerenate();
		file.setMagnetUri(magnetUri);
		return file;
	}
}
