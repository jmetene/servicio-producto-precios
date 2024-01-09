package com.metene.productos.model.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metene.productos.model.entity.Price;
import com.metene.productos.model.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoRepository repository;

	@Override
	public List<Price> getProductoInfo(String effectiveDate, String productId, String brandId) {
		List<Price> productos = null;

		if (effectiveDate != null && productId != null && brandId != null) {
			
			String fecha = effectiveDate.substring(0, 10);
			String horafinConsulta = fecha + " 23:59:59";
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", new Locale("es", "ES"));
			
			LocalDateTime dateTimeInit = LocalDateTime.parse(effectiveDate, formatter);
			LocalDateTime dateTimeEnd = LocalDateTime.parse(horafinConsulta, formatter);
			
			Date startDate = java.sql.Timestamp.valueOf(dateTimeInit);
			Date endDate = java.sql.Timestamp.valueOf(dateTimeEnd);
		
			productos = repository.findByCustomParameters(startDate, endDate, productId, brandId);
		}

		return productos;
	}

	@Override
	public  PriceDTO toDto(Price price) {
		PriceDTO dto = null; 
		
		if (price != null) {
			dto = new PriceDTO();
			
			dto.setId(price.getProductId());
			dto.setBrand(price.getBrandId());
			dto.setRate(price.getPriceList());
			dto.setStartDate(price.getStartDate().toString());
			dto.setEndDate(price.getEndDate().toString());
			dto.setPrice(price.getPrice());
		}
		
		return dto;
	}
	
	

}
