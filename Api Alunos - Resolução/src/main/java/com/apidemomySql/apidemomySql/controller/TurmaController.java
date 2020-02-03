package com.apidemomySql.apidemomySql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apidemomySql.apidemomySql.Model.Turma;
import com.apidemomySql.apidemomySql.Service.TurmaService;

@CrossOrigin("*")
@RestController
public class TurmaController {
	
	@Autowired
	private final TurmaService turmaService;	
	
	@Autowired
	public TurmaController(TurmaService turmaService) {
		this.turmaService = turmaService;
	}
	
	@GetMapping("/turma")
	public ResponseEntity<List<Turma>> getAllTurma(){
		return ResponseEntity.ok(turmaService.getAll());
	}
	
	@GetMapping("/turma/{id}")
	public ResponseEntity<Turma> getByIdTurma(@PathVariable long id){
		return ResponseEntity.ok(turmaService.getAluno(id));
	}
	
	@PostMapping("/turma")
	public ResponseEntity<Turma> postTurma(@RequestBody Turma turma){
		return ResponseEntity.ok(turmaService.CreateOrUpdate(turma));
	}
	
	@PutMapping("/turma")
	public ResponseEntity<Turma> putTurma(@RequestBody Turma turma){
		return ResponseEntity.ok(turmaService.CreateOrUpdate(turma));
	}
	
	@DeleteMapping("/turma/{id}")
	public ResponseEntity<String> deleteTurma(@PathVariable long id) {
		turmaService.Delete(id);
		return ResponseEntity.ok("Deletado");
		
	}
}
