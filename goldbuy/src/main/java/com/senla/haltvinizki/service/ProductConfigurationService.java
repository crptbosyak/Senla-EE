package com.senla.haltvinizki.service;

import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationInfoDto;
import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationWithProductDto;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProductConfigurationService {
    ProductConfigurationInfoDto delete(Long id);

    ProductConfigurationInfoDto create(ProductConfigurationInfoDto productConfigurationDto);

    ProductConfigurationInfoDto update(ProductConfigurationInfoDto productConfigurationDto);

    ProductConfigurationInfoDto getById(Long id);

    ProductConfigurationWithProductDto getProductConfigWithProduct(Long id);
}
