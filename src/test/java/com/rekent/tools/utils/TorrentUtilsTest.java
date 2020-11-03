package com.rekent.tools.utils;

import org.junit.Test;

import com.rekent.tools.utils.torrent.TorrentFile;
import com.rekent.tools.utils.torrent.TorrentFileUtils;

import junit.framework.TestCase;

public class TorrentUtilsTest extends TestCase{

	@Test
	public void testResolve() throws Exception {
		String path = "C:\\Users\\richa\\Downloads\\Mulan (2020) [1080p] [WEBRip] [5.1] [YTS.MX].torrent";
		TorrentFile torrentFile = TorrentFileUtils.resolve(path);
		System.out.println(torrentFile.print());
		System.out.println("==========");
		System.out.println(torrentFile.getHash());
		System.out.println(torrentFile.getMagnetUri());
		System.out.println(torrentFile.getOriginalPieces());
	}
}
