package com.metene.productos.model.service;

import java.util.List;

import com.metene.productos.model.entity.Price;

public interface IProductoService {
	
	List<Price> getProductoInfo(String effectiveDate, String productId, String brandId);
	
	PriceDTO toDto(Price price);
}
