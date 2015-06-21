package br.furb.robotica.fib.modelo.imagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagem {
	
	private static Imagem instance;
	private BufferedImage imagem;
	private File arquivo;
	
	public static Imagem getInstance(){
		if(instance == null){
			instance = new Imagem();
		}
		return instance;
	}
	
	public void carregarImagem(String caminho){
		try {
			arquivo = new File(caminho);
			imagem = ImageIO.read(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public BufferedImage getImagem() {
		return imagem;
	}

	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
	}
	
	public File getArquivo(){
		return this.arquivo;
	}
	
	public void salvarImagemRedimensionada(){
		String nomeArquivoOriginal = arquivo.getName();
		String caminhoArquivoOriginal = arquivo.getParent();
		caminhoArquivoOriginal = caminhoArquivoOriginal == null ? "" : caminhoArquivoOriginal + System.getProperty("file.separator");
		try {
			ImageIO.write(imagem, 
					"png", 
					new File(nomeArquivoOriginal.substring(0, nomeArquivoOriginal.length()-4) + "Redimensionada.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void salvarImagemRedimensionadaBinaria(){
		String nomeArquivoOriginal = arquivo.getName();
		String caminhoArquivoOriginal = arquivo.getParent();
		caminhoArquivoOriginal = caminhoArquivoOriginal == null ? "" : caminhoArquivoOriginal + System.getProperty("file.separator");
		try {
			ImageIO.write(imagem, 
					"png", 
					new File(nomeArquivoOriginal.substring(0, nomeArquivoOriginal.length()-4) + "RedimensionadaBinaria.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
