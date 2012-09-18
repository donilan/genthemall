//~ Generate by genthemall
package com.ii2d.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="userAbcInfo")
public class UserAbcInfo extends com.ii2d.dbase.mybatis.model.BaseMyBatisModel {
	
	private static final long serialVersionUID = 1L;
	
	protected java.lang.Integer id;
	protected java.lang.Integer userId;
	protected java.lang.Integer signStatus;
	protected java.lang.String customerNo;
	protected java.lang.String customerName;
	protected java.lang.Integer authorizeStatus;
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setSignStatus(java.lang.Integer signStatus) {
		this.signStatus = signStatus;
	}
	public java.lang.Integer getSignStatus() {
		return this.signStatus;
	}
	
	public void setCustomerNo(java.lang.String customerNo) {
		this.customerNo = customerNo;
	}
	public java.lang.String getCustomerNo() {
		return this.customerNo;
	}
	
	public void setCustomerName(java.lang.String customerName) {
		this.customerName = customerName;
	}
	public java.lang.String getCustomerName() {
		return this.customerName;
	}
	
	public void setAuthorizeStatus(java.lang.Integer authorizeStatus) {
		this.authorizeStatus = authorizeStatus;
	}
	public java.lang.Integer getAuthorizeStatus() {
		return this.authorizeStatus;
	}
	
	
	/**
	 * Generate by genthemall
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("com.ii2d.model.UserAbcInfo.toString {\n\t");
		
		sb.append("id: [");
		sb.append(this.id);
		sb.append("], ");
		sb.append("userId: [");
		sb.append(this.userId);
		sb.append("], ");
		sb.append("signStatus: [");
		sb.append(this.signStatus);
		sb.append("], ");
		sb.append("customerNo: [");
		sb.append(this.customerNo);
		sb.append("], ");
		sb.append("customerName: [");
		sb.append(this.customerName);
		sb.append("], ");
		sb.append("authorizeStatus: [");
		sb.append(this.authorizeStatus);
		sb.append("], ");
		sb.append("\n}");
		return sb.toString();
	}
}