package br.com.tecnonoticias.ecommerce.autenticacao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import br.com.tecnonoticias.ecommerce.model.CadastroAdmin;
import br.com.tecnonoticias.ecommerce.model.Cliente;
import br.com.tecnonoticias.ecommerce.repository.CadastrosAdmin;
import br.com.tecnonoticias.ecommerce.repository.Clientes;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired 
	private CadastrosAdmin cadastroAdminBanco;
	
	@Autowired 
	private Clientes cadastroClienteBanco;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
		 .disable();
		http.authorizeRequests()
		    .antMatchers("/indexAdmin/**","/listaProdutos").hasRole("ADMIN")
		    .antMatchers("/cliente/clienteAdmin","/banner/**","/categoria/**","/emailPromocional/**").hasRole("ADMIN")
		    .antMatchers("/contato/**","/configuracao/**").hasRole("ADMIN")
		    .antMatchers("/carrinho/**","/meuCadastro/**","/minhasCompras/**","/carrinhoPagamento/**").hasRole("USER")
		   // .antMatchers("/css/**", "/js/**","/img/**","/fonts/**","/libs/**","/font-awesome/**","/resources/**").permitAll()
			.anyRequest()
				.permitAll()
			.and()
				.formLogin()
					.loginPage("/login")
					.loginProcessingUrl("/login")
					.defaultSuccessUrl("/index")
					.failureUrl("/login?erro=semacesso")
					.usernameParameter("email")
					.passwordParameter("password")
			.and()
				.logout()
				.logoutUrl("/sair")
				.logoutSuccessUrl("/login");
		
		//http.csrf().disable();
				 
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// auth.userDetailsService(servicoAutenticacao);
		List<CadastroAdmin> cadastroAdmin = cadastroAdminBanco.findAll();
		List<Cliente> cadastroCliente = cadastroClienteBanco.findAll();
		
		for (CadastroAdmin usuario : cadastroAdmin) {
			InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryAuthentication = auth.inMemoryAuthentication();
			inMemoryAuthentication.withUser(usuario.getUsuario()).password(usuario.getSenha()).roles(usuario.getPermissao());
		}
		for (Cliente cliente : cadastroCliente) {
			InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryAuthentication = auth.inMemoryAuthentication();
			inMemoryAuthentication.withUser(cliente.getEmail()).password(cliente.getSenha()).roles(cliente.getPermissao());
		}
		//.passwordEncoder(encoder());
		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryAuthentication = auth.inMemoryAuthentication();
		   inMemoryAuthentication.withUser("ecommerce").password("20142018").roles("ADMIN");
	}


}