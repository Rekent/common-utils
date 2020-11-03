package com.rekent.tools.utils.torrent;

public enum TorrentKey {

	CREATE_DATE("creation date"), 
	CREATE_BY("created by"), 
	COMMENT("comment"), 
	ANNOUNCE("announce"), 
	ANNOUNCE_LIST("announce-list"), 
	LENGTH("length"),
	FILES("files"), 
	PIECE_LENGTH("piece length"),
	INFO("info");

	private String key;

	private TorrentKey(String key) {
		this.key = key;
	}

	public String mapKey() {
		return this.key;
	}
}
