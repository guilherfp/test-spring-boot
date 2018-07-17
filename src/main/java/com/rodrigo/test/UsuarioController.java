package com.rodrigo.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioRepository usuarioRepository;
  @Autowired
  private UsuarioService usuarioService;

  @GetMapping
  public String list(Model model) {
    List<Usuario> usuarios = usuarioRepository.findAll();
    model.addAttribute("usuarios", usuarios);
    return "usuario-list";
  }

  @GetMapping("/cadastro")
  public String cadastro(Model model) {
    model.addAttribute("form", new UsuarioForm());
    return "usuario-cadastro";
  }

  @PostMapping("/cadastro")
  public String cadastro(@ModelAttribute UsuarioForm form) {
    usuarioService.cadastrar(form);
    return "redirect:/usuarios";
  }

}
