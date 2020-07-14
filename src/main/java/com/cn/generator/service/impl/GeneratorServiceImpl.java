package com.cn.generator.service.impl;


import com.cn.generator.persistence.GeneratorMapper;
import com.cn.generator.service.GeneratorService;
import com.cn.generator.util.GenUtils;
//import com.github.pagehelper.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;


@Service
public class GeneratorServiceImpl implements GeneratorService {
	
	@Autowired
	private GeneratorMapper generatorMapper;

	@Override
	public PageInfo queryList(Map<String, Object> map, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(null != pageNum ? pageNum : 0, null != pageSize ? pageSize : 0);
		return new PageInfo(generatorMapper.queryList(map));
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return generatorMapper.queryTotal(map);
	}

	@Override
	public Map<String, String> queryTable(String tableName) {
		return generatorMapper.queryTable(tableName);
	}

	@Override
	public List<Map<String, String>> queryColumns(String tableName) {
		return generatorMapper.queryColumns(tableName);
	}

	/*@Override
	public byte[] generatorCode(String[] tableNames) {
		return new byte[0];
	}*/

	@Override
	public byte[] generatorCodes(List<String> tableNames) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);
		
		for(String tableName : tableNames){
			//查询表信息
			Map<String, String> table = queryTable(tableName);
			//查询列信息
			List<Map<String, String>> columns = queryColumns(tableName);
			//生成代码
			GenUtils.generatorCode(table, columns, zip);
		}
		//添加工具类代码 将工具类写进common里面
		IOUtils.closeQuietly(zip);
		return outputStream.toByteArray();
	}

	@Override
	public List<String> queryLists() {
		return generatorMapper.queryLists();
	}

}
