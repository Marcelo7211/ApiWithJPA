package com.apidemomySql.apidemomySql.Service;

import java.util.List;

import com.apidemomySql.apidemomySql.Model.Aluno;

public interface AlunoService {
	
	List<Aluno> getAll ();

	Aluno getAluno(long id);
	
	Aluno CreateOrUpdate(Aluno aluno);
	
	List<Aluno> getByPriNome(String nome);
	
	Aluno getByNomeAndSobrenome (String priNome, String SobreNome);
	
	void Delete(long id);

	
}
