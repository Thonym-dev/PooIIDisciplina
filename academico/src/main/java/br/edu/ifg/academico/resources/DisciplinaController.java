package br.edu.ifg.academico.resources;

import br.edu.ifg.academico.entities.Disciplina;
import br.edu.ifg.academico.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

	
    @Autowired
    private DisciplinaService disciplinaService;

    // a) Listar todas as disciplinas
    @GetMapping
    public List<Disciplina> listarTodas() {
        return disciplinaService.listarTodas();
    }

    // b) Procurar uma disciplina pela chave primária
    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarPorId(@PathVariable Integer id) {
        Optional<Disciplina> disciplina = disciplinaService.buscarPorId(id);
        return disciplina.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // c) Inserir uma nova disciplina
    @PostMapping
    public Disciplina inserir(@RequestBody Disciplina disciplina) {
        return disciplinaService.inserir(disciplina);
    }

    // d) Alterar os dados da disciplina tendo como parâmetro a chave primária
    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizar(@PathVariable Integer id, @RequestBody Disciplina disciplina) {
        Disciplina atualizada = disciplinaService.atualizar(id, disciplina);
        if (atualizada != null) {
            return ResponseEntity.ok(atualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // e) Excluir a disciplina pela chave primária
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        if (disciplinaService.excluir(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
