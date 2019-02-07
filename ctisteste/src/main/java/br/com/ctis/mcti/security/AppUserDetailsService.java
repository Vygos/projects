package br.com.ctis.mcti.security;

import br.com.ctis.mcti.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ctis.mcti.model.Usuario;
import br.com.ctis.mcti.repository.UsuarioRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutosService produtosService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       // Optional<Usuario> usuarioOptional = usuarioRepository.findByUsername(username);
        
        Usuario usuario = usuarioRepository.findByUsername(username);
        produtosService.atribuirUsuarioLogado(usuario);
        System.out.println(usuario.getNome());
        Set<SimpleGrantedAuthority> autorities = new HashSet<>();
        
        autorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        
        return new User(username, usuario.getPassword(), autorities);
    }

//    private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
//        Set<SimpleGrantedAuthority> authority = new HashSet<>();
//        usuario.getPermissoes().forEach(permissao -> authority.add(new SimpleGrantedAuthority(permissao.getDescricao().toUpperCase())));
//        return authority;
//    }
}
