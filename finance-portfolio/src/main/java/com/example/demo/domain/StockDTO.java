package com.example.demo.domain;

import lombok.Data;

@Data
public class StockDTO {
	private String symbol;
	private String portfolio;
	private String name;
	private double price;
	private double dayChange;
	private double changePct;
	private long volume;
	private long volumeAvg;
	private long marketCap;
	private double pe;

	public StockDTO(Stock stock) {
		super();
		this.symbol = stock.getSymbol();
		this.portfolio = stock.getPortfolio();
		this.name = stock.getName();
		this.price = stock.getPrice();
		this.dayChange = stock.getDayChange();
		this.changePct = stock.getChangePct();
		this.volume = stock.getVolume();
		this.volumeAvg = stock.getVolumeAvg();
		this.marketCap = stock.getMarketCap();
		this.pe = stock.getPe();
	}

}
