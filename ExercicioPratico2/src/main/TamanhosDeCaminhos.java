package main;

/**
 * Entidade que representa os tamanhos e se é possivel chegar em um determinado
 * no a partir de outro.
 * @author Gabriel de Oliveira e Daniel Figueredo
 *
 */
public class TamanhosDeCaminhos {
	private double media;
	private int maximo;
	private int minimo;
	private String target;
	private String origem;
	private boolean alcançavel;

	/**
	 * Construtor que instancia as informações sobre os tamanhos de caminhos entre
	 * dois nos. 
	 * @param media
	 * @param maximo
	 * @param minimo
	 * @param target
	 * @param origem
	 */
	public TamanhosDeCaminhos(double media, int maximo, int minimo, String target, String origem) {
		this.maximo = maximo;
		this.media = media;
		this.minimo = minimo;
		this.target = target;
		this.origem = origem;
		if (media == 0.0) {
			this.alcançavel = false;
		} else {
			this.alcançavel = true;
		}
	}

	/**
	 * Imprime os tamanhos de caminhos, se for impossível chegar em target
	 * a partir de origem ele diz que é impossível.
	 */
	public String toString() {
		if(this.alcançavel)
			return "De: " + this.origem + " Para o no: " + this.target + ". O max, min e a media sao, respectivamente:  " + maximo + " - " + minimo + " - " + media;
		else
			return "De: " + this.origem + " Para o no: " + this.target + " é impossivel de se chegar.";
	}
}
