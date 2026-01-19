package com.example.category_server.dto;

public class CategoryDto {

	Long categoryId;
	String name;

	public CategoryDto(Long categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryDto [categoryId=" + categoryId + ", name=" + name + "]";
	}

}
