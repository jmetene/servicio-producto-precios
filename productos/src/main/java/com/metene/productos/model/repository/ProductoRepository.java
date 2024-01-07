package com.metene.productos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.metene.productos.model.entity.Producto;
import com.metene.productos.model.entity.ProductoPK;

public interface ProductoRepository extends CrudRepository<Producto, ProductoPK> {

}
