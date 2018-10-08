package main;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class Main {
	
	public static void main(String[] args) {
		DefaultDirectedGraph<String, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
		
		g.addVertex("1");		g.addVertex("11");
		g.addVertex("2");		g.addVertex("12");
		g.addVertex("3");		g.addVertex("13");
		g.addVertex("4");		g.addVertex("14");
		g.addVertex("5");		g.addVertex("15");
		g.addVertex("6");		g.addVertex("16");
		g.addVertex("7");		g.addVertex("17");
		g.addVertex("8");		g.addVertex("18");
		g.addVertex("9");		g.addVertex("19");
		g.addVertex("10");		g.addVertex("20");
		
		g.addEdge("1", "2");	g.addEdge("2", "6");	g.addEdge("6", "5");
		g.addEdge("5", "1");	g.addEdge("6", "7");	g.addEdge("7", "3");
		g.addEdge("3", "2");	g.addEdge("3", "4");	g.addEdge("8", "4");
		g.addEdge("8", "7");	g.addEdge("5", "9"); 	g.addEdge("9", "10");
		g.addEdge("6", "10");	g.addEdge("11", "10");	g.addEdge("11", "7");
		g.addEdge("12", "11");	g.addEdge("8", "12");	g.addEdge("13", "9");
		g.addEdge("13", "14");	g.addEdge("14", "10");	g.addEdge("15", "14");
		g.addEdge("11", "15");	g.addEdge("16", "15");	g.addEdge("12", "16");
		g.addEdge("17", "13");	g.addEdge("17", "18");	g.addEdge("14", "18");
		g.addEdge("19", "18");	g.addEdge("15", "19");	g.addEdge("20", "16");
		g.addEdge("20", "19");
		
		Solution sol = new Solution(g);
		sol.Questao2();
		System.out.println(sol.respostas());
	}
	
}