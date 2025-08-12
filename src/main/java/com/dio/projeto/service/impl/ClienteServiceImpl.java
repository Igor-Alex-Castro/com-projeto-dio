package com.dio.projeto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.projeto.model.Cliente;
import com.dio.projeto.model.Endereco;
import com.dio.projeto.repository.ClienteRepository;
import com.dio.projeto.repository.EnderecoRepository;
import com.dio.projeto.service.ClienteService;
import com.dio.projeto.service.ViaCepService;

import java.util.Optional;


@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ViaCepService viaCepService;
	
	@Override
	public Iterable<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// TODO Auto-generated method stub
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
	}

	

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		Optional<Cliente> cliente1 = clienteRepository.findById(id);
		if(cliente1.isEmpty()) {
			salvarClienteComCep(cliente);
		}
		
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}
	
	private void salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		
		Endereco endereco = enderecoRepository.findById(Long.valueOf(cep)).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		// TODO Auto-generated method stub
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

}
