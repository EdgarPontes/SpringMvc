package br.com.tecnoticias.ecommerce.aplicacoes;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailJava extends Authenticator {
	private static String titulo;
	private static String imagem;
	private static String assunto;
	private static String email;

	public EmailJava(String email, String titulo, String assunto) {
		this.titulo = titulo;
	//	this.imagem = imagem;
		this.assunto = assunto;
		this.email = email;
	}
	
	

	public void enviar(){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("bellojoyconfirm@gmail.com", "bellojoy123");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(this.titulo);
			
//			if((imagem != null) ||(imagem!= ""))
//				message.setText(this.imagem);
			
			message.setText(this.assunto);

			Transport.send(message);

		} catch (MessagingException e) {
			System.out.println("Erro no envio do email");
		}
	}

		

}
