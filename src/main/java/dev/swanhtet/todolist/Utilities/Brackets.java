package dev.swanhtet.todolist.Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Brackets {

  public static boolean TrueFALSECHENC(String s) {
    Map<Character, Character> HashMapping = new HashMap<>();
    HashMapping.put(')', '(');
    HashMapping.put(']', '[');
    HashMapping.put('}', '{');

    Stack<Character> stackForBracket = new Stack<>();

    for (char c : s.toCharArray()) {
      if (HashMapping.containsValue(c)) {
        stackForBracket.push(c);
      } else if (HashMapping.containsKey(c)) {
        if (stackForBracket.isEmpty() || HashMapping.get(c) != stackForBracket.pop()) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {

    String test1 = "{[()]}";
    String test2 = "{[(])}";

    System.out.println("Test 1: " + TrueFALSECHENC(test1)); // Output: true
    System.out.println("Test 2: " + TrueFALSECHENC(test2)); // Output: false
  }
}

class QueueUsingTwoStacks<T> {
  private Stack<T> stackOne;
  private Stack<T> stackTwo;

  public T Enqueue(T value) {
    return stackOne.push(value);
  }

  public void Dequeue() {}
}
