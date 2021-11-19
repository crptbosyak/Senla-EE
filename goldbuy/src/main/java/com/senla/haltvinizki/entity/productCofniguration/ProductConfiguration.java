package com.senla.haltvinizki.entity.productCofniguration;

import com.senla.haltvinizki.entity.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "productConfig")
@NamedEntityGraph(name = "prodconfig-product", attributeNodes = @NamedAttributeNode("product"))

public class ProductConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "maxPrice")
    private float maxPrice;
    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Product product;
    @Column(name = "minPrice")
    private float minPrice;
    @Column(name = "priceStep")
    private float priceStep;
    @Column(name = "frequency")
    private int frequency;

    public ProductConfiguration() {
    }


    public ProductConfiguration(int id, float maxPrice, Product product, float minPrice, float priceStep, int frequency) {
        this.id = id;
        this.maxPrice = maxPrice;
        this.product = product;
        this.minPrice = minPrice;
        this.priceStep = priceStep;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }

    public Float getPriceStep() {
        return priceStep;
    }

    public void setPriceStep(float priceStep) {
        this.priceStep = priceStep;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }


}
