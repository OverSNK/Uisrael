package com.uisrael.cliente.service;

import java.util.List;

import com.uisrael.cliente.entity.Cliente;

public interface ClienteService {

	List<Cliente> obtenerTodas();
	Cliente obtenerPorId(Integer id);
	Cliente crearCliente(Cliente cliente);
	Cliente actualizarCliente(Integer id, Cliente cliente);
	void eliminarCliente(Integer id);
	Long contarClientes();
}
