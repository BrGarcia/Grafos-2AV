package sistema;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataLoader {

	public static void readFile(String nomeDoArquivoParaLeitura){

		// Try obrigatorio, não precisa coloar o Try para o bloco de codigo todo
		try {
			// Iniciando classes necessarias para a leitura do arquivo
			FileReader fileReader = new FileReader(nomeDoArquivoParaLeitura);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			// Lendo uma linha do arquivo removendo espaces, enter e tabs
			String line = bufferedReader.readLine().replaceAll(" ", "")
					.replaceAll("\n", "").replaceAll("\t", "");

			// cath do FileReader
		} catch (FileNotFoundException e) {

			// cath do IO
		} catch (IOException e) {

		}

	}
}