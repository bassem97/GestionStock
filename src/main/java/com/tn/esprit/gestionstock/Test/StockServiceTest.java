package com.tn.esprit.gestionstock.Test;

import com.tn.esprit.gestionstock.Entities.Stock;
import com.tn.esprit.gestionstock.Service.Stock.StockService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StockServiceTest {
    @Autowired
    private StockService stockService;

    @Test
    @Ignore
    public void testAddStock() {
        List<Stock> stocks = stockService.findAll();
        int expected = stocks.size();
        Stock stock = new Stock(20,2,"stock 1");
        Stock savedStock= stockService.add(stock);
        assertEquals(expected + 1, stockService.findAll().size());
        assertNotNull(savedStock.getIdStock());
        stockService.delete(savedStock.getIdStock());
    }

    @Test
    @Ignore
    public void testListStock() {
        stockService.findAll()
                .forEach( stock -> log.info("Stock :"+ stock));
    }

//    @Test
//    @Ignore
//    public void testRetrieveStatusStock(){
//        log.info("Status stock ID 1 : "+stockService.retrieveStatusStock(1L));
//    }
}