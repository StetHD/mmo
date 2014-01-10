package com.tongwan.common.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhangde
 * 
 * @date 2014��1��9��
 */
public class FileX {
	/**
	 * ��ȡ�ı��ļ���ȫ������
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static final String readAll(final File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);
			sb.append("\r\n");
		}
		br.close();

		br = null;
		return sb.toString();
	}
	/**
	 * ��ȡ�ı��ļ���ȫ������
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static final String readAll(final String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = "";
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);
			sb.append("\r\n");
		}
		br.close();

		br = null;
		return sb.toString();
	}
	/**
	 * �������ı��ļ�
	 * @param file �ļ�·��
	 * @param fileContent �ļ����� 
	 */
	public static final void newFile(final String file, final String fileContent) {

		try {
			String filePath = file;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			String strContent = fileContent;
			myFile.println(strContent);
			resultFile.close();

			myFilePath = null;
			resultFile = null;
			myFile = null;
			strContent = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
