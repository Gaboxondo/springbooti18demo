package com.mashosoft.i18demo.infrastructure.db.repository;

import com.mashosoft.i18demo.infrastructure.db.entity.ProductSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductJpaRepository extends JpaRepository<ProductSQL, String>{

    @Query(value = "SELECT * FROM product WHERE id = :id", nativeQuery = true)
    ProductSQL findbyId(@Param( "id" ) String id);

}
