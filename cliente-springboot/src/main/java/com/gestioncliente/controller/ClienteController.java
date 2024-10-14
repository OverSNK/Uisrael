package com.gestioncliente.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestioncliente.entity.Cliente;
import com.gestioncliente.repository.ClienteRepository;

@Controller
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public String home() {
		return "redirect:/cliente";
	}
	@GetMapping("/cliente")
	public String listarCliente(Model model) {
		List<Cliente> cliente = clienteRepository.findAll();
		cliente = clienteRepository.findAll();
		model.addAttribute("cliente",cliente);
		return "cliente";
	}
	@GetMapping("/cliente/nuevo")
	public String agregarCliente(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("pageTitle","Nuevo cliente");
		return "cliente_form";
	}
	@PostMapping("/cliente/save")
	public String guardarCliente(Cliente cliente, RedirectAttributes redirectAttributes) {
		try {
			clienteRepository.save(cliente);
			redirectAttributes.addFlashAttribute("message","El cliente ha sido guardado con éxito");
		}catch(Exception e) {
			redirectAttributes.addAttribute("message",e.getMessage());
		}
		return "redirect:/cliente";
	}
	@GetMapping("/cliente/editar/{id}")
	public String editarCliente(@PathVariable Long id, Model model) {
		try {
            Cliente cliente = clienteRepository.findById(id).orElseThrow();
            model.addAttribute("cliente", cliente);
            return "cliente_form_u"; 
        } catch (Exception e) {
           
            return "error"; 
        }
    }
    @PostMapping("/cliente/editar")
    public String editarCliente(@ModelAttribute Cliente cliente, RedirectAttributes redirectAttributes) {
        try {
            clienteRepository.save(cliente);
            redirectAttributes.addFlashAttribute("message","Cliente editado correctamente");
            return "redirect:/cliente";  
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al editar el cliente");  
            return "redirect:/cliente/editar/" + cliente.getId();  
        }
    }
	@GetMapping("/cliente/eliminar/{id}")
	public String eliminarCliente(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		try {
            clienteRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("message","El cliente ha sido eliminado con éxito");
            
        } catch (Exception e) {
        	redirectAttributes.addAttribute("message",e.getMessage());
        }
		return "redirect:/cliente";
	}
}
