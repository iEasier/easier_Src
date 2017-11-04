package com.ieasier;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ieasier.tools.Config;

@Controller
public class SourceFiles {

	private final static String SourcesRootUrl = new Config().SOURCES_ROOTURL;
	private HashMap<Object, Object> sourceNames = new HashMap<Object, Object>();
	@RequestMapping(value = "/getFileList", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<Object, Object> getFileList() {
		sourceNames.clear();
		SourceFilesContent sourceContent = new SourceFilesContent();
		ArrayList<Object> list = sourceContent
				.getSourceContents(SourcesRootUrl);
		sourceNames.put("fileNames", list);
		sourceNames.put("retCode", 0);
		return sourceNames;
	}

	@RequestMapping(value = "/getFileContent", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<Object, Object> getFileContent(
			@RequestBody String params) {
		sourceNames.clear();
		String fileUrl = SourcesRootUrl + "/"+params;
		SourceFilesContent sourceContent = new SourceFilesContent();
		sourceNames = sourceContent.getSubContent(fileUrl);
		sourceNames.put("retCode", 0);
		return sourceNames;
	}
}