package com.fsd.stock.exchange.entity;

public class StockExchange {
	
	private String stockExchangesId;
	private String stockExchangeBrief;
	private String contactAddress;
	private String remarks;
	public String getStockExchangesId() {
		return stockExchangesId;
	}
	public void setStockExchangesId(String stockExchangesId) {
		this.stockExchangesId = stockExchangesId;
	}
	public String getStockExchangeBrief() {
		return stockExchangeBrief;
	}
	public void setStockExchangeBrief(String stockExchangeBrief) {
		this.stockExchangeBrief = stockExchangeBrief;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Stockexchange [stockExchangesId=" + stockExchangesId + ", stockExchangeBrief=" + stockExchangeBrief
				+ ", contactAddress=" + contactAddress + ", remarks=" + remarks + "]";
	}
	public StockExchange(String stockExchangesId, String stockExchangeBrief, String contactAddress, String remarks) {
		super();
		this.stockExchangesId = stockExchangesId;
		this.stockExchangeBrief = stockExchangeBrief;
		this.contactAddress = contactAddress;
		this.remarks = remarks;
	}
	public StockExchange() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
