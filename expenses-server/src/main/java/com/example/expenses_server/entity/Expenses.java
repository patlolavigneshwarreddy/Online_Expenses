package com.example.expenses_server.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "expenses")
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long userId;

	@Column(nullable = false)
	private Long categoryId;

	@Column(nullable = false)
	private double debitamount;

	@Column(nullable = true)
	private String description;

	// Automatically set when entity is created
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime currenttime;

	// Automatically updated whenever entity is updated
	@UpdateTimestamp
	@Column(nullable = true)
	private LocalDateTime updatetime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public double getDebitamount() {
		return debitamount;
	}

	public void setDebitamount(double debitamount) {
		this.debitamount = debitamount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCurrenttime() {
		return currenttime;
	}

	public void setCurrenttime(LocalDateTime currenttime) {
		this.currenttime = currenttime;
	}

	public LocalDateTime getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(LocalDateTime updatetime) {
		this.updatetime = updatetime;
	}

	public Expenses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Expenses(Long id, Long userId, Long categoryId, double debitamount, String description,
			LocalDateTime currenttime, LocalDateTime updatetime) {
		super();
		id = id;
		this.userId = userId;
		this.categoryId = categoryId;
		this.debitamount = debitamount;
		this.description = description;
		this.currenttime = currenttime;
		this.updatetime = updatetime;
	}

	@Override
	public String toString() {
		return "Expenses [Id=" + id + ", userId=" + userId + ", categoryId=" + categoryId + ", debitamount="
				+ debitamount + ", description=" + description + ", currenttime=" + currenttime + ", updatetime="
				+ updatetime + "]";
	}

}
