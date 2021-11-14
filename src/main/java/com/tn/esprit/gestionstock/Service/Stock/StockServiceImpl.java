package com.tn.esprit.gestionstock.Service.Stock;

import com.tn.esprit.gestionstock.Entities.Stock;
import com.tn.esprit.gestionstock.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock add(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock update(Stock stock, Long id) {
        return null;
    }

    @Override
    public void delete(long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }


    @Override
    public Stock findById(Long id) {
        return stockRepository.getById(id);
    }


}
