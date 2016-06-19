package grafo;

public class Vertice {
	private int grau;
	private int id;
	private boolean visitado;
	
	public Vertice() {}

	public Vertice(int grau, int verticeId) {
		super();
		this.grau = grau;
		this.id = verticeId;
	}

	public int getGrau() {
		return grau;
	}

	public void setGrau(int grau) {
		this.grau = grau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean eVisitado() {
		return visitado;
	}

	public void setPercorrido(boolean percorrido) {
		this.visitado = percorrido;
	}

	@Override
	public String toString() {
		return "Vertice [grau=" + grau + ", id=" + id + ", percorrido="
				+ visitado + "]";
	}

}
