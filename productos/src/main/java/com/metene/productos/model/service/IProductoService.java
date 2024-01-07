package com.metene.productos.model.service;

import java.util.Date;

import com.metene.productos.model.entity.Producto;

public interface IProductoService {
	/**
	 * Método que devuelve información de un producto por los parámetros
	 * que se indican a continuación.
	 * 
	 * @param startDate Fecha de inicio del rango de fechas.
	 * @param endDate   Fecha de fin del rango de fechas.
	 * @param productId Identificador del producto.
	 * @param brandId   Identificador de la marca.
	 * @return Objeto Producto con la información solicitada.
	 */
	Producto getProductoInfo(Date startDate, Date endDate, Long productId, String brandId);
}
