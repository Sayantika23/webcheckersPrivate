package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;

import com.webcheckers.appl.CheckerCentre;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;


public class HomeController implements TemplateViewRoute {

  private final CheckerCentre checkerCenter;

  HomeController(final CheckerCentre checkerCenter) {
    this.checkerCenter = checkerCenter;
  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Welcome!");
    return new ModelAndView(vm , "home.ftl");
  }

}