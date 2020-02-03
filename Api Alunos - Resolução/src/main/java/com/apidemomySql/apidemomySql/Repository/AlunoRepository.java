package com.apidemomySql.apidemomySql.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.apidemomySql.apidemomySql.Model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
	List<Aluno> findAllByPriNomeIgnoreCaseContaining(String title);

	Aluno findByPriNomeAndSobreNome(String priNome, String SobreNome);
}
