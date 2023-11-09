package com.cursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.entities.Cursos;
import com.cursos.repository.CursosRepository;

@Service
public class CursosService {
    private final CursosRepository CursosRepository;
    
    @Autowired
    public CursosService(CursosRepository CursosRepository) {
        this.CursosRepository = CursosRepository;
    }

    public List<Cursos> buscaTodosCursos() {
        return CursosRepository.findAll();
    }

    public Cursos buscaCursosporId(Long id) {
    	Optional <Cursos> Cursos = CursosRepository.findById(id);
    	return Cursos.orElse(null);
    }
    
    public Cursos salvaCursos(Cursos Cursos) {
    	return CursosRepository.save(Cursos);
    }
    
    public Cursos alterarCursos(long id, Cursos alterarProd) {
    	Optional <Cursos> existeCursos = CursosRepository.findById(id);
    	if(existeCursos.isPresent()){
    		alterarProd.setId(id);
    		return CursosRepository.save(alterarProd);
    	}
    	return null;
    }
    public boolean apagarCursos(Long id) {
    	Optional <Cursos> existeCursos = CursosRepository.findById(id);
    	if (existeCursos.isPresent()) {
    		CursosRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }
     
}
