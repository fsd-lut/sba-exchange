package com.fsd.stock.exchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.stock.exchange.entity.StockExchange;
import com.fsd.stock.exchange.mapper.ExchangeMapper;
import com.fsd.stock.exchange.rspmodel.ListRspModel;
import com.fsd.stock.exchange.rspmodel.RspModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(description = "Exchange Interface")
public class ExchangeController {
	
	@Autowired
	private ExchangeMapper exmapper;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "SBA Account Register")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"), @ApiResponse(code = 202, message = "Account Exist"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "No Authroization"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public ResponseEntity<RspModel> addUser(@ApiParam(name = "body", required = true) @RequestBody StockExchange exchange) {

		try {
			Integer countex = exmapper.checkExchange(exchange.getStockExchangesId());
			if (countex > 0) {
				RspModel rsp = new RspModel();
				rsp.setCode(202);
				rsp.setMessage("Account Exist");
				return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);
			} else {
				StockExchange newexchange = new StockExchange();
			    
				newexchange.setStockExchangesId(exchange.getStockExchangesId());
				newexchange.setStockExchangeBrief(exchange.getStockExchangeBrief());
				newexchange.setContactAddress(exchange.getContactAddress());
				newexchange.setRemarks(exchange.getRemarks());
				exmapper.addExchange(newexchange);

				RspModel rsp = new RspModel();
				rsp.setCode(200);
				rsp.setMessage("Account Created");
				return new ResponseEntity<RspModel>(rsp, HttpStatus.CREATED);
			}

		} catch (Exception ex) {
			RspModel rsp = new RspModel();
			rsp.setCode(500);
			rsp.setMessage(ex.getMessage());
			return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "exchange-list")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"), @ApiResponse(code = 400, message = "error request"),
			@ApiResponse(code = 401, message = "no authorize"), @ApiResponse(code = 404, message = "no such resource"),
			@ApiResponse(code = 500, message = "internal error, contact admin") })
	public ResponseEntity<RspModel> listExchanges(){
		RspModel rsp = new RspModel();
		List<StockExchange> stockExchanges= exmapper.getStockExchangesList();
		rsp.setCode(200);
		rsp.setMessage("success");
		rsp.setData(stockExchanges);
		return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);
	}

}
