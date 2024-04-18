package com.mashosoft.i18demo.domain.repository;

import com.mashosoft.i18demo.domain.entity.Product;

import java.util.List;

public interface ProductRepository {

    Product getProductFromDatabaseById(String id);

    List<Product> getAllFromDatabase();
}
