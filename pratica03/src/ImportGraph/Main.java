package ImportGraph;

import org.jgrapht.Graph;
import org.jgrapht.GraphMetrics;

public class Main {
	
	public static void main(String[] args) {
		ImportSimpleGraphGML importGraph = new ImportSimpleGraphGML();
Graph<DefaultVertex, RelationshipEdge> graph = importGraph.ImportSimpleGraphGML("./graph/lesmis.gml");
        Solution s = new Solution();

        System.out.println(s.alphaCentrality(graph));
        
        System.out.println(s.closenessCentrality(graph));
        
        System.out.println(s.betweenCentrality(graph));
        
        System.out.println(s.clusteringCoeficient(graph));
        
        System.out.println(GraphMetrics.getDiameter(graph));
        
        System.out.println(s.maximumClique(graph));
        	
	}

}
