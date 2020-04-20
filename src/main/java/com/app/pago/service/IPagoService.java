package com.app.pago.service;

import java.util.List;

import com.app.pago.domain.Pago;

public interface IPagoService {

	public Pago save (Pago transaction );
	public List<Pago> findAll();
	public Pago findyId(Integer id);
}

