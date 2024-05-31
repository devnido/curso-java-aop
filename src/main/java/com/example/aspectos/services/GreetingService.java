package com.example.aspectos.services;

public interface GreetingService {

  String sayHello(String person, String phrase);

  String sayHelloError(String person, String phrase);

  String sayHelloAround(String person, String phrase);

}
