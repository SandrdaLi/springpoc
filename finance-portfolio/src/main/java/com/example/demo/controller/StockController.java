package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.HeatMapStock;
import com.example.demo.domain.Stock;
import com.example.demo.repository.HeatMapStockRepository;
import com.example.demo.repository.StockRepository;

@RestController
public class StockController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private HeatMapStockRepository heatMapStockrepository;

	@GetMapping("/stocksinportfolio")
	public List<Stock> getStocksInPortfolio() {

		List<Stock> stocksInPortfolio = stockRepository.findAll().stream().filter(s -> s.getPortfolio() != null)
				.collect(Collectors.toList());

		LOGGER.info("{}", "stocksInPortfolio");

		if (stocksInPortfolio == null) {
			throw new RuntimeException("Unable to find stocks in portfolio");
		}

		return stocksInPortfolio;
	}

	@GetMapping("/stocksnotinportfolio")
	public List<Stock> getStocksNotInPortfolio() {

		List<Stock> stocksNotInPortfolio = stockRepository.findAll().stream().filter(s -> s.getPortfolio() == null)
				.collect(Collectors.toList());

		LOGGER.info("{}", "stocksNotInPortfolio");

		if (stocksNotInPortfolio == null) {
			throw new RuntimeException("Unable to find uncategorized stocks");
		}

		return stocksNotInPortfolio;
	}

	@GetMapping("/stocks")
	public List<Stock> getStocks() {

		List<Stock> stocks = stockRepository.findAll();

		LOGGER.info("{}", "stocks");

		if (stocks == null) {
			throw new RuntimeException("Unable to find stocks");
		}

		return stocks;
	}

	@PostMapping("/stock")
	@ResponseStatus(HttpStatus.CREATED)
	public Stock createStock(@RequestBody Stock stockRequest) {
		return stockRepository.save(stockRequest);
	}

	@PostMapping("/stocks")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Stock> createStocks(@RequestBody List<Stock> stockRequest) {
		stockRequest.forEach(s -> {
			stockRepository.save(s);
		});
		return stockRequest;
	}

	@DeleteMapping("/stock/{symbol}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteStock(@PathVariable String symbol) {
		Stock stock = getStockFromRequest(symbol);
		stockRepository.delete(stock);
	}

	@PutMapping("/stock/{symbol}")
	@ResponseStatus(HttpStatus.OK)
	public Stock updateStock(@PathVariable String symbol, @RequestBody Stock stockRequest) {
		Stock stock = getStockFromRequest(symbol);
		stock.setSymbol(stockRequest.getSymbol());
		stock.setName(stockRequest.getName());
		stock.setPrice(stockRequest.getPrice());
		stock.setDayChange(stockRequest.getDayChange());
		stock.setChangePct(stockRequest.getChangePct());
		stock.setVolume(stockRequest.getVolume());
		stock.setVolumeAvg(stockRequest.getVolumeAvg());
		stock.setMarketCap(stockRequest.getMarketCap());
		stock.setPe(stockRequest.getPe());
		stock.setIntraday(stockRequest.getIntraday());
		return stockRepository.save(stock);
	}

	@GetMapping("/stock/{symbol}")
	@ResponseStatus(HttpStatus.OK)
	public Stock getStock(@PathVariable String symbol) {
		return getStockFromRequest(symbol);
	}

	private Stock getStockFromRequest(String symbol) {
		Stock stock = stockRepository.findById(symbol).get();
		if (stock == null) {
			// exceptionFactory.throwObjectNotFound(symbol);
			throw new RuntimeException("Unable to find stock");
		}
		return stock;
	}

	@GetMapping("/heatmapstocks")
	public List<HeatMapStock> getHeatMapStocks() {

		List<HeatMapStock> heatMapStocks = heatMapStockrepository.findAll();

		LOGGER.info("{}", "heatMapStocks");

		if (heatMapStocks == null) {
			throw new RuntimeException("Unable to find headMap stocks");
		}

		return heatMapStocks;
	}

	@PostMapping("/heatmapstock")
	@ResponseStatus(HttpStatus.CREATED)
	public HeatMapStock createHeatMapStock(@RequestBody HeatMapStock heatMapStockRequest) {
		return heatMapStockrepository.save(heatMapStockRequest);
	}

	@PostMapping("/heatmapstocks")
	@ResponseStatus(HttpStatus.CREATED)
	public List<HeatMapStock> createHeatMapStocks(@RequestBody List<HeatMapStock> heatMapStockRequest) {
		heatMapStockRequest.forEach(h -> {
			heatMapStockrepository.save(h);
		});
		return heatMapStockRequest;
	}

}
