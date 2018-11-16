package ImportGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.clique.BronKerboschCliqueFinder;
import org.jgrapht.alg.scoring.AlphaCentrality;
import org.jgrapht.alg.scoring.BetweennessCentrality;
import org.jgrapht.alg.scoring.ClosenessCentrality;
import org.jgrapht.alg.scoring.ClusteringCoefficient;

public class Solution {

	public String alphaCentrality(Graph<DefaultVertex, RelationshipEdge> g) {
		AlphaCentrality<DefaultVertex, RelationshipEdge> value = new AlphaCentrality<DefaultVertex, RelationshipEdge>(g,
				0.1);
		String saida = "";
		List<VerticeEValor> lista = new ArrayList<>();	
		for (DefaultVertex chave : g.vertexSet()) {
			lista.add(new VerticeEValor(chave, value.getVertexScore(chave)));
			//saida += chave.toString() + ": " + String.format("%.2f", value.getVertexScore(chave)) + " | ";

		}
		
		Collections.sort(lista);
		for(VerticeEValor v: lista) {
			saida += v + " | ";
		}

		return saida.substring(0, saida.length() - 3);
	}

	public String closenessCentrality(Graph<DefaultVertex, RelationshipEdge> g) {
		String saida = "";
		ClosenessCentrality<DefaultVertex, RelationshipEdge> value = new ClosenessCentrality<DefaultVertex, RelationshipEdge>(
				g);

		List<VerticeEValor> lista = new ArrayList<>();	

		for (DefaultVertex chave : g.vertexSet()) {
			lista.add(new VerticeEValor(chave, value.getVertexScore(chave)));
		//	saida += chave.toString() + ": " + String.format("%.2f", value.getVertexScore(chave)) + " | ";

		}
		
		Collections.sort(lista);
		for(VerticeEValor v: lista) {
			saida += v + " | ";
		}

		return saida.substring(0, saida.length() - 3);
	}

	public String betweenCentrality(Graph<DefaultVertex, RelationshipEdge> g) {
		String saida = "";
		BetweennessCentrality<DefaultVertex, RelationshipEdge> value = new BetweennessCentrality(g);
		List<VerticeEValor> lista = new ArrayList<VerticeEValor>();	

		for (DefaultVertex chave : g.vertexSet()) {
			lista.add(new VerticeEValor(chave, value.getVertexScore(chave)));
		}

		Collections.sort(lista);
		for(VerticeEValor v: lista) {
			saida += v + " | ";
		}	
		
		
		return saida.substring(0, saida.length() - 3);
	}

	public String clusteringCoeficient(Graph<DefaultVertex, RelationshipEdge> g) {
		String saida = "";
		ClusteringCoefficient<DefaultVertex, RelationshipEdge> value = new ClusteringCoefficient(g);
		return String.format("%.2f", value.getGlobalClusteringCoefficient());
	}

	public String maximumClique(Graph<DefaultVertex, RelationshipEdge> g) {
		String saida = "";
		BronKerboschCliqueFinder<DefaultVertex, RelationshipEdge> clique = new BronKerboschCliqueFinder<>(g);
		Iterator<Set<DefaultVertex>> a = clique.maximumIterator();
		int cont = 0;
		for(Iterator i = a; i.hasNext();){
			Set<DefaultVertex> b =  (Set<DefaultVertex>) i.next();
			saida += (cont + 1) + "º clique maximal" + System.lineSeparator();
			for(DefaultVertex v: b) {
				saida += v.toString() + " | ";
			}
			
			saida = saida.substring(0, saida.length() - 3) + System.lineSeparator();
			cont++;
		}
		
		return saida;
	}
	
	public Solution() {

	}

}
