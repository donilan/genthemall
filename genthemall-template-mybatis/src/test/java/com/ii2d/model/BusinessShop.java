//~ Generate by genthemall
package com.ii2d.model;

public class BusinessShop extends com.ii2d.model.Shop {
	
	private static final long serialVersionUID = 1L;
	
	protected java.lang.Integer shopId;
	protected java.lang.String tmpName;
	
	public void setShopId(java.lang.Integer shopId) {
		this.shopId = shopId;
	}
	public java.lang.Integer getShopId() {
		return this.shopId;
	}
	
	public void setTmpName(java.lang.String tmpName) {
		this.tmpName = tmpName;
	}
	public java.lang.String getTmpName() {
		return this.tmpName;
	}
	
	
	/**
	 * Generate by genthemall
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("com.ii2d.model.BusinessShop.toString {\n\t");
		
		sb.append("shopId: [");
		sb.append(this.shopId);
		sb.append("], ");
		sb.append("tmpName: [");
		sb.append(this.tmpName);
		sb.append("], ");
		sb.append("id: [");
		sb.append(this.id);
		sb.append("], ");
		sb.append("userId: [");
		sb.append(this.userId);
		sb.append("], ");
		sb.append("name: [");
		sb.append(this.name);
		sb.append("], ");
		sb.append("status: [");
		sb.append(this.status);
		sb.append("], ");
		sb.append("deleted: [");
		sb.append(this.deleted);
		sb.append("], ");
		sb.append("createDate: [");
		sb.append(this.createDate);
		sb.append("], ");
		sb.append("contact: [");
		sb.append(this.contact);
		sb.append("], ");
		sb.append("zipCode: [");
		sb.append(this.zipCode);
		sb.append("], ");
		sb.append("telephone: [");
		sb.append(this.telephone);
		sb.append("], ");
		sb.append("phone: [");
		sb.append(this.phone);
		sb.append("], ");
		sb.append("fax: [");
		sb.append(this.fax);
		sb.append("], ");
		sb.append("email: [");
		sb.append(this.email);
		sb.append("], ");
		sb.append("address: [");
		sb.append(this.address);
		sb.append("], ");
		sb.append("\n}");
		return sb.toString();
	}
}