package com.kata.helpdesk.repositories;

import com.kata.helpdesk.domain.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {}
