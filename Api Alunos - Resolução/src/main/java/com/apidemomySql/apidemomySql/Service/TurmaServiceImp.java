package com.apidemomySql.apidemomySql.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.apidemomySql.apidemomySql.Model.Turma;
import com.apidemomySql.apidemomySql.Repository.TurmaRepository;

@Component
public class TurmaServiceImp implements TurmaService {

	private TurmaRepository turmaRepository;
	
	public TurmaServiceImp(TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
	}
	
	@Override
	public List<Turma> getAll() {
		List<Turma> turmas = (List<Turma>)turmaRepository.findAll();
		return turmas;
	}

	@Override
	public Turma getAluno(long id) {
		Optional<Turma> turma = turmaRepository.findById(id);
		if(turma != null && turma.isPresent()) {
			return turma.get();
		}
		return null;
	}

	@Override
	public Turma CreateOrUpdate(Turma turma) {		
		return turmaRepository.save(turma);
	}

	@Override
	public void Delete(long id) {
		turmaRepository.deleteById(id);
	}
}
