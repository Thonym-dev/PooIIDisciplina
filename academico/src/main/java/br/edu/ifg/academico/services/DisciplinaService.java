package br.edu.ifg.academico.services;

import br.edu.ifg.academico.entities.Disciplina;
import br.edu.ifg.academico.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> listarTodas() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> buscarPorId(Integer id) {
        return disciplinaRepository.findById(id);
    }

    public Disciplina inserir(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina atualizar(Integer id, Disciplina disciplina) {
        if (disciplinaRepository.existsById(id)) {
            disciplina.setIddisciplina(id);
            return disciplinaRepository.save(disciplina);
        }
        return null;
    }

    public boolean excluir(Integer id) {
        if (disciplinaRepository.existsById(id)) {
            disciplinaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
