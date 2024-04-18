package com.mashosoft.i18demo.interfaces.web.adapter;

import com.mashosoft.i18demo.interfaces.web.dto.ProductDTO;

import java.util.List;

public interface ProductWebInterfaceAdapter {

    public ProductDTO getProductById(String id);

    public List<ProductDTO> getAllProducts();
}
