package com.example.IAtreinar.Repository;

import com.example.IAtreinar.Entity.Exercicio; // <--- CORRIGIDO
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    // Conteúdo
}