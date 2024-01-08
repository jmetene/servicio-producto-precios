package com.metene.productos.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "prices")
@Data
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="price_id")
	private Long priceId;
	
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "price_list")
	private String priceList;

	@Column(name = "product_id")
	private String productId;

	@Column(name = "brand_id")
	private String brandId;

	@Column(name = "priority")
	private int priority;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "currency")
	private String currency;
}
