package br.com.ctis.mcti.config;

import br.com.ctis.mcti.model.Usuario;
import br.com.ctis.mcti.service.ProdutosService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Filtro implements Filter{

	private Usuario usuario;

	@Autowired
	private ProdutosService produtosService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String access_token =  httpServletRequest.getHeader("Authorization");
		access_token = access_token.substring(7);
		System.out.println("Requisição: " + access_token);
		//produtosService.retornarUsuarioLogado();
		chain.doFilter(httpServletRequest, response);
	}

	@Override
	public void destroy() {

	}
}
