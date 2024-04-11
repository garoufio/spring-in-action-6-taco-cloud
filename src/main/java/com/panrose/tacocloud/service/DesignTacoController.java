package com.panrose.tacocloud.service;

import com.panrose.tacocloud.entity.Ingredient;
import com.panrose.tacocloud.entity.Ingredient.Type;
import com.panrose.tacocloud.entity.Taco;
import com.panrose.tacocloud.entity.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

  @ModelAttribute
  public void addIngredientsToModel(Model model) {
    List<Ingredient> ingredients = Arrays.asList(
      new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
      new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
      new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
      new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
      new Ingredient("CHBR", "Chicken Breast", Ingredient.Type.PROTEIN),
      new Ingredient("TDLN", "Tenderloin", Ingredient.Type.PROTEIN),
      new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
      new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
      new Ingredient("RDPR", "Red Pepper", Ingredient.Type.VEGGIES),
      new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
      new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
      new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
      new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
    );

    Type[] types = Ingredient.Type.values();
    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
    }
  }

  @PostMapping
  public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder) {
    tacoOrder.addTaco(taco);
    log.info("Processing taco: {}", taco);

    return "redirect:/orders/current";
  }

  @ModelAttribute(name="tacoOrder")
  public TacoOrder tacoOrder() {
    return new TacoOrder();
  }

  @ModelAttribute(name="taco")
  public Taco taco() {
    return new Taco();
  }

  @GetMapping
  public String showDesignForm() {
    return "design";
  }

  private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
    return ingredients.stream()
      .filter(x -> x.getType()
        .equals(type)).collect(Collectors.toList());
  }

}