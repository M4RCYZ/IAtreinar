package com.example.IAtreinar.Controller;

import com.example.IAtreinar.Repository.ExercicioRepository;
import com.example.IAtreinar.Entity.Exercicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/exercicios")
public class ExercicioController {

    @Autowired
    private ExercicioRepository repository;

    // POST http://localhost:8080/api/exercicios
    @PostMapping
    public Exercicio criarExercicio(@RequestBody Exercicio exercicio) {
        return repository.save(exercicio);
    }

    // GET http://localhost:8080/api/exercicios
    @GetMapping
    public List<Exercicio> listarTodos() {
        return repository.findAll();
    }

    // GET http://localhost:8080/api/exercicios/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok) // Se encontrar, retorna 200 OK com o objeto
                .orElse(ResponseEntity.notFound().build()); // Se não encontrar, retorna 404 Not Found
    }

    // PUT http://localhost:8080/api/exercicios/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> atualizarExercicio(@PathVariable Long id, @RequestBody Exercicio exercicioDetalhes) {
        return repository.findById(id)
                .map(exercicio -> {
                    exercicio.setNome(exercicioDetalhes.getNome());
                    exercicio.setMusculoAlvo(exercicioDetalhes.getMusculoAlvo());
                    exercicio.setDescricaoExecucao(exercicioDetalhes.getDescricaoExecucao());
                    Exercicio atualizado = repository.save(exercicio);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE http://localhost:8080/api/exercicios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarExercicio(@PathVariable Long id) {
        return repository.findById(id)
                .map(exercicio -> {
                    repository.delete(exercicio);
                    return ResponseEntity.ok().<Void>build(); // Retorna 200 OK sem conteúdo
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
