package com.apidemomySql.apidemomySql.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apidemomySql.apidemomySql.Model.Aluno;
import com.apidemomySql.apidemomySql.Service.AlunoService;

@CrossOrigin("*")
@RestController
public class AlunoController {
	
	private final AlunoService alunoService;
	
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;		
	}
	
	@GetMapping("/aluno/{id}")
	public ResponseEntity<Aluno> getAluno( @PathVariable long id){
		return ResponseEntity.ok(alunoService.getAluno(id));
	}
	
	@GetMapping("/aluno/busca")
	public ResponseEntity<Aluno> getAluno( @RequestParam String nome, @RequestParam String sobrenome){
		return ResponseEntity.ok(alunoService.getByNomeAndSobrenome(nome, sobrenome));
	}
	
	@GetMapping("/aluno")
	public ResponseEntity<List<Aluno>> getAlunoAll(){
		return ResponseEntity.ok(alunoService.getAll());
	}
	
	@GetMapping("/aluno/priNome/{priNome}")
	public ResponseEntity<List<Aluno>> getAlunoPriNome(@PathVariable String priNome){
		return ResponseEntity.ok(alunoService.getByPriNome(priNome));
		
	}
	
	@PostMapping("/aluno")
	public ResponseEntity<Aluno> postAluno(@RequestBody Aluno aluno){
		return ResponseEntity.ok(alunoService.CreateOrUpdate(aluno));
	}
	
	@PutMapping("/aluno")
	public ResponseEntity<Aluno> putAluno(@RequestBody Aluno aluno){
		return ResponseEntity.ok(alunoService.CreateOrUpdate(aluno));
	}
	
	@DeleteMapping("/aluno/{id}")
	public ResponseEntity<String> deleteAluno(@PathVariable long id) {
		alunoService.Delete(id);
		return ResponseEntity.ok("Deletado");
	}
	
	

}
