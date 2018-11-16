package ImportGraph;

public class VerticeEValor implements Comparable{
	
	private DefaultVertex vertice;
	private double valor;
	
	public VerticeEValor(DefaultVertex vertice, double valor) {
		this.vertice = vertice;
		this.valor = valor;
	}
	
	public String toString() {
		return vertice.toString() + ": " + String.format("%.2f", valor);
	}

	@Override
	public int compareTo(Object arg0) {
		VerticeEValor outro = (VerticeEValor) arg0;
		if(this.valor == outro.valor) {
			return 0;
		}
		else if(this.valor > outro.valor) {
			return -1;
		}else {
			return 1;
		}
	}
}
