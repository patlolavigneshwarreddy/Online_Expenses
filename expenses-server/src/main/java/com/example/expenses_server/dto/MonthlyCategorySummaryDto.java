package com.example.expenses_server.dto;

public class MonthlyCategorySummaryDto {
	int year;
	int month;
	Long categoryid;
	Double totalAmount;
	long expenseCount;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public long getExpenseCount() {
		return expenseCount;
	}

	public void setExpenseCount(long expenseCount) {
		this.expenseCount = expenseCount;
	}

	public MonthlyCategorySummaryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonthlyCategorySummaryDto(int year, int month, long categoryid, Double totalAmount, long expenseCount) {
		super();
		this.year = year;
		this.month = month;
		this.categoryid = categoryid;
		this.totalAmount = totalAmount;
		this.expenseCount = expenseCount;
	}

}
