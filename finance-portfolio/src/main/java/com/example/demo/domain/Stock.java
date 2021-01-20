package com.example.demo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "symbol")
	@JoinColumn
	private String symbol;
	@Column(name = "portfolio")
	private String portfolio;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private double price;
	@Column(name = "dayChange")
	private double dayChange;
	@Column(name = "changePct")
	private double changePct;
	@Column(name = "volume")
	private long volume;
	@Column(name = "volumeAvg")
	private long volumeAvg;
	@Column(name = "marketCap")
	private long marketCap;
	@Column(name = "pe")
	private double pe;
	@ElementCollection // 1
	@CollectionTable(name = "intradayChange", joinColumns = @JoinColumn(name = "symbol")) // 2
	@Column(name = "intradayChange") // 3
	private List<Double> intradayChange;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDayChange() {
		return dayChange;
	}

	public void setDayChange(double dayChange) {
		this.dayChange = dayChange;
	}

	public double getChangePct() {
		return changePct;
	}

	public void setChangePct(double changePct) {
		this.changePct = changePct;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public long getVolumeAvg() {
		return volumeAvg;
	}

	public void setVolumeAvg(long volumeAvg) {
		this.volumeAvg = volumeAvg;
	}

	public long getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(long marketCap) {
		this.marketCap = marketCap;
	}

	public double getPe() {
		return pe;
	}

	public void setPe(double pe) {
		this.pe = pe;
	}

	public List<Double> getIntraday() {
		return intradayChange;
	}

	public void setIntraday(List<Double> intraday) {
		this.intradayChange = intraday;
	}

}
