package com.qianxx.qztaxi.common.yingyan.api.entity;


import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: AddEntityRequest</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年5月7日 下午4:08:31
 * @version 1.0.0
 */
public class AddEntityRequest extends BaseRequest {
	
	private String entityName;

	public String getEntityName() {
		return entityName;
	}

	public Map<String, String> columnMap = new HashMap<>();

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public AddEntityRequest(String entityName) {
		this.entityName = entityName;
	}

	public Map<String, String> getColumnMap() {
		return columnMap;
	}

}
