package com.rekent.tools.utils.torrent;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import com.rekent.tools.utils.lang.CollectionUtils;

public final class MagnetUriGerenator {
	private static final String PRE_SUFFIX = "magnet:?xt=urn:btih:";
	private static final String DN = "&dn=";
	private static final String TR = "&tr=";
	private static final String CHARSET = "UTF-8";
	private TorrentFile torrent;

	private MagnetUriGerenator() {
	}

	public static MagnetUriGerenator init(TorrentFile map) {
		MagnetUriGerenator gerenator = new MagnetUriGerenator();
		gerenator.torrent = map;
		return gerenator;
	}

	public String gerenate() throws UnsupportedEncodingException {
		if (torrent == null) {
			throw new IllegalArgumentException("初始化的种子文件无效");
		}
		String hash = torrent.getHash();
		String name = torrent.getName();
		List<String> trackers = torrent.getAnnounceList();
		String tarcker = torrent.getAnnounce();
		StringBuilder builder = new StringBuilder(PRE_SUFFIX);
		builder.append(hash);
		builder.append(DN).append(URLEncoder.encode(name, CHARSET));
		builder.append(TR).append(URLEncoder.encode(tarcker, CHARSET));
		if (CollectionUtils.isNotEmpty(trackers)) {
			for (String trackerElement : trackers) {
				builder.append(TR).append(URLEncoder.encode(trackerElement, CHARSET));
			}
		}
		return builder.toString();
	}
}
