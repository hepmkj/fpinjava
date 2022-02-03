package com.fpinjava.makingjavafunctional.exercise03_01;


import com.fpinjava.common.Function;

import java.util.regex.Pattern;

public class EmailValidation {

  static Pattern emailPattern =
      Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

  static Function<String, Result<String>> emailChecker = s ->
    s == null ? Result.failure("email shouldn't be null")
            : s.length() == 0
            ? Result.failure("email shouldn't be empty")
            : emailPattern.matcher(s).matches()
            ? Result.success(s)
            : Result.failure("email is not in correct form");


  public static void main(String... args) {
    emailChecker.apply("this.is@my.email").bind(success, failure);
    emailChecker.apply(null).bind(success, failure);
    emailChecker.apply("").bind(success, failure);
    emailChecker.apply("john.doe@acme.com").bind(success, failure);
  }

  static Effect<String> success = s -> sendVerificationMail(s) ; // To be implemented
  
  static Effect<String> failure = s -> logError(s); // To be implemented

  private static void sendVerificationMail(String s) {
    System.out.println("Sending verification email to: " +  s);
  }

  private static void logError(String s){
    System.err.println("Error message logged: " + s);
  }
}