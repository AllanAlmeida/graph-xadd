package br.radixeng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.radixeng.entities.Route;

/**
*
*/
@RepositoryRestResource
public interface RouteRepository extends JpaRepository<Route, Long>{}
