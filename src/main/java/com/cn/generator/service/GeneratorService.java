package com.cn.generator.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface GeneratorService {

	PageInfo queryList(Map<String, Object> map, Integer pageNum, Integer pageSize);
	
	int queryTotal(Map<String, Object> map);
	
	Map<String, String> queryTable(String tableName);
	
	List<Map<String, String>> queryColumns(String tableName);
	
	//byte[] generatorCode(String[] tableNames);

	List<String> queryLists();

	byte[] generatorCodes(List<String> list);
}
