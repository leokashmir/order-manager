package com.order.manager.service;

import com.order.manager.model.dto.StockDTO;
import com.order.manager.model.entity.Item;
import com.order.manager.model.stock.request.StockRequest;

import java.util.List;

public interface StockService {

    StockDTO saveStock(StockRequest request);
    StockDTO updateStock(StockDTO request);
    void deleteStock(Long id);
    List<StockDTO> listStock();
    StockDTO getStock(Long id);
    StockDTO findByItem(Item item);
}
