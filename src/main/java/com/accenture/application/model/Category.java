package com.accenture.application.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CategoryCollection")
public class Category {

	@Id
	public ObjectId _id;
	public String categoryName;
	public String categoryCode;
	public String description;

	// Constructors
	public Category() {

	}

	public categorys(ObjectId _id, String categoryName, String categoryCode, String description) {
		this._id = _id;
		this.categoryName = categoryName;
		this.categoryCode = categoryCode;
		this.description = description;
	}

	// Getter and Setter
	// NB ObjectId needs to be converted to string
	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String ToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("categoryName: ");
		builder.append(categoryName);
		builder.append(", categoryCode: ");
		builder.append(categoryCode);
		builder.append(", description: ");
		builder.append(description);

		return builder.toString();
	}
}