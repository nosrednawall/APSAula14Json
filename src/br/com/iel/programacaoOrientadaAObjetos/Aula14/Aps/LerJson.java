/*
 * @autor Anderson José de Souza Inácio
 * Classe responsável por ler o arquivo em formato json e imprimi-lo na tela
 */

package br.com.iel.programacaoOrientadaAObjetos.Aula14.Aps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LerJson {

	public LerJson() {
		int loopQtda=200;
		Gson gson =								//objeto json responsável por fazer o parse
				new GsonBuilder() .create();
		try {
			FileReader ler = 						//objeto responsável por ler o arquivo
					new FileReader("alunos.json");
			BufferedReader leitor =	
					new BufferedReader(ler);
			for(int i = 0; i< loopQtda;i++){		//loop para ler e criar os objetos
				String aux = leitor.readLine();		//lendo linha a linha do arquivo
				Aluno aluno= gson.fromJson(aux, Aluno.class);	//convertendo e criando os objetos
				
				int iAux=i+1;				//auxiliar para mostrar a qtda de alunos no número correto 1 a 200
				System.out.println("Aluno "+iAux+" de 200");
				System.out.print("AG: "+aluno.ag+"\n"+"Nome: "+ aluno.nome+"\n"+"Período: "+aluno.periodo+"\n");
				System.out.println("_______________________________________________");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
