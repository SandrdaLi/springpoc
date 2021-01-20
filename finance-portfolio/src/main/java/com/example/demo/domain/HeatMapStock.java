package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class HeatMapStock implements Serializable {
	private static final long serialVersionUID = 1L;

	private String symbol;
	private String name;
	private String currency;
	private double price;
	private double priceOpen;
	private double dayHigh;
	private double dayLow;
	private double weekHigh52;
	private double weekLow52;
	private double dayChange;
	private double changePct;
	private double closeYesterday;
	private long marketCap;
	private long volume;
	private long volumeAvg;
	private long shares;
	private String stockExchangeLong;
	private String stockExchangeShort;
	private String timezone;
	private String timezoneName;
	private long gmtOffset;
	private Date lastTradeTime;
	private double pe;
	private double eps;

	@Id
	@Column(name = "symbol")
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "dayChange")
	public double getDayChange() {
		return dayChange;
	}

	public void setDayChange(double dayChange) {
		this.dayChange = dayChange;
	}

	@Column(name = "changePct")
	public double getChangePct() {
		return changePct;
	}

	public void setChangePct(double changePct) {
		this.changePct = changePct;
	}

	@Column(name = "volume")
	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	@Column(name = "volumeAvg")
	public long getVolumeAvg() {
		return volumeAvg;
	}

	public void setVolumeAvg(long volumeAvg) {
		this.volumeAvg = volumeAvg;
	}

	@Column(name = "marketCap")
	public long getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(long marketCap) {
		this.marketCap = marketCap;
	}

	@Column(name = "pe")
	public double getPe() {
		return pe;
	}

	public void setPe(double pe) {
		this.pe = pe;
	}

	@Column(name = "currency")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name = "priceOpen")
	public double getPriceOpen() {
		return priceOpen;
	}

	public void setPriceOpen(double priceOpen) {
		this.priceOpen = priceOpen;
	}

	@Column(name = "dayHigh")
	public double getDayHigh() {
		return dayHigh;
	}

	public void setDayHigh(double dayHigh) {
		this.dayHigh = dayHigh;
	}

	@Column(name = "dayLow")
	public double getDayLow() {
		return dayLow;
	}

	public void setDayLow(double dayLow) {
		this.dayLow = dayLow;
	}

	@Column(name = "weekHigh52")
	public double getWeekHigh52() {
		return weekHigh52;
	}

	public void setWeekHigh52(double weekHigh52) {
		this.weekHigh52 = weekHigh52;
	}

	@Column(name = "weekLow52")
	public double getWeekLow52() {
		return weekLow52;
	}

	public void setWeekLow52(double weekLow52) {
		this.weekLow52 = weekLow52;
	}

	@Column(name = "closeYesterday")
	public double getCloseYesterday() {
		return closeYesterday;
	}

	public void setCloseYesterday(double closeYesterday) {
		this.closeYesterday = closeYesterday;
	}

	@Column(name = "shares")
	public long getShares() {
		return shares;
	}

	public void setShares(long shares) {
		this.shares = shares;
	}

	@Column(name = "stockExchangeLong")
	public String getStockExchangeLong() {
		return stockExchangeLong;
	}

	public void setStockExchangeLong(String stockExchangeLong) {
		this.stockExchangeLong = stockExchangeLong;
	}

	@Column(name = "stockExchangeShort")
	public String getStockExchangeShort() {
		return stockExchangeShort;
	}

	public void setStockExchangeShort(String stockExchangeShort) {
		this.stockExchangeShort = stockExchangeShort;
	}

	@Column(name = "timezone")
	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@Column(name = "timezoneName")
	public String getTimezoneName() {
		return timezoneName;
	}

	public void setTimezoneName(String timezoneName) {
		this.timezoneName = timezoneName;
	}

	@Column(name = "gmtOffset")
	public long getGmtOffset() {
		return gmtOffset;
	}

	public void setGmtOffset(long gmtOffset) {
		this.gmtOffset = gmtOffset;
	}

	@Column(name = "lastTradeTime")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getLastTradeTime() {
		return lastTradeTime;
	}

	public void setLastTradeTime(Date lastTradeTime) {
		this.lastTradeTime = lastTradeTime;
	}

	@Column(name = "eps")
	public double getEps() {
		return eps;
	}

	public void setEps(double eps) {
		this.eps = eps;
	}
}
