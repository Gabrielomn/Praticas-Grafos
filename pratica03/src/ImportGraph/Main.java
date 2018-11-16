package ImportGraph;

import org.jgrapht.Graph;
import org.jgrapht.GraphMetrics;

public class Main {
	
	public static void main(String[] args) {
		ImportSimpleGraphGML importGraph = new ImportSimpleGraphGML();
Graph<DefaultVertex, RelationshipEdge> graph = importGraph.ImportSimpleGraphGML("./graph/lesmis.gml");
        Solution s = new Solution();

        System.out.println("Alpha Centrality\n" + s.alphaCentrality(graph) + System.lineSeparator());
        
        System.out.println("Closeness Centrality\n" + s.closenessCentrality(graph) + System.lineSeparator());
        
        System.out.println("BetweenCentrality\n" + s.betweenCentrality(graph) + System.lineSeparator());
        
        System.out.println("Coeficiente de clusterizacao: " + s.clusteringCoeficient(graph));
        
        System.out.println("Diametro: " + GraphMetrics.getDiameter(graph));
        
        System.out.println(s.maximumClique(graph));
        	
	}

}
