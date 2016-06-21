package sistema;

import java.io.IOException;
import java.util.Scanner;
import grafo.*;
import algoritmos.*;

public class Console {

	public static void main(String[] args) {
		MenuPrograma menu = new MenuPrograma();
		Grafo grafoEmUso;
		int verticeId, arestaId, verticeOrigem, verticeDestino, ax = 0, peso;


		ax = menu.menuInicial();


		do{
			switch(ax){
			case 1: break;
			default : break;
			}

		}while(ax != 777);

	}
}
