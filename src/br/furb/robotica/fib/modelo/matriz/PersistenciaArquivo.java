package br.furb.robotica.fib.modelo.matriz;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import br.furb.robotica.fib.modelo.imagem.Imagem;

public class PersistenciaArquivo {
	
	private static PersistenciaArquivo instance;
	
	public static PersistenciaArquivo getInstance(){
		if(instance == null){
			instance = new PersistenciaArquivo();
		}
		return instance;
	}
	
	public void gravarArquivoMatriz(String caminho, int matriz[][]){
		Imagem img = Imagem.getInstance();
		String nomeArquivoOriginal = img.getArquivo().getName();
		String caminhoArquivoOriginal = img.getArquivo().getParent();
		caminhoArquivoOriginal = caminhoArquivoOriginal == null ? "" : caminhoArquivoOriginal + System.getProperty("file.separator");
		StringBuffer conteudoArquivo = new StringBuffer();
		for(int i = 0; i < matriz.length; i++){
			if(!conteudoArquivo.toString().isEmpty()){
				conteudoArquivo.append("\n");
			}
			for(int j = 0; j < matriz[0].length; j++){
				conteudoArquivo.append(matriz[i][j]);
			}
		}
		try {
			PrintWriter saida = new PrintWriter(nomeArquivoOriginal.substring(0, nomeArquivoOriginal.length()-4) + ".matriz");
			saida.print(conteudoArquivo.toString());
			saida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
