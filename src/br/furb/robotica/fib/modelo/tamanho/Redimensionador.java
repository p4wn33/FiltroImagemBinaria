package br.furb.robotica.fib.modelo.tamanho;

import org.imgscalr.Scalr;

import br.furb.robotica.fib.modelo.imagem.Imagem;

public class Redimensionador {
	
	private static Redimensionador instance;
	
	public static Redimensionador getInstance(){
		if(instance == null){
			instance = new Redimensionador();
		}
		return instance;
	}
	
	public void redimensionar(Imagem img, int limiteBilateral){
		img.setImagem(Scalr.resize(img.getImagem(), Scalr.Method.AUTOMATIC, limiteBilateral, limiteBilateral));
		img.salvarImagemRedimensionada();
	}

}
