package com.app.pago.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.pago.domain.Pago;

public interface PagoDao extends CrudRepository<Pago, Integer>{

	
}
