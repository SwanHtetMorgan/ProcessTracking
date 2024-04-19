package dev.swanhtet.todolist.Utilities;

public class UtilitiesLibrary {
  static Node head;

  static class Node {
    int value;
    Node next;

    public Node(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public static void InsertionAtTheBeginning(int value) {
    Node new_node = new Node(value);
    new_node.next = head;
    head = new_node;
  }

  public static void InsertionAtTheEnd(int value) {
    Node new_node = new Node(value);
    if (head == null) {
      head = new Node(value);
    }

    new_node.next = null;

    Node proxy_last = head;
    while (proxy_last.next != null) {
      proxy_last = proxy_last.next;
    }
    proxy_last.next = new_node;
    proxy_last = new_node;
    return;
  }

  public static void printNode() {
    Node proxyNode = head;
    while (proxyNode.next != null) {
      System.out.println(head.value);
      proxyNode = proxyNode.next;
    }
  }

  public static void main(String[] args) {
    UtilitiesLibrary utilitiesLibrary = new UtilitiesLibrary();

    utilitiesLibrary.InsertionAtTheBeginning(4);
    utilitiesLibrary.InsertionAtTheEnd(5);
    printNode();
  }
}
