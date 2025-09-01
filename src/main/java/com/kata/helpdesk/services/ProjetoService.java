package com.kata.helpdesk.services;

import com.kata.helpdesk.domain.Projeto;
import com.kata.helpdesk.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }

    public Optional<Projeto> buscarPorId(Long id) {
        return projetoRepository.findById(id);
    }

    public Projeto salvar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public Projeto atualizar(Long id, Projeto projetoAtualizado) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        projeto.setNome(projetoAtualizado.getNome());
        return projetoRepository.save(projeto);
    }

    public void excluir(Long id) {
        projetoRepository.deleteById(id);
    }
}
