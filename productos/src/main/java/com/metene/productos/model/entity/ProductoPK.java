package com.metene.productos.model.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ProductoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "brand_id")
	private String brandId;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
}
