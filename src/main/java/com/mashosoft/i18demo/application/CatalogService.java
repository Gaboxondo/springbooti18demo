package com.mashosoft.i18demo.application;

import com.mashosoft.i18demo.domain.entity.Catalog;

import java.util.List;

public interface CatalogService {

    public List<Catalog> getcatalogsByTypes(String type);

    public List<Catalog> getAll();
}
