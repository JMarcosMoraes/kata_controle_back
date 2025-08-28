package com.kata.helpdesk.repositories;

import com.kata.helpdesk.domain.Tarefa;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    Page<Tarefa> findByProjetoId(Long projetoId, Pageable pageable);
}