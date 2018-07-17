package com.rodrigo.test;

import org.junit.Test;

public class UsuarioTest {

  @Test
  public void testName() throws Exception {
    Usuario guilherme = new Usuario("guilherme.pacheco@pontta.com");
    Usuario rodrigo = new Usuario("guilherme.pacheco@pontta.com");

    System.out.println(guilherme.equals(rodrigo));
  }

}
