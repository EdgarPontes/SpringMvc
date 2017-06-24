package br.com.tecnoticias.ecommerce.aplicacoes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import br.com.tecnonoticias.ecommerce.model.Banner;
import br.com.tecnonoticias.ecommerce.model.EmailPromocional;
/**
 * Metodo responsavel por pegar a imagem de uma pasta e salvar na sua pasta no serviço
 * @author Leonardo Andriotti
 *
 */
public class ImagemServidor {
	
	public String updateImage(Banner banner,String nomeArquivo, String pasta) throws IOException {
		File origem = new File("C:/Users/Leonardo Andriotti/Desktop/" + nomeArquivo);

		FileInputStream fis = new FileInputStream(origem);

		File destino = new File(
				"C:\\Users\\Leonardo Andriotti\\workspace\\bellojoy\\image\\" + pasta + "\\" + nomeArquivo);
		FileOutputStream fos = new FileOutputStream(destino);

		int count = 0;

		byte[] bytes = new byte[1024];

		while ((count = fis.read(bytes)) >= 0)
			fos.write(bytes, 0, count);

		return destino.toString();
	}
	public String updateImage(EmailPromocional email, String nomeArquivo, String pasta) throws IOException {

		File origem = new File("C:/Users/Leonardo Andriotti/Desktop/" + email.getImagem());

		FileInputStream fis = new FileInputStream(origem);

		File destino = new File(
				"C:\\Users\\Leonardo Andriotti\\workspace\\bellojoy\\image\\" + pasta + "\\" + nomeArquivo);
		FileOutputStream fos = new FileOutputStream(destino);

		int count = 0;

		byte[] bytes = new byte[1024];

		while ((count = fis.read(bytes)) >= 0)
			fos.write(bytes, 0, count);

		return destino.toString();
	}
}
