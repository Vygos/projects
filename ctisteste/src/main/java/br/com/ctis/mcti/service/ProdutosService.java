package br.com.ctis.mcti.service;

import br.com.ctis.mcti.model.Usuario;
import br.com.ctis.mcti.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;

    public void atribuirUsuarioLogado(Usuario user){
        this.usuario = usuarioRepository.findByUsername(user.getUsername());
    }
    public Usuario retonarUsuarioLogado(){
        return usuario;
    }
}
