package com.metene.productos.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto {
	@Embedded
	private ProductoPK productoPK;
	@Column(name = "product_id")
	private Long productId;
	@Column(name = "priority")
	private int priority;
	@Column(name = "price")
	private BigDecimal price;
	@Column(name = "currency")
	private String currency;
}
