package com.cn.generator.domain;

import java.util.List;


public class TablePojo {
	//表的名称
	private String tableName;
	//表的备注
	private String comments;
	//表的主键
	private ColumnPojo pk;
	//表的列名(不包含主键)
	private List<ColumnPojo> columns;
	
	//类名
	private String className;
	//类名
	private String classname;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public ColumnPojo getPk() {
		return pk;
	}
	public void setPk(ColumnPojo pk) {
		this.pk = pk;
	}
	public List<ColumnPojo> getColumns() {
		return columns;
	}
	public void setColumns(List<ColumnPojo> columns) {
		this.columns = columns;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
}
