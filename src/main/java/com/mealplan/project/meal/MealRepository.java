package com.mealplan.project.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MealRepository extends CrudRepository<Meal,Integer>{
  
}
