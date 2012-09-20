//~ Generate by genthemall
package com.ii2d.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="unit")
public class Unit extends com.ii2d.dbase.mybatis.model.BaseMyBatisModel {
	
	private static final long serialVersionUID = 1L;
	
	protected java.lang.Integer id;
	protected java.lang.String oldId;
	protected java.lang.Integer unitTypeId;
	protected java.lang.String name;
	protected java.lang.Integer showOrder;
	protected java.lang.String pinYinName;
	protected java.lang.String simplePinYinName;
	
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
	
	public void setUnitTypeId(java.lang.Integer unitTypeId) {
		this.unitTypeId = unitTypeId;
	}
	public java.lang.Integer getUnitTypeId() {
		return this.unitTypeId;
	}
	
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setShowOrder(java.lang.Integer showOrder) {
		this.showOrder = showOrder;
	}
	public java.lang.Integer getShowOrder() {
		return this.showOrder;
	}
	
	public void setPinYinName(java.lang.String pinYinName) {
		this.pinYinName = pinYinName;
	}
	public java.lang.String getPinYinName() {
		return this.pinYinName;
	}
	
	public void setSimplePinYinName(java.lang.String simplePinYinName) {
		this.simplePinYinName = simplePinYinName;
	}
	public java.lang.String getSimplePinYinName() {
		return this.simplePinYinName;
	}
	
	
	/**
	 * Generate by genthemall
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("com.ii2d.model.Unit.toString {\n\t");
		
		sb.append("id: [");
		sb.append(this.id);
		sb.append("], ");
		sb.append("oldId: [");
		sb.append(this.oldId);
		sb.append("], ");
		sb.append("unitTypeId: [");
		sb.append(this.unitTypeId);
		sb.append("], ");
		sb.append("name: [");
		sb.append(this.name);
		sb.append("], ");
		sb.append("showOrder: [");
		sb.append(this.showOrder);
		sb.append("], ");
		sb.append("pinYinName: [");
		sb.append(this.pinYinName);
		sb.append("], ");
		sb.append("simplePinYinName: [");
		sb.append(this.simplePinYinName);
		sb.append("], ");
		sb.append("\n}");
		return sb.toString();
	}
}