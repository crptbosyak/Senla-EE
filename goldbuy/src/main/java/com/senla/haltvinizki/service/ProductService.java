package com.senla.haltvinizki.service;

import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.dto.product.ProductWithCategoryDto;
import com.senla.haltvinizki.dto.product.ProductWithUserDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProductService {
    ProductInfoDto delete(Long id);

    ProductInfoDto create(ProductInfoDto productDto);

    ProductInfoDto update(ProductInfoDto productDto);

    ProductInfoDto getById(Long id);

    ProductInfoDto getMostExpensiveProduct();

    ProductWithUserDto getProductWithUser(Long id);

    ProductWithCategoryDto getProductWithCategory(Long id);

    List<ProductInfoDto> getActiveProducts();

}
