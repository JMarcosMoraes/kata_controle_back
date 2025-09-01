package com.kata.helpdesk.services;

import com.kata.helpdesk.domain.Projeto;
import com.kata.helpdesk.domain.Tarefa;
import com.kata.helpdesk.domain.dtos.TarefaCreateDTO;
import com.kata.helpdesk.domain.dtos.TarefaDTO;
import com.kata.helpdesk.repositories.ProjetoRepository;
import com.kata.helpdesk.repositories.TarefaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TarefaDTO salvar(TarefaCreateDTO dto) {
        Projeto projeto = projetoRepository.findById(dto.getProjetoId())
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        Tarefa tarefa = new Tarefa(dto);
        tarefa.setProjeto(projeto);
        tarefa = tarefaRepository.save(tarefa);

        return modelMapper.map(tarefa, TarefaDTO.class);
    }

    public Page<TarefaDTO> listar(Long projetoId, Pageable pageable) {
        Page<Tarefa> tarefas = projetoId != null
                ? tarefaRepository.findByProjetoId(projetoId, pageable)
                : tarefaRepository.findAll(pageable);

        return tarefas.map(t -> modelMapper.map(t, TarefaDTO.class));
    }

    public void excluir(Long id) {
        tarefaRepository.deleteById(id);
    }

}
