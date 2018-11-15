package Questoes;

import ImportGraph.ImportSimpleGraphGML;
import org.jgrapht.Graph;


public class Main
{

    static Graph graph;

    public static void main(String[] args)
    {
        ImportSimpleGraphGML importGraph = new ImportSimpleGraphGML();
        graph = importGraph.ImportSimpleGraphGML("./graph/lesmis.gml");

        System.out.println(graph.vertexSet());
    }
}
