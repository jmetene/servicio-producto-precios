package com.metene.productos.model.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Embeddable
@Data
public class ProductoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.TIME)
	private Date startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.TIME)
	private Date endDate;
}
