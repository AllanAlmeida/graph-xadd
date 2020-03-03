package br.radixeng.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.radixeng.entities.Graph;

/**
 *
 */
@RepositoryRestResource(collectionResourceRel = "graph", path = "graph")
public interface GraphRepository extends CrudRepository<Graph, Long>{
    
}
