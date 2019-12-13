package com.fsd.stock.exchange.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.fsd.stock.exchange.entity.StockExchange;


@Mapper
public interface ExchangeMapper {
	
	@Insert("insert into fsdsba.stockexchange(stockExchangesId,stockExchangeBrief,contactAddress,remarks) values(#{stockExchangesId},#{stockExchangeBrief},#{contactAddress},#{remarks})")
	void addExchange(StockExchange exchange);
	
	@Select("SELECT count(*) FROM fsdsba.stockexchange where stockExchangesId=#{stockExchangesId}")
	Integer checkExchange(@Param("stockExchangesId") String stockExchangesId);
	
	@Select("SELECT stockExchangesId,stockExchangeBrief,contactAddress,remarks FROM fsdsba.stockexchange")
	List<StockExchange> getStockExchangesList();
	
 

}
