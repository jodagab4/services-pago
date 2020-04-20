package com.app.pago.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.pago.domain.Pago;
import com.app.pago.producer.PagoEventProducer;
import com.app.pago.service.IPagoService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class PagoEventsController {

	private Logger log = LoggerFactory.getLogger(PagoEventsController.class);
	
	@Autowired
	PagoEventProducer pagoEventProducer;
	
	@Autowired
	private IPagoService pagoService;
	
	@PostMapping("/pago/pagoevent")
	public ResponseEntity<Pago> postLibraryEvent(@RequestBody Pago pagoEvent) throws JsonProcessingException{
		
		Pago tranSql = pagoService.save(pagoEvent);
		log.info("antes sendCronogramaEvent_Approach3 ");
		pagoEventProducer.sendPagoEvent_Approach3(tranSql);
		log.info("despues sendCronogramaEvent_Approach3 ");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tranSql);
	}
	
}
