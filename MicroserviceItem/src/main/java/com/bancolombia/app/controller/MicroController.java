package com.bancolombia.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.app.entities.Item;
import com.bancolombia.app.services.IService;

@RestController //RESTful -> indica que la serializacion de datos de entrada y salida sera con JSON
@RequestMapping("/item")//http://ip:port/item
public class MicroController {

	@Autowired
	private IService servicio;
	
	//agregamos el metodo post->insert
	@PostMapping //POST-> http://ip:port/item
	public ResponseEntity<String> insert(@RequestBody Item item){
		
		if(servicio.insert(item))
			return new ResponseEntity<String>("OK", HttpStatus.CREATED);
				
		return new ResponseEntity<String>("OK", HttpStatus.BAD_REQUEST);
	}
	//agregamos el metodo get para que retorne informacion de la lista
	@GetMapping //se va a activar cuando GET -> http://ip:port/item
	public ResponseEntity<List<Item>> get(){
		
		return new ResponseEntity<List<Item>>(servicio.getAll(), HttpStatus.OK);
	}
	
	
}
