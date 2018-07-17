package com.rodrigo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

  private final UsuarioRepository usuarioRepository;

  @Autowired
  public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @Transactional
  public Usuario cadastrar(UsuarioForm form) {
    Usuario usuario = novoUsuario(form);
    usuarioRepository.save(usuario);
    return usuario;
  }

  private Usuario novoUsuario(UsuarioForm form) {
    Usuario usuario = new Usuario(form.getEmail());
    usuario.setSenha(form.getSenha());
    return usuario;
  }

}
