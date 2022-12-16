package com.order.manager.service.impl;

import com.order.manager.exceptions.GenericException;
import com.order.manager.model.dto.StockDTO;
import com.order.manager.model.entity.Item;
import com.order.manager.model.entity.StockMovement;
import com.order.manager.model.stock.request.StockRequest;
import com.order.manager.repository.StockMovementRepository;
import com.order.manager.service.StockService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class StockServiceImpl implements StockService {

    private static final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);
    @Autowired
    private StockMovementRepository repository;

    @Override
    public StockDTO saveStock(StockRequest request) {
        StockMovement stock = repository.save(convertToModel(request));
        return convertToDto(stock);
    }

    @Override
    public StockDTO updateStock(StockDTO request) {
        StockMovement stock = repository.save(convertToModel(request));
        return convertToDto(stock);
    }

    @Override
    public void deleteStock(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<StockDTO> listStock() {

        List<StockMovement> lstStock = repository.findAll();

        return lstStock.stream().map(obj ->
                StockDTO.builder()
                        .id(obj.getId())
                        .creationDate(obj.getCreationDate())
                        .item(obj.getItem())
                        .quantity(obj.getQuantity())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public StockDTO getStock(Long id) {
        Optional<StockMovement> op = repository.findById(id);
        return convertToDto(op.orElseThrow(GenericException::new));
    }

    @Override
    public StockDTO findByItem(Item item) {
        return convertToDto(repository.findByItem(item));
    }


    private StockMovement convertToModel(StockRequest request) {
        StockMovement stock = new StockMovement();
        stock.setItem(new Item(request.getItem()));
        stock.setCreationDate(LocalDate.now());
        stock.setQuantity(request.getQuantity());
        return stock;
    }

    private StockMovement convertToModel(StockDTO request) {
        StockMovement stock = new StockMovement();
        stock.setId(request.getId());
        stock.setItem(request.getItem());
        stock.setCreationDate(LocalDate.now());
        stock.setQuantity(request.getQuantity());

        return stock;
    }

    private StockDTO convertToDto(StockMovement stock) {
        return StockDTO.builder()
                .id(stock.getId())
                .quantity(stock.getQuantity())
                .creationDate(stock.getCreationDate())
                .item(stock.getItem())
                .build();
    }
}
