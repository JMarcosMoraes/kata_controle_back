package com.kata.helpdesk.services;

import com.kata.helpdesk.domain.Cliente;
import com.kata.helpdesk.domain.enums.Perfil;
import com.kata.helpdesk.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {

		Cliente cli1 = new Cliente(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", encoder.encode("123"));
        cli1.addPerfil(Perfil.ADMIN);
        Cliente cli2 = new Cliente(null, "Marie Curie", "322.429.140-06", "curie@mail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Max Planck", "081.399.300-83", "planck@mail.com", encoder.encode("123"));
 
		pessoaRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5));
    }
}
