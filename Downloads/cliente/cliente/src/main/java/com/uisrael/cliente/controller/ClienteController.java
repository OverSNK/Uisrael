package com.uisrael.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.cliente.entity.Cliente;
import com.uisrael.cliente.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public String listarClientes(Model model) {
		List<Cliente> clientes = clienteService.obtenerTodas();
		model.addAttribute("listarClientes", clientes);
		return "listar";
	}
	@GetMapping("/nueva")
	public String mostrarFormularioDeNuevoCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("accion", "/clientes/nueva");
		return "formulario";
	}
	@PostMapping("/nueva")
	public String guardarNuevoCliente(@ModelAttribute Cliente cliente) {
		clienteService.crearCliente(cliente);
		return"redirect:/clientes";
	}
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditarCliente(@PathVariable Integer id,@ModelAttribute Cliente cliente, Model model) {
		model.addAttribute("cliente", cliente);
		model.addAttribute("accion", "/clientes/editar/"+id);
		return "formulario";
	}
	@PostMapping("editar/{id}")
	public String actualizarCliente(@PathVariable Integer id, @ModelAttribute Cliente cliente) {
		clienteService.actualizarCliente(id, cliente);
		return "redirect:/clientes";
	}
	@GetMapping ("/eliminar/{id}")
	public String eliminarCliente(@PathVariable Integer id) {
		clienteService.eliminarCliente(id);
		return "redirect:/clientes";
	}
}
