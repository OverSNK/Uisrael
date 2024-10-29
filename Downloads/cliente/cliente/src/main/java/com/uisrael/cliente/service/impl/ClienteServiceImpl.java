package com.uisrael.cliente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.cliente.entity.Cliente;
import com.uisrael.cliente.repository.ClienteRepository;
import com.uisrael.cliente.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Override
	public List<Cliente> obtenerTodas() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente obtenerPorId(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public Cliente crearCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente actualizarCliente(Integer id, Cliente cliente) {
		Cliente clientedb = clienteRepository.findById(id).orElse(null);
		if(clientedb != null) {
			clientedb.setNombres(cliente.getNombres());
			clientedb.setEdad(cliente.getEdad());
			return clienteRepository.save(clientedb);
		}
		return null;
	}

	@Override
	public void eliminarCliente(Integer id) {
		clienteRepository.deleteById(id);
		
	}

	@Override
	public Long contarClientes() {
		return clienteRepository.count();
	}

}
