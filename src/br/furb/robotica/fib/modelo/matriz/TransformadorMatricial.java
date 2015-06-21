package br.furb.robotica.fib.modelo.matriz;

import java.awt.Color;

import br.furb.robotica.fib.modelo.imagem.Imagem;

public class TransformadorMatricial {
	
	private static TransformadorMatricial instance;
	
	public static TransformadorMatricial getInstance(){
		if(instance == null){
			instance = new TransformadorMatricial();
		}
		return instance;
	}
	
	public int[][] transformar(){
		Imagem img = Imagem.getInstance();
		int[][] matriz = new int[img.getImagem().getHeight()][img.getImagem().getWidth()];
		for(int i = 0; i < img.getImagem().getHeight(); i++){
			for(int j = 0; j < img.getImagem().getWidth(); j++){
				int cor = 0;
				int hash = new Color(img.getImagem().getRGB(j, i)).hashCode();
				if(hash == -1){
					cor = 1;
				}
				matriz[i][j] = cor;
			}
		}
		return matriz;
	}
	
}
