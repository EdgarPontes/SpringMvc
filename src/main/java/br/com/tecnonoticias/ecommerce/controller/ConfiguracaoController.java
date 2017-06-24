package br.com.tecnonoticias.ecommerce.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.tecnonoticias.ecommerce.model.CadastroAdmin;
import br.com.tecnonoticias.ecommerce.model.SenhaConfirmacao;
import br.com.tecnonoticias.ecommerce.repository.CadastrosAdmin;
import br.com.tecnoticias.ecommerce.aplicacoes.EmailJava;

@Controller
@RequestMapping("configuracao")
public class ConfiguracaoController {
	
	private String mensagens;
	private final String PESQUISA_CONFIGURACAO_VIEW = "pesquisaConfiguracao";
	private final String CONFIRMACAO_VIEW = "configuracao";
    @Autowired
	private CadastrosAdmin cadastros;
    

    
	
    @RequestMapping("/novo")
    public ModelAndView novo(){
    	ModelAndView mv = new ModelAndView(CONFIRMACAO_VIEW);
    	mv.addObject(new CadastroAdmin());
    	return mv;
    }
    
    
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(CadastroAdmin cadastro,SenhaConfirmacao confirmacao){
		
		ModelAndView mv = new ModelAndView(CONFIRMACAO_VIEW);
		
		if (validaCampos(confirmacao, cadastro)) {
			cadastro.setData(getDataAtual());
			cadastro.setPermissao("ADMIN");
			cadastros.save(cadastro);
			EmailJava emailConfirmacao = new EmailJava(cadastro.getEmail(), cadastro.getSenha(), cadastro.getUsuario());
			emailConfirmacao.enviar();
			mv.addObject("mensagem", "Registrado com Sucesso");
		}else{
			mv.addObject("mensagemError", mensagens);
		}
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar(@RequestParam(defaultValue ="%") String configuracao) {
		List<CadastroAdmin> todosCadastros = cadastros.findByUsuarioContaining(configuracao);
		ModelAndView mv = new ModelAndView(PESQUISA_CONFIGURACAO_VIEW);
		mv.addObject("cadastros", todosCadastros);
		
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edcao(@PathVariable("codigo") CadastroAdmin cadastro){
		
		ModelAndView mv = new ModelAndView(CONFIRMACAO_VIEW);
		mv.addObject(cadastro);
		return mv;
	}
	public boolean validaCampos(SenhaConfirmacao confirmacao,CadastroAdmin cadastro){
		if (!cadastro.getSenha().equals(confirmacao.getConfirmacao())) {
			this.mensagens = "Senha não está correta";
			return false;
		} else if (cadastro.getSenha().length() < 8) {
			this.mensagens = "Senha tem conter no minimo 8 caracteres";
			return false;
		} else
			return true;
	}
	
	public Date getDataAtual(){
		Date agora = new Date();
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
		return agora;
	}
}
