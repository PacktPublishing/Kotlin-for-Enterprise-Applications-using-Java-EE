package org.rao.kotlin.designpatterns.singleton.staticinitialization;

public class Singleton {
  private static Singleton singletonInstance = new Singleton ();

  private Singleton () {}

  public static Singleton getInstance() {
    return  singletonInstance;
  }
  public String getDetails() {
    return "this is a singleton class";
  }
}
