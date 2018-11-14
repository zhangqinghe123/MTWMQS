package com.qianxx.qztaxi.common.callmembersys.message;

import com.alibaba.fastjson.JSONObject;

/**
 * 调用会员中心用户类接口返回的响应信息
 * <p>Title: MessageResult</p>
 * <p>Description: </p>
 * <p>Company: AnJie</p> 
 * <p>Copyright: Copyright (c) 2018</p>

 * @author zhangqinghe
 * @date 2018年1月30日 下午1:20:50
 * @version 1.0.0
 */
public class UserInfoMessageResult {
	private String id = new String();
	private String createdDate = new String();
	private String updatedDate = new String();
	private String logicallyDeleted = new String();
	private String sortNumber = new String();
	private String loginName = new String();
	private String password = new String();
	private String mobile = new String();
	private String userType = new String();
	private String name = new String();
	private String cardNo = new String();
	private String gender = new String();
	private String birthday = new String();
	private String idCard = new String();
	private String openid = new String();
	private Double balance = new Double(0);
	private Double point = new Double(0);
	private Double salePoint = new Double(0);
	private String address = new String();
	private String headPhoto = new String();

	public String toString() {
		JSONObject object = new JSONObject();
		object.put("id", id);
		object.put("loginName", loginName);
		object.put("mobile", mobile);
		object.put("userType", userType);
		object.put("name", name);
		object.put("cardNo", cardNo);
		object.put("idCard", idCard);
		object.put("balance", balance);
		object.put("point", point);
		object.put("salePoint", salePoint);
		object.put("address", address);
		return object.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getLogicallyDeleted() {
		return logicallyDeleted;
	}

	public void setLogicallyDeleted(String logicallyDeleted) {
		this.logicallyDeleted = logicallyDeleted;
	}

	public String getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(String sortNumber) {
		this.sortNumber = sortNumber;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	public Double getSalePoint() {
		return salePoint;
	}

	public void setSalePoint(Double salePoint) {
		this.salePoint = salePoint;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHeadPhoto() {
		return headPhoto;
	}

	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}
}
