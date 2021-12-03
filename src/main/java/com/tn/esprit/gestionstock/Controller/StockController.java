package com.tn.esprit.gestionstock.Controller;

import com.tn.esprit.gestionstock.Entities.Stock;
import com.tn.esprit.gestionstock.Service.Stock.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Stock management")
@RequestMapping("/stock/")
public class StockController  {

    @Autowired
    private StockService stockService;

    @ApiOperation(value = "Add stock ")
    @PostMapping("add")
    public Stock add(@Valid @RequestBody Stock stock) {
        return stockService.add(stock);
    }

    @ApiOperation(value = "Update stock ")
    @PutMapping("update/{id}")
    public Stock update(@Valid @RequestBody Stock stock,@PathVariable("id") Long id) {
        return stockService.update(stock, id);
    }

    @ApiOperation(value = "Delete stock")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        stockService.delete(id);
    }

    @ApiOperation(value = "Retreive all stocks")
    @GetMapping("list")
    public List<Stock> findAll() {
        return stockService.findAll();
    }

    @ApiOperation(value = "Find stock by provided id")
    @GetMapping("findById/{id}")
    public Stock findById(@PathVariable("id") Long id) {
        return stockService.findById(id);
    }
}
