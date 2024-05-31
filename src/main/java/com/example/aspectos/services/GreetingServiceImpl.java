package com.example.aspectos.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

  @Override
  public String sayHello(String person, String phrase) {

    String greeting = phrase + " " + person + "!";

    System.out.println(greeting);

    return greeting;
  }

  @Override
  public String sayHelloError(String person, String phrase) {

    throw new RuntimeException("RuntimeException method 'sayHelloError'");
  }

  @Override
  public String sayHelloAround(String person, String phrase) {

    String greeting = phrase + " " + person + "!";

    System.out.println(greeting);

    return greeting;
  }

}
