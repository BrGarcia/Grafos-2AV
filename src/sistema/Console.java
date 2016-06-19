package sistema;

import java.util.Scanner;
import grafo.*;
import algoritmos.*;

public class Console {

	public static void main(String[] args) {
		
		int verticeId, arestaId, verticeOrigem, verticeDestino, ax = 0, peso;

		Grafo grafo = new Grafo();
		System.out.println("Grafos!");
		System.out.println();
		System.out.println("grafo será ordenado?");
		System.out.println("1 - Sim");
		System.out.println("0 - Não");
		System.out.println();
		System.out.println("(Obs. Informar Apenas 0 ou 1)");
		Scanner ler = new Scanner(System.in);
		
		grafo.ordenado = ler.nextInt();
        //grafo.ordenado = 2;
		
		do {//comente esta linha
                        
          /* System.out.println("Gerar de Grafo");//comente esta linha
			System.out.println("Menu:");//comente esta linha
			System.out.println("1 - Criar Vertice");//comente esta linha
			System.out.println("2 - Criar Aresta");//comente esta linha
			System.out.println("3 - Deletar Vertice");//comente esta linha
			System.out.println("4 - Deletar Aresta");//comente esta linha
			System.out.println("5 - Relatorio");//comente esta linha
			System.out.println("0 - Fim");//comente esta linha
			ax = ler.nextInt();//comente esta linha
		*/
			
		
        grafo.criarVertice();
        grafo.criarVertice();
        grafo.criarVertice();
        grafo.criarVertice();
        grafo.criarVertice();
        
        
        //para calcular Termos e Warshall use isso:
        
        grafo.criarAresta(/*origem*/1,/*destino*/2,/*peso*/1);
        grafo.criarAresta(/*origem*/1,/*destino*/3,/*peso*/1);
        grafo.criarAresta(/*origem*/3,/*destino*/2,/*peso*/1);
        grafo.criarAresta(/*origem*/4,/*destino*/5,/*peso*/1);
        
        
        //para calcular Euler, Floyd, Dijikstra, Bellman-Ford e Grafo Conexo, use isso:
        grafo.criarAresta(/*origem*/1,/*destino*/2,/*peso*/1);
        grafo.criarAresta(/*origem*/1,/*destino*/4,/*peso*/4);
        grafo.criarAresta(/*origem*/2,/*destino*/3,/*peso*/3);
        grafo.criarAresta(/*origem*/2,/*destino*/4,/*peso*/1);
        grafo.criarAresta(/*origem*/2,/*destino*/5,/*peso*/5);
        grafo.criarAresta(/*origem*/3,/*destino*/4,/*peso*/2);
        grafo.criarAresta(/*origem*/3,/*destino*/5,/*peso*/2);
        grafo.criarAresta(/*origem*/4,/*destino*/5,/*peso*/3);
        
		//ax = 5;
			switch (ax)
			{
			
				case 0:
					System.out.println("Matriz de adjacencias é:");
					grafo.imprimeMatriz(grafo.geraMatrizAdj());
					System.out.println();
					grafo.imprimeVertices();
					System.out.println();
					grafo.imprimeArestas();
					System.out.println();
					System.out.print("Tem " + grafo.getContV() + " vertices ");
					System.out.println(" e " + grafo.getContA() + " arestas");
					System.out.println();
					System.out.println("Grau max é " + grafo.grauMax());
					System.out.println("Grau minimo é " + grafo.grauMinimo());
					System.out.println("Grau medio é " + grafo.grauMedio());
					if(grafo.conexo()==true)
						System.out.println("Grafo é conexo!");
					else{
						System.out.println("Grafo não é conexo!");
						System.out.println("Vertice nao visitado" + grafo.tVertice.getId());
					}
					if(grafo.caminhoEuler(grafo.geraMatrizAdj()) == true)
						System.out.println("Existe caminho de Euler!");
					else
						System.out.println("Não existe caminho de Euler!");
					System.out.println();
					System.out.println("Matriz de acessibilidade!");
					grafo.imprimeMatriz(grafo.warshall());
					System.out.println();
					System.out.println("Matriz de caminho minimo de Floyd:");
					grafo.imprimeMatriz(grafo.floydWarshall());
					System.out.println("Algoritmo de Floyd-Warshall Fez:" +grafo.getAlgFW()+" iterações");
					System.out.println();
					System.out.println("Dijikstra calcula o caminho minimo informe vertice de Origem:");
					verticeOrigem = ler.nextInt();
					System.out.println("Precisa informar um vertice de destino:");
					verticeDestino = ler.nextInt();
					System.out.println("Distancia minima do vertice " + verticeOrigem + " para Vertice " + verticeDestino + " calculada por Dijikstra: " + grafo.dijkstra(verticeOrigem, verticeDestino));
					System.out.println("Algoritmo de Dijikstra fez " +grafo.getAlgDJ()+" iterações");
					System.out.println();
					System.out.println("Calcular o caminho minimo por Bellman-Ford é preciso informar um vertice de Origem:");
					verticeOrigem = ler.nextInt();
					System.out.println("Distancia minima do vertice " + verticeOrigem + " para os demais vértices é Abaixo:");
					grafo.imprimeBellmanFord(verticeOrigem);
					System.out.println("Algoritmo de Bellman-Ford fez " +grafo.getAlgBF()+" iterações");
					System.out.println();
					System.out.println("Este grafo tem " + grafo.contaTermos() + " termos");
					System.out.println();
					break;
					
				case 1:
					grafo.criarVertice();
					System.out.println("Vertice " + grafo.tVertice1.getId() +" inserido com sucesso!");
					System.out.println();
					break;
					
				case 2:
					System.out.println("Origem da aresta parte de que vertice?");
					verticeId = ler.nextInt();
					verticeOrigem = verticeId;
					verticeId = verticeId -1;
					if(grafo.testaVertice(verticeId)==true){
						System.out.println("Aresta liga o vertice " + verticeOrigem + " a que vertice?");
						verticeId = ler.nextInt();
						verticeDestino = verticeId;
						verticeId = verticeId -1;
						System.out.println("Peso dessa aresta?");
						peso = ler.nextInt();
						if(grafo.testaVertice(verticeId)==true){
							grafo.criarAresta(verticeOrigem, verticeDestino, peso);							
							System.out.println("Grau do vertice " + grafo.tVerticeOut.getId() + " foi atualizado para " + grafo.tVerticeOut.getGrau());
							System.out.println("Grau do vertice " + grafo.tVerticeOutIn.getId() + " foi atualizado para " + grafo.tVerticeOutIn.getGrau());
							System.out.println("Aresta do vertice " + grafo.tAresta.getVerticeOrigem() + " para o vertice " + grafo.tAresta.getVerticeDestino() + " inserida com sucesso!");
							System.out.println();
						}
						else{
							System.out.println("Erro! Vertice de Destino não existe!");
							System.out.println();
						}
					}
					else{
						System.out.println("Erro! Vertice de Origem não existe!");
						System.out.println();
					}
					break;
					
				case 3:
					System.out.println("Informe a vertice que deseja Deletar?");
					verticeId = ler.nextInt();
					verticeId = verticeId-1;
					verticeDestino = verticeId;
					verticeOrigem = 0;
					if(grafo.deletarVertice(verticeId, verticeOrigem, verticeDestino) == true)
						System.out.println("O vertice " + grafo.tVertice.getId() + " e todas as arestas que ligam a ele foram removidos com sucesso!");
					else
						System.out.println("Erro ao remover vertice");
					break;
					
				case 4:
					System.out.println("Informe a aresta deseja Deletar?");
					arestaId = ler.nextInt();
					arestaId = arestaId-1;
					if(grafo.deletarAresta(arestaId) == true){
						arestaId = arestaId+1;
						System.out.println("A aresta " + arestaId + " foi removida com sucesso");
					}
					else
						System.out.println("Erro ao deletar aresta");
					break;
					
				case 5:
					System.out.println("Matriz de adjacencias:");
					grafo.imprimeMatriz(grafo.geraMatrizAdj());
					System.out.println();
					grafo.imprimeVertices();
					System.out.println();
					grafo.imprimeArestas();
					System.out.println();
					System.out.print("Grafo contem " + grafo.getContV() + " vertices ");
					System.out.println(" e " + grafo.getContA() + " arestas");
					System.out.println();
					System.out.println("Grau max:" + grafo.grauMax());
					System.out.println("Grau minimo:" + grafo.grauMinimo());
					System.out.println("Grau medio:" + grafo.grauMedio());
					if(grafo.conexo()==true)
						System.out.println("Grafo Conexo!");
					else{
						System.out.println("Grafo não Conexo!");
						System.out.println("Vertice nao foi visitado:" + grafo.tVertice.getId());
					}
					if(grafo.caminhoEuler(grafo.geraMatrizAdj()) == true)
						System.out.println("Existe o caminho de Euler!");
					else
						System.out.println("Não existe o caminho de Euler!");
					System.out.println();
					System.out.println("Matriz de acessibilidade:");
					grafo.imprimeMatriz(grafo.warshall());
					System.out.println();
					System.out.println("Matriz de caminho minimo por Floyd:");
					grafo.imprimeMatriz(grafo.floydWarshall());
					System.out.println("Algoritmo de Floyd-Warshall fez " +grafo.getAlgFW()+" iterações");
					System.out.println();
					System.out.println("Calcular o caminho minimo por Dijikstra: Informe vertice de Origem:");
					verticeOrigem = ler.nextInt();
					System.out.println("Informar vertice de destino:");
					verticeDestino = ler.nextInt();
					System.out.println("Distancia minima do vertice " + verticeOrigem + " para o vertice " + verticeDestino + " calculada por Dijikstra é: " + grafo.dijkstra(verticeOrigem, verticeDestino));
					System.out.println("O algoritmo de Dijikstra fez " +grafo.getAlgDJ()+" iterações");
					System.out.println();
					System.out.println("Calcular caminho minimo por Bellman-Ford é informe vertice de Origem:");
					verticeOrigem = ler.nextInt();
					System.out.println("Distancias minimas do vertice " + verticeOrigem + " para os demais vértices: vetor abaixo:");
					grafo.imprimeBellmanFord(verticeOrigem);
					System.out.println();
					System.out.println("Algoritmo de Bellman-Ford fez " +grafo.getAlgBF()+" iterações");
					System.out.println();
					System.out.println("Grafo tem " + grafo.contaTermos() + " termos");
					System.out.println();
					break;
			}
			
        }while(ax != 0);//comente esta linha
        
        System.out.println();
		System.out.println("Aplicação Encerrada");
		ler.close();

	}

}
