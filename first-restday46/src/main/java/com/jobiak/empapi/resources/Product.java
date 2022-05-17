package com.jobiak.empapi.resources;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobiak.empapi.model.Mobile;
import com.jobiak.empapi.service.MobileService;
@RestController
@RequestMapping("/catalog")
public class Product {
	@Autowired
	MobileService service;
	@GetMapping(value="/display",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Mobile> showAll(){
		return service.getAll();
		
	}
	@GetMapping(value="/mobile",produces=MediaType.APPLICATION_JSON_VALUE)
	public Mobile showCatlog() {
		
		Mobile mobile = new Mobile();
		mobile.setBrand("Samsung");
		mobile.setModel("E2FH,Dual camara,32GB Memory,49,999,I got you");
		mobile.setPrice(50000);
		
		return mobile;
	}
	@GetMapping("/intro")
	public String introduction() {
		return new String("The #1 Manfacture of Digital Mobiles in Asia");
	}
	
	@GetMapping("/search/{modelId}")
	public String searchModel(@PathVariable(value="modelId")String modelId) {
		return new String(modelId+"is available only in blue and black clours");
	}
	
	@GetMapping("/search/{modelId}/brand/{brand}")
	public String searchModel(@PathVariable(value="modelId")String modelId,@PathVariable(value="brand")String brand) {
		return new String(modelId+brand+"Currently is not available only in blue and black clours");
	}
	@PostMapping(value="/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Mobile addProduct(@RequestBody Mobile mobile) {
		//System.out.println(mobile);
	Mobile ref = service.addMobile(mobile);
	return ref;
	}
	@PutMapping(value="/modify",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Mobile modifyProduct(@RequestBody Mobile mobile) {
		//System.out.println(mobile);
	Mobile ref = service.modifyMobile(mobile);	
	return ref;
	}
	@DeleteMapping(value="/remove/{mid}")
		public void remove(@PathVariable(value="mid")Long mid) {
			service.removeProduct(mid);
		}
	}
	
	

