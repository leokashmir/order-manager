package com.order.manager.service;

import com.order.manager.model.dto.OrderDTO;
import com.order.manager.model.dto.StockDTO;
import com.order.manager.model.order.request.OrderRequest;
import com.order.manager.model.stock.request.StockRequest;

import java.util.List;

public interface OrderService {


    OrderDTO saveItem(OrderRequest request);
    OrderDTO updateItem(OrderDTO request);
    void deleteItem(Long id);
    List<OrderDTO> listItem();
    OrderDTO getItem(Long id);
}
