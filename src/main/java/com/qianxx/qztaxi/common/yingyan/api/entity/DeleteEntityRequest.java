package com.qianxx.qztaxi.common.yingyan.api.entity;


import com.qianxx.qztaxi.common.yingyan.model.BaseRequest;

/**
 * 
 * <p>Title: DeleteEntityRequest</p>
 * <p>Description: </p>
 * <p>Company: anjie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年5月7日 下午4:57:16
 * @version 1.0.0
 */
public class DeleteEntityRequest extends BaseRequest {
	private String entityName;

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public DeleteEntityRequest(String entityName) {
        this.entityName = entityName;
    }
}
