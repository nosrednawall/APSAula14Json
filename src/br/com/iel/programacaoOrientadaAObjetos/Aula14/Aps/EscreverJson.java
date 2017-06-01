package br.com.iel.programacaoOrientadaAObjetos.Aula14.Aps;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.google.gson.Gson;

/*@autor: Anderson José de Souza Inácio
 * 
 * Classe responsável por gerar os dados aleatórios e gravar no arquivo em formato json
 * 
 */

public class EscreverJson {

	public EscreverJson() {
		
		int loopQtda = 200;
		Gson gsonAluno = 
				new Gson();//objeto responsável para transformar os objetos em json
		ArrayList<Aluno> listaAluno = 
				new ArrayList<Aluno>();//objeto responsável para efetuar o  array de objetos
		try {
			FileWriter escrever =
					new FileWriter("alunos.json"); //objeto responsável por efetuar a criação do arquivo e gravação dos objetos
			for(int i =0; i<loopQtda ;i++){ //loop 200 alunos
				
				int a = new Random().nextInt(8) + 1; //variavel auxiliar para efety=uar numero ramdomico
				String[] nomesLista={"Juan","Maria","José","Luke","Rafaela","Mayara","Marcela","Bianca"};
				String[] sobreNomesLista={"Carvalho","Almeida","Pimpão","Ignácio","Silva","Salvatore","Costa","Oak"};
				
				Aluno aluno=new Aluno();
				aluno.ag= a*a*a; //AG com número aleatório
				aluno.nome=nomesLista[a-1]+sobreNomesLista[a-1]; //Nome e sobre nome aleatórios
				aluno.periodo=a;
				listaAluno.add(i, aluno);			
			}
			for (int i = 0; i<listaAluno.size(); i++){
				String aux=gsonAluno.toJson(listaAluno.get(i))+"\n"; //criando string json apartir do objeto com indice
				escrever.write(aux); //escrevendo o json no arquivo
				System.out.println(aux);// retorno da gravação 
			}
			escrever.close();//fechando o arquivo
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}