package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class Solution {
	private HashMap<String, ArrayList<tamanhosDeCaminhos>> tamanhos;
	private HashMap<String, ArrayList<String>> naoPossiveis;
	private DefaultDirectedGraph<String, DefaultEdge> grafo;
	private HashMap<String, Boolean> possiveisDeAlcançar;

	public Solution(DefaultDirectedGraph<String, DefaultEdge> grafo) {
		this.grafo = grafo;
		this.tamanhos = new HashMap<>();
		this.naoPossiveis = new HashMap<>();
		this.possiveisDeAlcançar = new HashMap<>();
		
		for (String a: grafo.vertexSet()) {
			this.possiveisDeAlcançar.put(a, false);
		}
		
	}

	public void Questao2() {

		Set<String> vertices = this.grafo.vertexSet();
		AllDirectedPaths e = new AllDirectedPaths<>(this.grafo);

		for (String origem : vertices) {
			ArrayList<String> naoP = new ArrayList<>();
			ArrayList<tamanhosDeCaminhos> k = new ArrayList<>();
			naoPossiveis.put(origem, naoP);
			tamanhos.put(origem, k);

			for (String target : vertices) {
				if (!origem.equals(target)) {
					List<GraphPath<String, DefaultEdge>> caminho = e.getAllPaths(origem, target, true, vertices.size());
					if (caminho.size() == 0)
						naoPossiveis.get(origem).add(target);
					else {
						this.possiveisDeAlcançar.put(target, true);
					}
					this.tamanhos(caminho, origem, target);
				}

			}
		}

	}

	public void tamanhos(List<GraphPath<String, DefaultEdge>> paths, String origem, String target) {

		double[] saida = new double[3];
		int maior = 0;
		int menor = Integer.MAX_VALUE;
		int soma = 0;
		int media;
		for (GraphPath e : paths) {
			int atual = e.getLength();
			soma += atual;
			if (atual < menor) {
				menor = atual;
			}
			if (atual > maior) {
				maior = atual;
			}

		}

		if (paths.size() != 0) {

			media = soma / paths.size();
		} else {
			media = 0;
		}
		this.tamanhos.get(origem).add(new tamanhosDeCaminhos(media, maior, menor, target, origem));
	}

	public String respostas() {
		String saida = "";
		Set<String> nos = this.grafo.vertexSet();

		saida += "Nao é possivel chegar de x em []\n";

		for (String n : nos) {
			saida += n + " - " + this.naoPossiveis.get(n) + "\n";
		}

		saida += "\nQuanto aos tamanhos:\n";

		for (String n : nos) {

			for (tamanhosDeCaminhos a : this.tamanhos.get(n)) {
				
				saida += a + "\n";
				
			}
		}
		
		saida += "\n\nNao é possivel chegar em:\n";
		
		for (String n: nos) {
			if (this.possiveisDeAlcançar.get(n) == false) {
				saida += n + " - ";
			}
		}

		return saida;
	}
}