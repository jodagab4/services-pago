package com.app.pago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pago.dao.PagoDao;
import com.app.pago.domain.Pago;

@Service
public class PagoServiceImp implements IPagoService {

	@Autowired
	private PagoDao transactionDao;
	
	@Override
	@Transactional
	public Pago save(Pago transaction) {
		
		return transactionDao.save(transaction);
	}
	
	@Override
	public List<Pago> findAll() {
		return (List<Pago>) transactionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Pago findyId(Integer id) {
		return transactionDao.findById(id).orElse(null);
	}

	
}
