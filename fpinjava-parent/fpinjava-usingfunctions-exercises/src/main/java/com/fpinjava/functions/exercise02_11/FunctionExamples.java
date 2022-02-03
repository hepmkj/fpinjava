package com.fpinjava.functions.exercise02_11;


public class FunctionExamples {

  public static <T, U, V> Function<U, Function<T, V>> reverseArgs(Function<T, Function<U, V>> f) {
    return t -> u -> f.apply(u).apply(t);
  }

  public static <T,U,V> Function<T,Function<U,V>> reverserArgA (Function<U, Function<T, V>> f){
    return u -> t -> f.apply(t).apply(u);
  }
}
