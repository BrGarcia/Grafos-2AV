package sistema;


import java.util.Scanner;


public class MenuPrograma {
	
	public int menuInicial(){
		System.out.println("Grafos!");
		System.out.println();
		System.out.println("grafo ser� ordenado?");
		System.out.println("1 - Sim");
		System.out.println("0 - N�o");
		System.out.println();
		System.out.println("(Obs. Informar Apenas 0 ou 1)");
		int opcao = new Scanner(System.in).nextInt();
		return opcao;
	}


}
