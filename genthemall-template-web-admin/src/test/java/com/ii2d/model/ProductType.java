//~ Generate by genthemall
package com.ii2d.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="productType")
public class ProductType extends com.ii2d.dbase.mybatis.model.BaseMyBatisModel {
	
	private static final long serialVersionUID = 1L;
	
	protected java.lang.Integer id;
	protected java.lang.Integer parentId;
	protected java.lang.String oldId;
	protected java.lang.String name;
	protected java.lang.String pinYinName;
	protected java.util.Date createDate;
	protected java.lang.Integer status;
	protected java.lang.String treeCode;
	protected java.lang.String parentTreeCode;
	protected java.lang.String description;
	protected java.lang.Integer showOrder;
	
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
	
	public void setOldId(java.lang.String oldId) {
		this.oldId = oldId;
	}
	public java.lang.String getOldId() {
		return this.oldId;
	}
	
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setPinYinName(java.lang.String pinYinName) {
		this.pinYinName = pinYinName;
	}
	public java.lang.String getPinYinName() {
		return this.pinYinName;
	}
	
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
	public void setTreeCode(java.lang.String treeCode) {
		this.treeCode = treeCode;
	}
	public java.lang.String getTreeCode() {
		return this.treeCode;
	}
	
	public void setParentTreeCode(java.lang.String parentTreeCode) {
		this.parentTreeCode = parentTreeCode;
	}
	public java.lang.String getParentTreeCode() {
		return this.parentTreeCode;
	}
	
	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	public java.lang.String getDescription() {
		return this.description;
	}
	
	public void setShowOrder(java.lang.Integer showOrder) {
		this.showOrder = showOrder;
	}
	public java.lang.Integer getShowOrder() {
		return this.showOrder;
	}
	
	
	/**
	 * Generate by genthemall
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("com.ii2d.model.ProductType.toString {\n\t");
		
		sb.append("id: [");
		sb.append(this.id);
		sb.append("], ");
		sb.append("parentId: [");
		sb.append(this.parentId);
		sb.append("], ");
		sb.append("oldId: [");
		sb.append(this.oldId);
		sb.append("], ");
		sb.append("name: [");
		sb.append(this.name);
		sb.append("], ");
		sb.append("pinYinName: [");
		sb.append(this.pinYinName);
		sb.append("], ");
		sb.append("createDate: [");
		sb.append(this.createDate);
		sb.append("], ");
		sb.append("status: [");
		sb.append(this.status);
		sb.append("], ");
		sb.append("treeCode: [");
		sb.append(this.treeCode);
		sb.append("], ");
		sb.append("parentTreeCode: [");
		sb.append(this.parentTreeCode);
		sb.append("], ");
		sb.append("showOrder: [");
		sb.append(this.showOrder);
		sb.append("], ");
		sb.append("\n}");
		return sb.toString();
	}
}