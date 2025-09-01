package com.kata.helpdesk.services;

import com.kata.helpdesk.domain.Cliente;
import com.kata.helpdesk.domain.Projeto;
import com.kata.helpdesk.domain.Tarefa;
import com.kata.helpdesk.domain.enums.Perfil;
import com.kata.helpdesk.repositories.PessoaRepository;
import com.kata.helpdesk.repositories.ProjetoRepository;
import com.kata.helpdesk.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class DBService {

	@Autowired
	private PessoaRepository pessoaRepository;
    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private TarefaRepository tarefaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {

		Cliente cli1 = new Cliente(null, "Usuário teste", "111.661.890-74", "usuario@mail.com", encoder.encode("123"));
        cli1.addPerfil(Perfil.ADMIN);
        Cliente cli2 = new Cliente(null, "Marie Curie", "322.429.140-06", "curie@mail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Max Planck", "081.399.300-83", "planck@mail.com", encoder.encode("123"));
 
		pessoaRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5));

        // Inserindo projetos (necessário para chave estrangeira em Tarefa)
        Projeto projeto01 = new Projeto(1l,"Projeto Alpha");
        Projeto projeto02 = new Projeto(2l,"Projeto Beta");
        Projeto projeto03 = new Projeto(3L, "Projeto Gamma");

        projetoRepository.saveAll(Arrays.asList(projeto01, projeto02, projeto03));

        Tarefa tarefa = new Tarefa(1L,"Corrigir bugs","Corrigir erros críticos no sistema","PENDENTE", LocalDateTime.now(), new Projeto(1L));
        Tarefa tarefa1 = new Tarefa(2L,"Criar documentação","'Documentar os endpoints da API","EM_ANDAMENTO", LocalDateTime.now(), new Projeto(1L));
        Tarefa tarefa2 = new Tarefa(3L, "Implementar autenticação", "Adicionar login com JWT", "PENDENTE", LocalDateTime.now(), new Projeto(1L));
        Tarefa tarefa3 = new Tarefa(4L, "Testar integração", "Verificar comunicação entre módulos", "EM_ANDAMENTO", LocalDateTime.now(), new Projeto(2L));
        Tarefa tarefa4 = new Tarefa(5L, "Criar layout", "Desenhar interface do dashboard", "CONCLUIDA", LocalDateTime.now(), new Projeto(2L));
        Tarefa tarefa5 = new Tarefa(6L, "Refatorar código", "Melhorar legibilidade do serviço de tarefas", "PENDENTE", LocalDateTime.now(), new Projeto(1L));
        Tarefa tarefa6 = new Tarefa(7L, "Configurar CI/CD", "Automatizar deploy com GitHub Actions", "EM_ANDAMENTO", LocalDateTime.now(), new Projeto(3L));
        Tarefa tarefa7 = new Tarefa(8L, "Criar testes unitários", "Cobrir classes de domínio com JUnit", "PENDENTE", LocalDateTime.now(), new Projeto(1L));
        Tarefa tarefa8 = new Tarefa(9L, "Atualizar dependências", "Subir versão do Spring Boot", "CONCLUIDA", LocalDateTime.now(), new Projeto(2L));
        Tarefa tarefa9 = new Tarefa(10L, "Documentar arquitetura", "Criar diagrama de componentes", "PENDENTE", LocalDateTime.now(), new Projeto(3L));
        Tarefa tarefa10 = new Tarefa(11L, "Validar formulário", "Adicionar validações no front-end", "EM_ANDAMENTO", LocalDateTime.now(), new Projeto(1L));
        Tarefa tarefa11 = new Tarefa(12L, "Criar endpoint de tarefas", "Expor API REST para tarefas", "CONCLUIDA", LocalDateTime.now(), new Projeto(2L));
        Tarefa tarefa12 = new Tarefa(13L, "Revisar pull requests", "Analisar código enviado por colaboradores", "PENDENTE", LocalDateTime.now(), new Projeto(3L));
        Tarefa tarefa13 = new Tarefa(14L, "Configurar banco de dados", "Criar estrutura inicial no PostgreSQL", "EM_ANDAMENTO", LocalDateTime.now(), new Projeto(1L));
        Tarefa tarefa14 = new Tarefa(15L, "Criar página de login", "Desenvolver tela de autenticação", "CONCLUIDA", LocalDateTime.now(), new Projeto(2L));
        Tarefa tarefa15 = new Tarefa(16L, "Monitorar logs", "Configurar Logback para produção", "PENDENTE", LocalDateTime.now(), new Projeto(3L));
        Tarefa tarefa16 = new Tarefa(17L, "Otimizar queries", "Melhorar desempenho das consultas SQL", "EM_ANDAMENTO", LocalDateTime.now(), new Projeto(1L));
        tarefaRepository.saveAll(Arrays.asList(tarefa, tarefa1 ,tarefa2, tarefa3, tarefa4, tarefa5, tarefa6, tarefa7,
                tarefa8, tarefa9, tarefa10, tarefa11, tarefa12, tarefa13, tarefa14, tarefa15, tarefa16));
    }
}
