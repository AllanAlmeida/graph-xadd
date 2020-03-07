package br.radixeng.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.radixeng.entities.Graph;
import br.radixeng.entities.Route;
import br.radixeng.repository.GraphRepository;

@Component
public class DataBaseLoader implements CommandLineRunner {

	private final GraphRepository graph;
	
	@Autowired
	public DataBaseLoader(GraphRepository graphRepository) {
		this.graph = graphRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		
		Graph graph = new Graph();
		graph.getData().add(new Route("A", "B", 4));
		graph.getData().add(new Route("A", "E", 8));
		
		this.graph.save(graph);
		
		
	}
}
