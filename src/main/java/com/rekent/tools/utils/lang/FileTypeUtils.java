package com.rekent.tools.utils.lang;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.rekent.tools.utils.extra.FileMagicNumber;

/**
 * 
 * Utils to determine file type
 * 
 * @author richard.zhang
 *
 */
public class FileTypeUtils {
	private static final String DOCX_PART_NAME = "/word/document.xml";
	private static final String XLSX_PART_NAME = "/xl/workbook.xml";

	/**
	 * Determine file type by file name
	 * 
	 * @param name
	 * @return
	 */
	public static String determineByName(String name) {
		if (StringUtils.isBlank(name)) {
			throw new IllegalArgumentException("illegal file name");
		}
		String[] names = name.split("\\.");
		if (names.length < 2) {
			throw new IllegalArgumentException("illegal file name : " + name);
		}
		return names[names.length - 1];
	}

	/**
	 * Determine file type by file magic number
	 * 
	 * 该方法不适用于区分word、excel，两者魔数相同
	 * 
	 * @param fileBytes
	 * @return
	 */
	public static String determineByMagicNum(byte[] fileBytes) {
		if (fileBytes == null || fileBytes.length == 0) {
			throw new IllegalArgumentException("illegal file bytes");
		}
		String fileHex = IOUtils.readByteArrayAsHex(fileBytes, 20);
		Iterator<Map.Entry<String, String>> entries = FileMagicNumber.magicNumebrs.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, String> entry = entries.next();
			String key = entry.getKey();
			String value = entry.getValue();
			if (fileHex.startsWith(key)) {
				return value;
			}
		}
		throw new IllegalArgumentException("illegal file bytes, no matches magicNumber");
	}

	/**
	 * 文件是否为word，仅支持docx格式
	 * 根据新版office文件压缩包下"[Content_Types].xml"文件做解析来判断是否为Word文件（PartName:/word/document.xml）
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws JDOMException
	 */
	public static boolean isDocx(InputStream input) throws IOException, JDOMException {
		List<String> partNameValues = parseFilePartNameList(input);
		if (CollectionUtils.isEmpty(partNameValues)) {
			return false;
		}
		for (String partValue : partNameValues) {
			if (partValue.equals(DOCX_PART_NAME)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 文件是否为excel,仅支持xlsx格式
	 * 根据新版office文件压缩包下"[Content_Types].xml"文件做解析来判断是否为excel文件（Part Name:/xl/workbook.xml）
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws JDOMException
	 */
	public static boolean isXlsx(InputStream input) throws IOException, JDOMException {
		List<String> partNameValues = parseFilePartNameList(input);
		if (CollectionUtils.isEmpty(partNameValues)) {
			return false;
		}
		for (String partValue : partNameValues) {
			if (partValue.equals(XLSX_PART_NAME)) {
				return true;
			}
		}
		return false;
	}

	private static List<String> parseFilePartNameList(InputStream input) throws IOException, JDOMException {
		List<String> partNames = new ArrayList<>();
		ZipInputStream zipStream = new ZipInputStream(input);
		BufferedInputStream bufferStream = new BufferedInputStream(zipStream);
		ZipEntry entry;
		while ((entry = zipStream.getNextEntry()) != null) {
			String fileName = entry.getName();
			if (fileName.equals("[Content_Types].xml")) {
				SAXBuilder builder = new SAXBuilder();
				byte[] xmlbytes = new byte[(int) entry.getSize()];
				bufferStream.read(xmlbytes, 0, (int) entry.getSize());
				InputStream byteArrayInputStream = new ByteArrayInputStream(xmlbytes);
				Document document = builder.build(byteArrayInputStream);
				Element foo = document.getRootElement();
				@SuppressWarnings("unchecked")
				List<Element> chilLst = foo.getChildren();
				for (Element child : chilLst) {
					String partNameValue = child.getAttributeValue("PartName");
					if (StringUtils.isBlank(partNameValue)) {
						partNames.add(partNameValue);
					}
				}
			}
		}
		return partNames;
	}
}
