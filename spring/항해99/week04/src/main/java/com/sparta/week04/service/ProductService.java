package com.sparta.week04.service;

import com.sparta.week04.models.ItemDto;
import com.sparta.week04.models.Product;
import com.sparta.week04.models.ProductMypriceRequestDto;
import com.sparta.week04.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Component
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMypriceRequestDto requestDto){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("희희")
        );
        product.update(requestDto);
        return id;
    }

    @Transactional
    public Long updateBySearch(Long id, ItemDto itemDto){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("화화")
        );
        product.updateByItemDto(itemDto);
        return id;
    }
}
