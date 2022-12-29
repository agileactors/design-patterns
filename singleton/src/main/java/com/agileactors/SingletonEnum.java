package com.agileactors;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum types are considered as the best practice for Singletons.
 */
public enum SingletonEnum {

  INSTANCE;

  private final List<Object> myLocalState = new ArrayList<>();

  public void add(Object object) {
    myLocalState.add(object);
  }

  public void remove(int index) {
    if (myLocalState.isEmpty() || myLocalState.get(index) == null) {
      return;
    }
    myLocalState.remove(index);

  }

  public void print() {
    System.out.println(myLocalState);
  }
}
