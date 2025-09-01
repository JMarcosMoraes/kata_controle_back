package com.kata.helpdesk.controller;
import com.kata.helpdesk.domain.Projeto;
import com.kata.helpdesk.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<Projeto> listar() {
        return projetoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> buscarPorId(@PathVariable Long id) {
        return projetoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Projeto> criar(@RequestBody Projeto projeto) {
        Projeto novoProjeto = projetoService.salvar(projeto);
        return ResponseEntity.ok(novoProjeto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> atualizar(@PathVariable Long id, @RequestBody Projeto projeto) {
        Projeto atualizado = projetoService.atualizar(id, projeto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        projetoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}