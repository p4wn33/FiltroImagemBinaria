package br.furb.robotica.fib.controle;

import br.furb.robotica.fib.modelo.matriz.PersistenciaArquivo;
import br.furb.robotica.fib.modelo.matriz.TransformadorMatricial;

public class GerenciadorArquivoMatriz {
	
	public void executar(String caminho){
		int matriz[][] = TransformadorMatricial.getInstance().transformar();
		PersistenciaArquivo.getInstance().gravarArquivoMatriz(caminho, matriz);
	}

}
