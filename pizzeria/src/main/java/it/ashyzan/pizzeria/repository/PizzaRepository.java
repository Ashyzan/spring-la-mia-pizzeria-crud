package it.ashyzan.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ashyzan.pizzeria.model.PizzaModel;

public interface PizzaRepository extends JpaRepository<PizzaModel, Integer> {

}
