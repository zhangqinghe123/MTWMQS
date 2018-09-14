package com.qianxx.qztaxi.common.yingyan.api.entity;


import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 更新实体
 * <p>Title: UpdateEntityRequest</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年5月21日 下午3:18:12
 * @version 1.0.0
 */
public class UpdateEntityRequest extends BaseRequest {
	private String entityName;

	public String getEntityName() {
		return entityName;
	}

	public Map<String, String> columnMap = new HashMap<>();

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public UpdateEntityRequest(String entityName) {
		this.entityName = entityName;
	}

	public Map<String, String> getColumnMap() {
		return columnMap;
	}

}
