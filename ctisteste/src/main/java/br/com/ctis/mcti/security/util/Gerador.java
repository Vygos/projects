package br.com.ctis.mcti.security.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.ctis.mcti.model.Usuario;
import br.com.ctis.mcti.repository.UsuarioRepository;

public class Gerador {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public static void main(String... args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		  System.out.println(bCryptPasswordEncoder.encode("victor"));
		
	}
	
}
