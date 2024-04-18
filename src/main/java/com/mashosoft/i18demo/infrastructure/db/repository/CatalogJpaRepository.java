package com.mashosoft.i18demo.infrastructure.db.repository;

import com.mashosoft.i18demo.infrastructure.db.entity.CatalogIdSQL;
import com.mashosoft.i18demo.infrastructure.db.entity.CatalogSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatalogJpaRepository extends JpaRepository<CatalogSQL, CatalogIdSQL>{

    @Query(value = "SELECT * FROM catalog WHERE type = :type", nativeQuery = true)
    List<CatalogSQL> findCatalogsByType(@Param( "type" ) String type);

}
