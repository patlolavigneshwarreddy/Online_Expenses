package com.example.category_server.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId; // ✅ auto-increment

	@Column(unique = true, nullable = false)
	private String categoryname;

	@Column(nullable = true)
	private String description;

	@Column(nullable = true)
	private Timestamp currenttime;

	@Column(nullable = true)
	private Timestamp updatetime;

	public Category() {
		super();
		// TODO Auto-generated constructor stub

	}

	public Category(Long categoryId, String categoryname, String description, Timestamp currenttime,
			Timestamp updatetime) {
		super();
		this.categoryId = categoryId;
		this.categoryname = categoryname;
		this.description = description;
		this.currenttime = currenttime;
		this.updatetime = updatetime;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryname=" + categoryname + ", description=" + description
				+ ", currenttime=" + currenttime + ", updatetime=" + updatetime + "]";
	}
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCurrenttime() {
		return currenttime;
	}

	public void setCurrenttime(Timestamp currenttime) {
		this.currenttime = currenttime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	
}
