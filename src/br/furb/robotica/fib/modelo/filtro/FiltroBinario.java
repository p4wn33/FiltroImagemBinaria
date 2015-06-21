package br.furb.robotica.fib.modelo.filtro;

import java.awt.Color;
import java.awt.image.BufferedImage;

import br.furb.robotica.fib.modelo.imagem.Imagem;

/**
 * Com base em: 
 * http://stackoverflow.com/questions/14851049/how-to-convert-color-image-to-pure-black-and-white-image0-255-format
 */
public class FiltroBinario {

	private static FiltroBinario instance;

	public static FiltroBinario getInstance() {
		if (instance == null) {
			instance = new FiltroBinario();
		}
		return instance;
	}

	public void aplicarFiltro(int intensidadeCorPreta) {
		Imagem img = Imagem.getInstance();
		BufferedImage binaria = new BufferedImage(img.getImagem().getWidth(),
				img.getImagem().getHeight(), BufferedImage.TYPE_BYTE_BINARY);
		int vermelho;
		int verde;
		int azul;
		int novoPixel;
		for (int i = 0; i < img.getImagem().getWidth(); i++) {
			for (int j = 0; j < img.getImagem().getHeight(); j++) {

				vermelho = new Color(img.getImagem().getRGB(i, j)).getRed();
				verde = new Color(img.getImagem().getRGB(i, j)).getGreen();
				azul = new Color(img.getImagem().getRGB(i, j)).getBlue();

				int avg = (vermelho + verde + azul) / 3;

				int alpha = new Color(img.getImagem().getRGB(i, j)).getAlpha();

				if (avg > intensidadeCorPreta) {
					novoPixel = 255;
				} else {
					novoPixel = 0;
				}
				novoPixel = corParaRGB(alpha, novoPixel, novoPixel, novoPixel);
				binaria.setRGB(i, j, novoPixel);

			}
		}
		img.setImagem(binaria);
		img.salvarImagemRedimensionadaBinaria();
	}

	private static int corParaRGB(int alpha, int red, int green, int blue) {
		int novoPixel = 0;
		novoPixel += alpha;
		novoPixel = novoPixel << 8;
		novoPixel += red;
		novoPixel = novoPixel << 8;
		novoPixel += green;
		novoPixel = novoPixel << 8;
		novoPixel += blue;
		return novoPixel;
	}

}
