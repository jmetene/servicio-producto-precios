package com.metene.productos.model.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.metene.productos.model.entity.Price;

public interface ProductoRepository extends CrudRepository<Price, Long> {

	@Query("SELECT p FROM Price p WHERE p.startDate >= ?1 and p.startDate <= ?2 and p.productId = ?3 and p.brandId = ?4 order by p.priority")
	List<Price> findByCustomParameters(Date startDate, Date endDate, String productId, String brandId);
}
