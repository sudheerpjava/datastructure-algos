package linkedlist;

import java.util.HashSet;
import java.util.Stack;

public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node four = new Node(2);
        Node five = new Node(1);
        linkedList.head.next = second;
        second.next = third;
        third.next = four;
        four.next = five;
        //five.next = linkedList.head;


        //    printList(deleteNode(linkedList.head,4));
        //removeDuplicates(linkedList.head);
        System.out.println(isPalindrome(linkedList.head));
        //   System.out.println(printMiddle(linkedList.head));
        //System.out.println(detectLoop(linkedList.head));

        printReverse(linkedList.head);
    }

    public static  void printReverse(Node head){

        if (head == null){
            return;
        }
        printReverse(head.next);

        System.out.println(head.data);
    }

    public static Node moveToFront(Node head) {

        if (head == null && head.next == null)
            return head;
        Node secLast = null;
        Node last = head;

        while (last.next != null) {
            secLast = last;
            last = last.next;
        }

        secLast.next = null;
        last.next = head;
        head = last;
        return head;
    }

    public static boolean isPalindrome(Node head){

        Node slow = head;
        boolean isPalindrome = false;
        Stack<Integer> stack = new Stack<>();

        while (slow!=null){
            stack.push(slow.data);
            slow = slow.next;
        }
        while (head!=null){

            int data = stack.pop();
            if(data == head.data){
                isPalindrome = true;
            }else{
                isPalindrome = false;
                break;
            }
            head = head.next;
        }
        return isPalindrome;
    }

    public static void removeDuplicates(Node head) {
        Node curr = head;
        Node prev = null;
        HashSet hashSet = new HashSet<Node>();
        while (curr != null) {
            if (hashSet.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                hashSet.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    public static boolean detectLoop(Node head) {
        HashSet<Node> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) {
                return true;
            }
            nodes.add(head);
            head = head.next;
        }
        return false;
    }

    public static int printMiddle(Node head) {
        Node fastPointer = head;
        Node slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer.data;
    }

    public static void insertNode(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        head = current;
    }

    public static Node deleteNode(Node head, int key) {
        Node temp = head;
        Node prev = null;
        if (temp != null && temp.data == key) {
            head = temp.next;
            return head;
        }
        System.out.println("test");
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            return temp;
        }
        prev.next = temp.next;
        return head;
    }

    public static void printList(Node head) {

        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
