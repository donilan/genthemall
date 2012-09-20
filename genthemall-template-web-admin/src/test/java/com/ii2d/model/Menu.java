//~ Generate by genthemall
package com.ii2d.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="menu")
public class Menu extends com.ii2d.dbase.mybatis.model.BaseMyBatisModel {
	
	private static final long serialVersionUID = 1L;
	
	protected java.lang.Integer id;
	protected java.lang.Integer parentId;
	protected java.lang.Integer menuTypeId;
	protected java.lang.String menuKey;
	protected java.lang.String name;
	protected java.lang.String uri;
	protected java.lang.Integer status;
	protected java.util.Date createDate;
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setParentId(java.lang.Integer parentId) {
		this.parentId = parentId;
	}
	public java.lang.Integer getParentId() {
		return this.parentId;
	}
	
	public void setMenuTypeId(java.lang.Integer menuTypeId) {
		this.menuTypeId = menuTypeId;
	}
	public java.lang.Integer getMenuTypeId() {
		return this.menuTypeId;
	}
	
	public void setMenuKey(java.lang.String menuKey) {
		this.menuKey = menuKey;
	}
	public java.lang.String getMenuKey() {
		return this.menuKey;
	}
	
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setUri(java.lang.String uri) {
		this.uri = uri;
	}
	public java.lang.String getUri() {
		return this.uri;
	}
	
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	
	
	/**
	 * Generate by genthemall
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("com.ii2d.model.Menu.toString {\n\t");
		
		sb.append("id: [");
		sb.append(this.id);
		sb.append("], ");
		sb.append("parentId: [");
		sb.append(this.parentId);
		sb.append("], ");
		sb.append("menuTypeId: [");
		sb.append(this.menuTypeId);
		sb.append("], ");
		sb.append("menuKey: [");
		sb.append(this.menuKey);
		sb.append("], ");
		sb.append("name: [");
		sb.append(this.name);
		sb.append("], ");
		sb.append("status: [");
		sb.append(this.status);
		sb.append("], ");
		sb.append("createDate: [");
		sb.append(this.createDate);
		sb.append("], ");
		sb.append("\n}");
		return sb.toString();
	}
}