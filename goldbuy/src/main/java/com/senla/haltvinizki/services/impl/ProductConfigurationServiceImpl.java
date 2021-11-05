package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.impl.ProductConfigurationDaoImpl;
import com.senla.haltvinizki.entity.productCofniguration.ProductConfiguration;
import com.senla.haltvinizki.services.ProductConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductConfigurationServiceImpl implements ProductConfigurationService {
    @Autowired
    private final ProductConfigurationDaoImpl productConfigurationDao;

    public ProductConfigurationServiceImpl(ProductConfigurationDaoImpl productConfigurationDao) {
        this.productConfigurationDao = productConfigurationDao;
    }

    @Override
    public ProductConfiguration delete(ProductConfiguration productConfiguration) {
        return productConfigurationDao.delete(productConfiguration);
    }

    @Override
    public ProductConfiguration create(ProductConfiguration productConfiguration) {
        return productConfigurationDao.create(productConfiguration);
    }

    @Override
    public ProductConfiguration update(ProductConfiguration productConfiguration) {
        return productConfigurationDao.update(productConfiguration);
    }

    @Override
    public List<ProductConfiguration> read() {
        return productConfigurationDao.read();
    }
}