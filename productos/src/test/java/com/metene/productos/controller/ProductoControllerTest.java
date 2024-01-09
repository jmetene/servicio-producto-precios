package com.metene.productos.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.metene.productos.model.entity.Price;
import com.metene.productos.model.service.IProductoService;
import com.metene.productos.model.service.PriceDTO;

@ExtendWith(MockitoExtension.class)
class ProductoControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductoControllerTest.class);

	@InjectMocks
	private ProductoController productoController;

	@Mock
	private IProductoService productoService;

	private Price price;
	private PriceDTO dto;
	private List<Price> prices;

	@BeforeEach
	public void setUp() {
		price = new Price();
		dto = new PriceDTO();
		prices = new ArrayList<>();
	}

	@Test
	void verProductoTest1() {
		LOGGER.info("testVerProducto: Inicio");

		String date = "2022-06-14 10:00:00";
		String productId = "35455";
		String brandId = "1";

		BigDecimal miBigDecimal = BigDecimal.valueOf(35.50);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", new Locale("es", "ES"));

		LocalDateTime dateTimeInit = LocalDateTime.parse("2022-06-14 00:00:00", formatter);
		LocalDateTime dateTimeEnd = LocalDateTime.parse("2022-12-31 23:59:59", formatter);

		Date startDate = java.sql.Timestamp.valueOf(dateTimeInit);
		Date endDate = java.sql.Timestamp.valueOf(dateTimeEnd);

		price.setPriceId(1L);
		price.setBrandId("1");
		price.setProductId("35455");
		price.setPriceList("1");
		price.setStartDate(startDate);
		price.setEndDate(endDate);
		price.setPrice(miBigDecimal);
		price.setCurrency("EUR");
		prices.add(price);
		
		dto.setId(price.getProductId());
		dto.setBrand(price.getBrandId());
		dto.setRate(price.getPriceList());
		dto.setStartDate("2022-06-14 00:00:00");
		dto.setEndDate("2022-12-31 23:59:59");

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(productoService.getProductoInfo(date, productId, brandId)).thenReturn(prices);
		when(productoService.toDto(price)).thenReturn(dto);
		PriceDTO result = productoController.verProducto(date, productId, brandId);

		assertEquals(dto.getBrand(), result.getBrand());
		assertEquals(dto.getId(), result.getId());
		assertEquals(dto.getRate(), result.getRate());
		assertEquals(dto.getStartDate(), result.getStartDate());
		assertEquals(dto.getEndDate(), result.getEndDate());
		assertEquals(dto.getPrice(), result.getPrice());

		LOGGER.info("testVerProducto: Fin");
	}
	
	@Test
	void verProductoTest2() {
		LOGGER.info("testVerProducto: Inicio");
		
		String date = "2022-06-14 16:00:00";
		String productId = "35455";
		String brandId = "1";
		
		price = null;
		prices.add(price);
		
		dto = null;
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(productoService.getProductoInfo(date, productId, brandId)).thenReturn(prices);
		when(productoService.toDto(price)).thenReturn(null);
		PriceDTO result = productoController.verProducto(date, productId, brandId);
		
		assertEquals(dto, result);
		
		
		LOGGER.info("testVerProducto: Fin");
	}
	@Test
	void verProductoTest3() {
		LOGGER.info("testVerProducto: Inicio");
		
		String date = "2022-06-14 21:00:00";
		String productId = "35455";
		String brandId = "1";
		
		price = null;
		prices.add(price);
		
		dto = null;
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(productoService.getProductoInfo(date, productId, brandId)).thenReturn(prices);
		when(productoService.toDto(price)).thenReturn(null);
		PriceDTO result = productoController.verProducto(date, productId, brandId);
		
		assertEquals(dto, result);
		
		
		LOGGER.info("testVerProducto: Fin");
	}
	
	@Test
	void verProductoTest4() {
		LOGGER.info("testVerProducto: Inicio");

		String date = "2022-06-15 10:00:00";
		String productId = "35455";
		String brandId = "1";

		BigDecimal miBigDecimal = BigDecimal.valueOf(38.95);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", new Locale("es", "ES"));

		LocalDateTime dateTimeInit = LocalDateTime.parse("2022-06-15 10:00:00", formatter);
		LocalDateTime dateTimeEnd = LocalDateTime.parse("2020-12-31 23:59:59", formatter);

		Date startDate = java.sql.Timestamp.valueOf(dateTimeInit);
		Date endDate = java.sql.Timestamp.valueOf(dateTimeEnd);

		price.setPriceId(1L);
		price.setBrandId("1");
		price.setProductId("35455");
		price.setPriceList("4");
		price.setStartDate(startDate);
		price.setEndDate(endDate);
		price.setPrice(miBigDecimal);
		price.setCurrency("EUR");
		prices.add(price);
		
		dto.setId(price.getProductId());
		dto.setBrand(price.getBrandId());
		dto.setRate(price.getPriceList());
		dto.setStartDate("2020-06-15 16:00:00");
		dto.setEndDate("2020-12-31 23:59:59");

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(productoService.getProductoInfo(date, productId, brandId)).thenReturn(prices);
		when(productoService.toDto(price)).thenReturn(dto);
		PriceDTO result = productoController.verProducto(date, productId, brandId);

		assertEquals(dto.getBrand(), result.getBrand());
		assertEquals(dto.getId(), result.getId());
		assertEquals(dto.getRate(), result.getRate());
		assertEquals(dto.getStartDate(), result.getStartDate());
		assertEquals(dto.getEndDate(), result.getEndDate());
		assertEquals(dto.getPrice(), result.getPrice());

		LOGGER.info("testVerProducto: Fin");
	}
	
	@Test
	void verProductoTest5() {
		LOGGER.info("testVerProducto: Inicio");
		
		String date = "2022-06-16 21:00:00";
		String productId = "35455";
		String brandId = "1";
		
		price = null;
		prices.add(price);
		
		dto = null;
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(productoService.getProductoInfo(date, productId, brandId)).thenReturn(prices);
		when(productoService.toDto(price)).thenReturn(null);
		PriceDTO result = productoController.verProducto(date, productId, brandId);
		
		assertEquals(dto, result);
		
		
		LOGGER.info("testVerProducto: Fin");
	}
}
