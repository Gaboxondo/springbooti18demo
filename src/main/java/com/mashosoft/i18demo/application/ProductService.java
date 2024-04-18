package com.mashosoft.i18demo.application;

import com.mashosoft.i18demo.domain.entity.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(String id);

    public List<Product> getAll();
}
