package com.ieasier;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {
	HashMap<Object, Object> resultMap = new HashMap<Object, Object>();

	@RequestMapping(value = "/Test", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<Object, Object> Test() {
		resultMap.put("Status", "200");
		resultMap.put("描述", "GET接口访问测试通过！");
		return resultMap;
	}
}
