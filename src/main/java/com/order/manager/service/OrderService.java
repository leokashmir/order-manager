package com.order.manager.service;

import com.order.manager.model.dto.OrderDTO;
import com.order.manager.model.dto.StockDTO;
import com.order.manager.model.order.request.OrderRequest;
import com.order.manager.model.stock.request.StockRequest;

import java.util.List;

public interface OrderService {


    OrderDTO saveOrder(OrderRequest request);
    OrderDTO updateOrder(OrderDTO request);
    void deleteOrder(Long id);
    List<OrderDTO> listOrder();
    OrderDTO getOrder(Long id);
}
