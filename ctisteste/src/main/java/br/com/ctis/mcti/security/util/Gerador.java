package br.com.ctis.mcti.security.util;

import java.time.*;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.ctis.mcti.model.Usuario;
import br.com.ctis.mcti.repository.UsuarioRepository;

public class Gerador {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public static void main(String... args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
        LocalDate date1 = LocalDate.of(2019,2,1);
        LocalDate date2 = LocalDate.now();
        LocalDate date = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period p = Period.between(date1, date2);

	}
	
}
