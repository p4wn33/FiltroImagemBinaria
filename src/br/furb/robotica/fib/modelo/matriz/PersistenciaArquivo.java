package br.furb.robotica.fib.modelo.matriz;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
	
	public void gravarArquivoClasseMatriz(String caminho, int matriz[][]){
		Imagem img = Imagem.getInstance();
		String caminhoArquivoOriginal = img.getArquivo().getParent();
		caminhoArquivoOriginal = caminhoArquivoOriginal == null ? "" : caminhoArquivoOriginal + System.getProperty("file.separator");
		StringBuffer conteudoArquivo = new StringBuffer();
		conteudoArquivo.append("package br.furb.bcc.robotica.impressorabinaria.modelo;\n\n");
		conteudoArquivo.append("import java.util.ArrayList;\n\n");
		conteudoArquivo.append("public class Matriz {\n\n");
		conteudoArquivo.append("	private ArrayList<int[]> vetores;\n");
		conteudoArquivo.append("	private ArrayList<Linha> linhas;\n\n");
		conteudoArquivo.append("	public Matriz(ArrayList<int[]> matriz) {\n");
		conteudoArquivo.append("		super();\n");
		conteudoArquivo.append("		this.vetores = matriz;\n");
		conteudoArquivo.append("	}\n\n");
		conteudoArquivo.append("	public Matriz() {\n");
		conteudoArquivo.append("		this.vetores = null;\n");
		conteudoArquivo.append("		this.linhas = null;\n");
		conteudoArquivo.append("	}\n\n");
		conteudoArquivo.append("	public void setVetores(ArrayList<int[]> matriz) {\n");
		conteudoArquivo.append("		this.vetores = matriz;\n");
		conteudoArquivo.append("	}\n\n");
		conteudoArquivo.append("	public ArrayList<int[]> getVetores() {\n");
		conteudoArquivo.append("		return vetores;\n");
		conteudoArquivo.append("	}\n\n");
		conteudoArquivo.append("	public ArrayList<Linha> getLinhas() {\n");
		conteudoArquivo.append("		return linhas;\n");
		conteudoArquivo.append("	}\n\n");
		conteudoArquivo.append("	public void setLinhas(ArrayList<Linha> linhas) {\n");
		conteudoArquivo.append("		this.linhas = linhas;\n");
		conteudoArquivo.append("	}\n\n");
		conteudoArquivo.append("	public int[][] getVetoresEstaticos(){\n");
		conteudoArquivo.append("		return new int[][]{\n");
		for(int i = 0; i < matriz.length; i++){
			conteudoArquivo.append("				{");
			for(int j = 0; j < matriz[0].length; j++){
				conteudoArquivo.append(matriz[i][j]);
				if(j < matriz[0].length-1){
					conteudoArquivo.append(",");
				}
			}
			if(i < matriz.length-1){
				conteudoArquivo.append("},\n");
			} else {
				conteudoArquivo.append("}\n");
			}
		}
		conteudoArquivo.append("				};\n");
		conteudoArquivo.append("	};\n\n");
		conteudoArquivo.append("}");
		System.out.println(conteudoArquivo.toString());
		
		try {
			PrintWriter saida = new PrintWriter("Matriz.java");
			saida.print(conteudoArquivo.toString());
			saida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
