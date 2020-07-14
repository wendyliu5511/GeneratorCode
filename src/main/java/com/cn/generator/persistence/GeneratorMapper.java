package com.cn.generator.persistence;



import java.util.List;
import java.util.Map;


/**
 * 代码生成
 *
 */

public interface GeneratorMapper {
    List<String> queryLists();

	List queryList(Map<String,Object> map);

	int queryTotal(Map<String,Object> map);

	Map<String,String> queryTable(String tableName);

	List<Map<String,String>> queryColumns(String tableName);

}
