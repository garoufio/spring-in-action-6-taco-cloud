package com.panrose.tacocloud.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.panrose.tacocloud.entity.Ingredient;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

  private Map<String, Ingredient> ingredientMap = new HashMap<>();

  public IngredientByIdConverter() {
    ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
    ingredientMap.put("COTO", new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP));
    ingredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
    ingredientMap.put("CARN", new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN));
    ingredientMap.put("CHBR", new Ingredient("CHBR", "Chicken Breast", Ingredient.Type.PROTEIN));
    ingredientMap.put("TDLN", new Ingredient("TDLN", "Tenderloin", Ingredient.Type.PROTEIN));
    ingredientMap.put("TMTO", new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
    ingredientMap.put("LETC", new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES));
    ingredientMap.put("RDPR", new Ingredient("RDPR", "Red Pepper", Ingredient.Type.VEGGIES));
    ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
    ingredientMap.put("JACK", new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
    ingredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
    ingredientMap.put("SRCR", new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
  }

  @Override
  public Ingredient convert(String id) {
    return ingredientMap.get(id);
  }

}