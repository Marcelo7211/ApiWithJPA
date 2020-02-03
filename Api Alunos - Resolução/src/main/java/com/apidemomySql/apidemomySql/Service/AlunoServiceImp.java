package com.apidemomySql.apidemomySql.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.apidemomySql.apidemomySql.Model.Aluno;
import com.apidemomySql.apidemomySql.Repository.AlunoRepository;

@Component
public class AlunoServiceImp implements AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public AlunoServiceImp(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	@Override
	public List<Aluno> getAll() {		
		List<Aluno> alunos = (List<Aluno>) alunoRepository.findAll();		
		return alunos;
	}

	@Override
	public Aluno getAluno(long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if ( aluno != null && aluno.isPresent() )
        {
           return aluno.get();
        }
        return null;
	}

	@Override
	public Aluno CreateOrUpdate(Aluno aluno) {		
		return alunoRepository.save(aluno);
	}

	@Override
	public void Delete(long id) {
		alunoRepository.deleteById(id);
	}

	@Override
	public List<Aluno> getByPriNome(String nome) {
		List<Aluno> alunos = alunoRepository.findAllByPriNomeIgnoreCaseContaining(nome);		
		return alunos ;
	}

	@Override
	public Aluno getByNomeAndSobrenome(String priNome, String SobreNome) {
		return alunoRepository.findByPriNomeAndSobreNome(priNome, SobreNome);
				
	}

	

}
