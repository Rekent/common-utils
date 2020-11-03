package com.rekent.tools.utils.torrent;

public class TorrentSeekStruct {
	private byte[] info;
	private Integer offset;

	public TorrentSeekStruct(byte[] info, Integer offset) {
		this.info = info;
		this.offset = offset;
	}

	public void offsetForward(int i) {
		this.offset = offset + i;
	}

	public char getCharacter() {
		return (char) info[offset];
	}

	public Integer getLength() {
		return info.length;
	}

	/**
	 * @return the info
	 */
	public byte[] getInfo() {
		return info;
	}

	/**
	 * @return the offset
	 */
	public Integer getOffset() {
		return offset;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(byte[] info) {
		this.info = info;
	}

	/**
	 * @param offset the offset to set
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
}
