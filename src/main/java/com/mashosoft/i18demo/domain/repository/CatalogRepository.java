package com.mashosoft.i18demo.domain.repository;

import com.mashosoft.i18demo.domain.entity.Catalog;

import java.util.List;

public interface CatalogRepository {

    List<Catalog> getcatalogFromDatabaseByTypes(String type);

    List<Catalog> getAllFromDatabase();
}
