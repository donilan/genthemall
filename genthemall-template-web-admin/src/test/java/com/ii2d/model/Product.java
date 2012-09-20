//~ Generate by genthemall
package com.ii2d.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="product")
public class Product extends com.ii2d.dbase.mybatis.model.BaseMyBatisModel {
	
	private static final long serialVersionUID = 1L;
	
	protected java.lang.Integer id;
	protected java.lang.String oldId;
	protected java.lang.Integer productTypeId;
	protected java.lang.Integer originAreaId;
	protected java.lang.Integer shopId;
	protected java.lang.Integer unitId;
	protected java.lang.String hnCode;
	protected java.lang.String name;
	protected java.lang.Integer status;
	protected java.util.Date createDate;
	protected java.lang.String description;
	protected java.lang.Integer showOrder;
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setOldId(java.lang.String oldId) {
		this.oldId = oldId;
	}
	public java.lang.String getOldId() {
		return this.oldId;
	}
	
	public void setProductTypeId(java.lang.Integer productTypeId) {
		this.productTypeId = productTypeId;
	}
	public java.lang.Integer getProductTypeId() {
		return this.productTypeId;
	}
	
	public void setOriginAreaId(java.lang.Integer originAreaId) {
		this.originAreaId = originAreaId;
	}
	public java.lang.Integer getOriginAreaId() {
		return this.originAreaId;
	}
	
	public void setShopId(java.lang.Integer shopId) {
		this.shopId = shopId;
	}
	public java.lang.Integer getShopId() {
		return this.shopId;
	}
	
	public void setUnitId(java.lang.Integer unitId) {
		this.unitId = unitId;
	}
	public java.lang.Integer getUnitId() {
		return this.unitId;
	}
	
	public void setHnCode(java.lang.String hnCode) {
		this.hnCode = hnCode;
	}
	public java.lang.String getHnCode() {
		return this.hnCode;
	}
	
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getName() {
		return this.name;
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
		sb.append("com.ii2d.model.Product.toString {\n\t");
		
		sb.append("id: [");
		sb.append(this.id);
		sb.append("], ");
		sb.append("oldId: [");
		sb.append(this.oldId);
		sb.append("], ");
		sb.append("productTypeId: [");
		sb.append(this.productTypeId);
		sb.append("], ");
		sb.append("originAreaId: [");
		sb.append(this.originAreaId);
		sb.append("], ");
		sb.append("shopId: [");
		sb.append(this.shopId);
		sb.append("], ");
		sb.append("unitId: [");
		sb.append(this.unitId);
		sb.append("], ");
		sb.append("hnCode: [");
		sb.append(this.hnCode);
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
		sb.append("showOrder: [");
		sb.append(this.showOrder);
		sb.append("], ");
		sb.append("\n}");
		return sb.toString();
	}
}