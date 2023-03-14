package com.apirest.ofertaciclo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.ofertaciclo.model.Ies;
import com.apirest.ofertaciclo.model.Ofertaeducativa;
import com.apirest.ofertaciclo.repository.IesRepository;

@RestController
@RequestMapping("/api")
public class IesController {
	
	@Autowired
	private IesRepository repository;
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/institutos")
	public List<Ies> allIes() {
		return (List<Ies>) repository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/ofertainstituto/{idies}")
	public List<Ofertaeducativa> findOfertaByIdies(@PathVariable("idies") long idies) {
		return repository.findByIdies(idies).getOfertaeducativa();
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/institutos/{page}")
	public ResponseEntity<?> getIesPageable(@PathVariable("page") final Integer page) {
		return ResponseEntity.ok(convertToResponse(repository.getIesPageable(PageRequest.of(page, 5)))); //El 5 es el numero de resultados por página
	}
	
	//Este metodo es para dar mejor formato a la respuesta
	private Map<String, Object> convertToResponse(final Page<Ies> pageIes) {
		Map<String, Object> response = new HashMap<>();
		response.put("iesList", pageIes.getContent());
		response.put("currentPage", pageIes.getNumber());
		response.put("totalItems", pageIes.getTotalElements());
		response.put("totalPages", pageIes.getTotalPages());
		return response;
	} 
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/instituto")
	public Ies createIes(@RequestBody Ies ies) {
		Ies iesCheck = repository.findByIdies(ies.getIdies());
		if (iesCheck != null) {
			iesCheck = new Ies();
			iesCheck.setIdies(0);
			//No he mirado como gestionar las excepciones correctamente aqui asi que me mando un ies con todo en nulo para tenerlo en cuenta
			return iesCheck;
		}
		return repository.save(ies);
	}
}
