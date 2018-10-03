package org.rao.kotlin.designpatterns.singleton.multithread;

public class Singleton {
  private static Singleton singletonInstance;

  private Singleton () {}

  public static synchronized Singleton getInstance() {
    if(singletonInstance == null){
      singletonInstance = new Singleton ();
    }
    return  singletonInstance;
  }
  public String getDetails() {
    return "this is a singleton class";
  }
}
