package com.fsd.stock.exchange.rspmodel;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fsd.stock.exchange.entity.StockExchange;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Sector action model")
public class ListRspModel {
	
	@ApiModelProperty(notes = "code", example = "200", required = true, dataType = "java.lang.Integer")
	@NotNull
	private Integer code;
	
	@ApiModelProperty(notes = "message", example = "Created", required = true, dataType = "java.lang.String")
	@NotNull
	private String message;
	
	@ApiModelProperty(notes = "data", required = true, dataType = "java.lang.Object")
	private List<StockExchange> data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<StockExchange> getData() {
		return data;
	}

	public void setData(List<StockExchange> data) {
		this.data = data;
	}
	
		

}

