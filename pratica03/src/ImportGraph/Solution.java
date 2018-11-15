package ImportGraph;

import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.alg.clique.ChordalGraphMaxCliqueFinder;
import org.jgrapht.alg.interfaces.CliqueAlgorithm.Clique;
import org.jgrapht.alg.scoring.AlphaCentrality;
import org.jgrapht.alg.scoring.BetweennessCentrality;
import org.jgrapht.alg.scoring.ClosenessCentrality;
import org.jgrapht.alg.scoring.ClusteringCoefficient;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

public class Solution {

	public String alphaCentrality(Graph<DefaultVertex, RelationshipEdge> g) {
		AlphaCentrality<DefaultVertex, RelationshipEdge> value = new AlphaCentrality<DefaultVertex, RelationshipEdge>(g,
				0.1);
		String saida = "";

		for (DefaultVertex chave : g.vertexSet()) {

			saida += chave.toString() + ": " + String.format("%.2f", value.getVertexScore(chave)) + " | ";

		}

		return saida;
	}

	public String closenessCentrality(Graph<DefaultVertex, RelationshipEdge> g) {
		String saida = "";
		ClosenessCentrality<DefaultVertex, RelationshipEdge> value = new ClosenessCentrality<DefaultVertex, RelationshipEdge>(
				g);

		for (DefaultVertex chave : g.vertexSet()) {

			saida += chave.toString() + ": " + String.format("%.2f", value.getVertexScore(chave)) + " | ";

		}

		return saida.substring(0, saida.length() - 3);
	}

	public String betweenCentrality(Graph<DefaultVertex, RelationshipEdge> g) {
		String saida = "";
		BetweennessCentrality<DefaultVertex, RelationshipEdge> value = new BetweennessCentrality(g);
		for (DefaultVertex chave : g.vertexSet()) {
			saida += chave.toString() + ": " + String.format("%.2f", value.getVertexScore(chave)) + " | ";
		}

		return saida;
	}

	public String clusteringCoeficient(Graph<DefaultVertex, RelationshipEdge> g) {
		String saida = "";
		ClusteringCoefficient<DefaultVertex, RelationshipEdge> value = new ClusteringCoefficient(g);
		return String.format("%.2f", value.getGlobalClusteringCoefficient());
	}

	public String maximumClique(Graph<DefaultVertex, RelationshipEdge> g) {
		String saida = "";
		
		ChordalGraphMaxCliqueFinder c = new ChordalGraphMaxCliqueFinder(g);
		Clique clique = c.getClique();
		System.out.println(clique.isEmpty());
		
		return saida;
	}
	
	public Solution() {

	}

}
