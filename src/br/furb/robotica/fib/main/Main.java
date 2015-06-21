package br.furb.robotica.fib.main;

import java.io.IOException;

import br.furb.robotica.fib.controle.GerenciadorArquivoMatriz;
import br.furb.robotica.fib.controle.GerenciadorFiltro;

public class Main {
	
	/**
	 * @param args {caminhoArquivo, limiteBidimensional, intensidadeCorPreta}
	 * caminhoArquivo = string com o caminho absoluto ate a imagem
	 * limiteBidimensional = limite dimensional da imagem aplicado a altura e largura, mantendo a proporcao original
	 * intensidadeCorPreta = utilizado pelo filtro para detectar a quantidade de cores a serem transformada em preto
	 * @throws IOException
	 */
	public static void main(String[] args) {
		String caminhoArquivo = args[0];
		int limiteBidimensional = Integer.parseInt(args[1]);
		int intensidadeCorPreta = Integer.parseInt(args[2]);
		GerenciadorFiltro gf = new GerenciadorFiltro();
		GerenciadorArquivoMatriz gam = new GerenciadorArquivoMatriz();
		gf.executar(caminhoArquivo, limiteBidimensional, intensidadeCorPreta);
		gam.executar(caminhoArquivo);
	}

}
