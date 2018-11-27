package com.cruds.pos.formbean;

public class TableFormBean 
{
private String tableName;
private Long tableId;
private int maxNo;


public TableFormBean() {
	
}



public TableFormBean(String tableName, Long tableId, int maxNo) {
	super();
	this.tableName = tableName;
	this.tableId = tableId;
	this.maxNo = maxNo;
}

public String getTableName() {
	return tableName;
}


public void setTableName(String tableName) {
	this.tableName = tableName;
}


public Long getTableId() {
	return tableId;
}


public void setTableId(Long tableId) {
	this.tableId = tableId;
}


public int getMaxNo() {
	return maxNo;
}


public void setMaxNo(int maxNo) {
	this.maxNo = maxNo;
}


@Override
public String toString() {
	return "TableFormBean [tableName=" + tableName + ", tableId=" + tableId + ", maxNo=" + maxNo + "]";
}







}
