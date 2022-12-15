package com.order.manager.service;

import com.order.manager.model.dto.StockDTO;
import com.order.manager.model.stock.request.StockRequest;

import java.util.List;

public interface StockService {

    StockDTO saveItem(StockRequest request);
    StockDTO updateItem(StockDTO request);
    void deleteItem(Long id);
    List<StockDTO> listItem();
    StockDTO getItem(Long id);

}
