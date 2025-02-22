package com.fpinjava.advancedlisthandling.exercise08_03;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListTest {

  @Test
  public void testLastOptionEmpty() {
    assertEquals("Empty()", List.list().lastOption().toString());
  }

  @Test
  public void testLastOptionNonEmpty() {
    assertEquals("Success(3)", List.list(1, 2, 3).lastOption().toString());
  }

}
