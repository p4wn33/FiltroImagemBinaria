package br.furb.robotica.fib.controle;

import br.furb.robotica.fib.modelo.filtro.FiltroBinario;
import br.furb.robotica.fib.modelo.imagem.Imagem;
import br.furb.robotica.fib.modelo.tamanho.Redimensionador;

public class GerenciadorFiltro {
	
	public void executar(String caminho, int limiteBilateral, int intensidadeCorPreta){
		Imagem.getInstance().carregarImagem(caminho);
		Redimensionador.getInstance().redimensionar(Imagem.getInstance(), limiteBilateral);
		FiltroBinario.getInstance().aplicarFiltro(Imagem.getInstance(), intensidadeCorPreta);
	}

}
