package com.metene.productos.model.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metene.productos.model.entity.Producto;
import com.metene.productos.model.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoRepository repository;

	@Override
	public Producto getProductoInfo(Date startDate, Date endDate, Long productId, String brandId) {
		Producto producto = null;

		if (startDate != null && endDate != null && productId != null && brandId != null) {
			Optional<Producto> optProd = repository.findByCustomParameters(brandId, productId, startDate, endDate);
			producto = optProd.isPresent() ? optProd.get() : null;

		}

		return producto;
	}

}
