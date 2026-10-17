import java.io.*;
import java.util.*;

public class Solution {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (head == null) {
            return newNode;
        }

        SinglyLinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        SinglyLinkedListNode head = null;

        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            head = insertNodeAtTail(head, val);
        }

        // Print the final list
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

        scanner.close();
    }
}
