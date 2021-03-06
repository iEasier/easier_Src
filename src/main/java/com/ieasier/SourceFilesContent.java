package com.ieasier;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.ieasier.tools.Config;
import com.ieasier.tools.TurnUnit;

public class SourceFilesContent {
	private static HashMap<Object, Object> sources = new HashMap<Object, Object>();
	static Logger logger = Logger.getLogger(SourceFiles.class);
	private static String DOWNLOAD_PATH = new Config().DOWNLOAD_PATH;

	public ArrayList<Object> getSourceContents(String path) {
		ArrayList<Object> parentfileName = new ArrayList<Object>();
		File dir = new File(path);
		File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
		String fileNames;
		for (int i = 0; i < files.length; i++) {
			fileNames = files[i].getName();
			parentfileName.add(fileNames);
		}
		return parentfileName;
	}

	public HashMap<Object, Object> getSubContent(String path) {
		ArrayList<Object> fileName = new ArrayList<Object>();
		ArrayList<Object> fileSize = new ArrayList<Object>();
		ArrayList<Object> fileUrl = new ArrayList<Object>();
		File dir = new File(path);
		File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
		String fileNames;
		String curfileSize;
		String fileUrls;
		for (int i = 0; i < files.length; i++) {
			fileNames = files[i].getName();
			curfileSize = TurnUnit.turnUnit(files[i].length());
			fileUrls = DOWNLOAD_PATH + fileNames;
			fileUrl.add(fileUrls);
			fileName.add(fileNames);
			fileSize.add(curfileSize);
		}
		sources.put("fileName", fileName);
		sources.put("fileSize", fileSize);
		sources.put("fileUrl", fileUrl);
		return sources;
	}
}
