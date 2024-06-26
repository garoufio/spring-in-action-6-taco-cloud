package com.panrose.tacocloud.service;

import lombok.extern.slf4j.Slf4j;
import com.panrose.tacocloud.entity.TacoOrder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

  @GetMapping("/current")
  public String orderForm() {
    return "orderForm";
  }

  @PostMapping
  public String processOrder(TacoOrder tacoOrder, SessionStatus sessionStatus) {
    log.info("Order submitted: {}", tacoOrder);
    sessionStatus.setComplete();

    return "redirect:/";
  }

}