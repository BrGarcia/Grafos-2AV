package grafo;

public class Aresta {

	private int verticeDestino;
	private int verticeOrigem;
	private int id;
	private int peso;
	
	public Aresta() {}
	
	public Aresta(int vertDestino, int vertOrigem, int peso, int id) {
		this.verticeDestino = vertDestino;
		this.verticeOrigem = vertOrigem;
		this.peso = peso;
		this.id = id;
	}

	public int getVerticeDestino() {
		return verticeDestino;
	}

	public void setVerticeDestino(int vertDestino) {
		this.verticeDestino = vertDestino;
	}

	public int getVerticeOrigem() {
		return verticeOrigem;
	}

	public void setVerticeOrigem(int vertOrigem) {
		this.verticeOrigem = vertOrigem;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Aresta [vertice Destino=" + verticeDestino + ", vertice Origem="
				+ verticeOrigem + ", id=" + id + ", peso=" + peso + "]";
	}

}
