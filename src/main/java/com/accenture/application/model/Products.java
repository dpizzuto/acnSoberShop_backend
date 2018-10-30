package com.accenture.application.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductCollection")
public class Products {

	@Id
	public ObjectId _id;
	public String productName;
	public String productCode;
	public String description;
	public String type;
	public Double price;

	// Constructors
	public Products() {

	}

	public Products(ObjectId _id, String productName, String productCode, String description, String type,
			Double price) {
		this._id = _id;
		this.productName = productName;
		this.productCode = productCode;
		this.description = description;
		this.type = type;
		this.price = price;
	}

	// Getter and Setter
	// NB ObjectId needs to be converted to string
	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String ToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("productName: ");
		builder.append(productName);
		builder.append(", productCode: ");
		builder.append(productCode);
		builder.append(", description: ");
		builder.append(description);
		builder.append(", type: ");
		builder.append(type);
		builder.append(", price: ");
		builder.append(price);

		return builder.toString();
	}
}