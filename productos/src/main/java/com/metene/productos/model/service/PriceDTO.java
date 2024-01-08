package com.metene.productos.model.service;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PriceDTO {
	@JsonProperty(value = "identificador")
	private String id;
	@JsonProperty(value = "marca")
	private String brand;
	@JsonProperty(value = "tarifa")
	private String rate;
	@JsonProperty(value = "fechaInicio")
	private String startDate;
	@JsonProperty(value = "fechaFin")
	private String endDate;
	@JsonProperty(value = "precio")
	private BigDecimal price;

}
