package main;

public class tamanhosDeCaminhos {
	private double media;
	private int maximo;
	private int minimo;
	private String target;
	private String origem;
	
	public tamanhosDeCaminhos(double media, int maximo, int minimo, String target,String origem) {
		this.maximo = maximo;
		this.media = media;
		this.minimo = minimo;
		this.target = target;
		this.origem = origem;
	}
	
	public String toString() {
		return "De: " + origem + " Para o no: " + target + ". O max, min e a media sao, respectivamente:  " + maximo + " - " + minimo + " - " + media;
	}
	
	public int getMin() {
		return this.minimo;
	}
}
