package com.tn.esprit.gestionstock.Service.Stock;


import com.tn.esprit.gestionstock.Entities.Stock;

import java.util.List;

public interface StockService {
    Stock add(Stock stock);
    Stock update(Stock stock, Long id);
    void delete(long id);
    List<Stock> findAll();
    Stock findById(Long id);

}
