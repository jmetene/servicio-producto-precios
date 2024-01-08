package com.metene.productos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metene.productos.model.entity.Price;
import com.metene.productos.model.service.IProductoService;
import com.metene.productos.model.service.PriceDTO;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	@Autowired
	private IProductoService productoService;

	@GetMapping("/ver")
	public PriceDTO verProducto(@RequestParam String date, @RequestParam String productId,
			@RequestParam String brandId) {
		Price price = new Price();
		PriceDTO dto = new PriceDTO();

		LOGGER.debug("ProductoController::verProducto: Inicio");
		try {
			List<Price> prices = productoService.getProductoInfo(date, productId, brandId);

			if (prices != null && !prices.isEmpty()) {
				price = prices.get(0);

				dto = productoService.toDto(price);
			}
			LOGGER.debug("ProductoController::verProducto: Inicio");
		} catch (Exception e) {
			LOGGER.error("ProductoController::verProducto: Error al recuperar la información del precio del producto: ", e.getMessage());
		}
		
		return dto;
	}

}
