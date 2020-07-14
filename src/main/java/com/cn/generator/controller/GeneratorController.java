package com.cn.generator.controller;

import com.cn.generator.service.GeneratorService;


import com.github.pagehelper.PageInfo;
import com.cn.generator.util.RestInfo;
import com.cn.generator.util.RestUtil;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * 功能描述: 代码生成
 *
 * @param:
 * @return: 
 * @auther: lmm
 * @date: 2019-12-22 19:27
 */
@Controller
@RequestMapping("/sysGenerator")
public class GeneratorController {
	@Autowired
	private GeneratorService generatorService;
	
	
	/**
	 *
	 * 功能描述: 查出所有的表
	 *
	 * @param: [params]
	 * @return: com.cn.generator.util.RestInfo
	 * @auther: lmm
	 * @date: 2019-12-22 19:27
	 */
	@ResponseBody
	@RequestMapping("/getGeneratorList")
	public RestInfo list(@RequestParam Map<String, Object> params){
		Integer pageNum=1;
		Integer pageSize=10;
		PageInfo list = generatorService.queryList(params, pageNum, pageSize);
		return RestUtil.setData(list);
	}
	
	/**
	 *
	 * 功能描述: 生成代码压缩包
	 *
	 * @param: [request, response]
	 * @return: void
	 * @auther: lmm
	 * @date: 2019-12-22 19:27
	 */
	@RequestMapping("/generateCode")
	public void code(HttpServletRequest request, HttpServletResponse response) throws IOException{

        List<String> tableNames=generatorService.queryLists();
		byte[] data = generatorService.generatorCodes(tableNames);
		response.reset();  
        response.setHeader("Content-Disposition", "attachment; filename=\"GeneratorCode.zip\"");
        response.addHeader("Content-Length", "" + data.length);  
        response.setContentType("application/octet-stream; charset=UTF-8");  
  
        IOUtils.write(data, response.getOutputStream());
	}


}
