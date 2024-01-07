package com.metene.productos.model.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.metene.productos.model.entity.Producto;
import com.metene.productos.model.entity.ProductoPK;

public interface ProductoRepository extends CrudRepository<Producto, ProductoPK> {

	/**
	 * Método que busca un producto por parámetros personalizados
	 * @param brandId Identificador de la marca
	 * @param productId Identificador del producto
	 * @param startDate Fecha de inicio de vigencia del producto
	 * @param endDate Fecha de fin de vigencia del producto
	 * @return Producto que cumple con los parámetros de búsqueda
	 */
	@Query("SELECT p FROM Producto "
			+ "WHERE p.brandId =: brandId AND "
			+ "p.productoPK.productId =: productId "
			+ "AND p.productoPK.startDate =: startDate AND "
			+ "p.productoPK.endDate =: endDate")
	Optional<Producto> findByCustomParameters(
			@Param("brandId") String brandId,
			@Param("productId") Long productId, 
			@Param("startDate") Date startDate, 
			@Param("endDate") Date endDate);
}
