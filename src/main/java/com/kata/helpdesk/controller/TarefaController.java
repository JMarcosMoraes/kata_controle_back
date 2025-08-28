package com.kata.helpdesk.controller;

import com.kata.helpdesk.domain.dtos.TarefaCreateDTO;
import com.kata.helpdesk.domain.dtos.TarefaDTO;
import com.kata.helpdesk.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaDTO> criar(@RequestBody @Valid TarefaCreateDTO dto) {
        return ResponseEntity.ok(tarefaService.salvar(dto));
    }

    @GetMapping
    public Page<TarefaDTO> listar(
            @RequestParam(required = false) Long projetoId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "dataCriacao") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return tarefaService.listar(projetoId, pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        tarefaService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}