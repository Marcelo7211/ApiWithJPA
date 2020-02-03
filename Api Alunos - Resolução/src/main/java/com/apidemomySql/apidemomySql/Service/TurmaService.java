package com.apidemomySql.apidemomySql.Service;

import java.util.List;

import com.apidemomySql.apidemomySql.Model.Turma;;

public interface TurmaService {

	List<Turma> getAll ();

	Turma getAluno(long id);
	
	Turma CreateOrUpdate(Turma turma);
	
	void Delete(long id);
}
