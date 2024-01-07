package com.metene.productos.model.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.metene.productos.model.entity.Producto;
import com.metene.productos.model.entity.ProductoPK;

public interface ProductoRepository extends CrudRepository<Producto, ProductoPK> {

	@Query("SELECT p FROM Producto "
			+ "WHERE p.brandId =: brandId AND "
			+ "p.productoPK.productId =: productId "
			+ "AND p.productoPK.startDate =: startDate AND "
			+ "p.productoPK.endDate =: endDate")
	Optional<Producto> findByDateAndProductIdAndBrandId(
			@Param("brandId") String brandId,
			@Param("productId") Long productId, 
			@Param("startDate") Date startDate, 
			@Param("endDate") Date endDate);
}
