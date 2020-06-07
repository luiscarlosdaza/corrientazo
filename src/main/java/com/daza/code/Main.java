package com.daza.code;

import com.daza.code.model.Path;
import com.daza.code.service.RouteService;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    //Read file
    RouteService routeService = new RouteService();
    List<Path> paths =  routeService.getRoutes("in01.txt");
    paths.stream().map(a -> a.toString()).forEach(System.out::println);

    //Process file
    //Generate new file
  }
}
