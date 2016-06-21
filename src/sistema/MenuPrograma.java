package sistema;
import java.util.Scanner;


public class MenuPrograma {

	public int menuInicial(){
		System.out.println("MATCOMP - GRAPHANALYSIS");
		System.out.println("MENU");
		System.out.println("1 - Criar Grafo");
		System.out.println("2 - Criar Vértice");
		System.out.println("3 - Criar Aresta");
		System.out.println("4 - Deletar Grafo ");
		System.out.println("5 - Deletar Vértice");
		System.out.println("6 - Deletar Aresta");
		System.out.println("7 - Relatorio");
		System.out.println("8 - Ferramentas");
		System.out.println("9 - Carregar Exemplos");
		System.out.println("0 - Fim");
			
		int opcao = new Scanner(System.in).nextInt();
		switch(opcao) {
		case 1: return menuCriarGrafo();
		case 2:	return 2;
		case 3: System.out.println("3 - Criar Aresta"); 		break;
		case 4: System.out.println("4 - Deletar Grafo "); 		break;
		case 5: System.out.println("5 - Deletar Vértice"); 		break;
		case 6: System.out.println("6 - Deletar Aresta"); 		break;
		case 7: System.out.println("7 - Relatorio"); 			break;
		case 8: System.out.println("8 - Ferramentas"); 			break;
		case 9: System.out.println("9 - Carregar Exemplos"); 	break;
		default : return 777;
		}
		return 777;
	}

	public int menuCriarGrafo(){
		System.out.println("Grafos!");
		System.out.println();
		System.out.println("grafo será ordenado?");
		System.out.println("1 - Sim");
		System.out.println("0 - Não");
		System.out.println();
		System.out.println("(Obs. Informar Apenas 0 ou 1)");
		int opcao = new Scanner(System.in).nextInt();
		switch(opcao) {
		case 0: return 10;
		case 1: return 11;
		default: System.out.println("Opção inválida"); return 777;
		}
	}
	public int menuTerciario(){
		int opcao = new Scanner(System.in).nextInt();
		return opcao;
	}
}
