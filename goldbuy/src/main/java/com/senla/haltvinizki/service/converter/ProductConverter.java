package com.senla.haltvinizki.service.converter;

import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.dto.product.ProductWithCategoryDto;
import com.senla.haltvinizki.dto.product.ProductWithUserDto;
import com.senla.haltvinizki.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {
    @Autowired
    private ModelMapper mapper;

    public Product convert(ProductInfoDto productInfoDto) {
        return mapper.map(productInfoDto, Product.class);
    }

    public ProductInfoDto convert(Product product) {
        return mapper.map(product, ProductInfoDto.class);
    }

    public Product convert(ProductWithCategoryDto productWithCategoryDto) {
        return mapper.map(productWithCategoryDto, Product.class);
    }

    public Product convert(ProductWithUserDto productWithUserDto) {
        return mapper.map(productWithUserDto, Product.class);
    }

    public ProductWithUserDto convertWithUser(Product product) {
        return mapper.map(product, ProductWithUserDto.class);
    }

    public ProductWithCategoryDto convertWithCategory(Product product) {
        return mapper.map(product, ProductWithCategoryDto.class);
    }

    public List<ProductInfoDto> convert(List<Product> productList) {
        return productList.stream().
                map(product -> mapper.map(product, ProductInfoDto.class))
                .collect(Collectors.toList());
    }

}