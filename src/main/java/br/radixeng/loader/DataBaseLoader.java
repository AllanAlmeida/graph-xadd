package br.radixeng.loader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.radixeng.entities.Graph;
import br.radixeng.entities.Route;
import br.radixeng.repository.GraphRepository;
import br.radixeng.repository.RouteRepository;

@Component
public class DataBaseLoader implements CommandLineRunner {

	private final GraphRepository graphs;
	
	private final RouteRepository routes;
	
	@Autowired
	public DataBaseLoader(GraphRepository graphRepository, RouteRepository routeRepository) {
		this.graphs = graphRepository;
		this.routes = routeRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		
		Graph graph = new Graph();
		this.graphs.save(graph);
		
		List<Route> listaRotas = new ArrayList<>();
		listaRotas.add(new Route("A", "B", 4, graph));
		listaRotas.add(new Route("A", "E", 8, graph));
		
		this.routes.save(listaRotas);
		
		
	}
}
