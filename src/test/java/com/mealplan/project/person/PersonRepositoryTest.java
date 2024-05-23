package com.mealplan.project.person;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mealplan.project.meal.Meal;
import com.mealplan.project.meal.MealRepository;
import com.mealplan.project.mealplan.MealPlanRepository;



@SpringBootTest
public class PersonRepositoryTest {

  @Autowired
  private PersonRepository personRepo;
  @Autowired
  private MealRepository mealRepo;
  @Autowired
  private MealPlanRepository mpRepo;

  @Test
  public void testLombok(){

    Person u1 = new Person();
    u1.setName("Tester");
    u1.setAge(18);
    
    String name = u1.getName();
    Integer age = u1.getAge();

    assertEquals("Tester", name);
    assertEquals(18, age);
  }

  @Test
  public void testPersonRepository(){
    List<Person> persons = new ArrayList<>();

    Person u1 = new Person();
    Person u2 = new Person();
  
    Meal m1 = mealRepo.findById(1).orElseThrow();
  

    u1.setName("Harry");
    u1.setAge(29);
    u1.setGender(Gender.M);
    u1.setHeight(180.82);
    u1.setWeight(185.00);
    u1.getMeals().add(m1);
    personRepo.save(u1);
    persons.add(u1);

    u2.setName("Sally");
    u2.setAge(27);
    u2.setGender(Gender.F);
    u2.setHeight(150.4);
    u2.setWeight(125.00);
    u2.getMeals().add(m1);
    personRepo.save(u2);
    persons.add(u2);


    long size = personRepo.count();
    assertEquals(persons.size(), size);

    personRepo.delete(u2);
    assertEquals(persons.size()-1, personRepo.count());

    Person u3 = personRepo.findById(1).orElse(new Person());
    u3.setWeight(200.00);
    personRepo.save(u3);

    Person u4 = personRepo.findById(1).orElse(new Person());
    assertEquals("Harry", u4.getName());
    assertEquals(200.00, u4.getWeight());

  }
  @Test
  public void testAddMeal(){
    
  }
 
  
}
