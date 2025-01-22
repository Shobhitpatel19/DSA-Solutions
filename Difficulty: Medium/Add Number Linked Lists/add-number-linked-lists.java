//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // Remove leading zeros from both lists
        num1 = removeLeadingZeros(num1);
        num2 = removeLeadingZeros(num2);
        
        // Reverse both lists to make addition easier
        num1 = reverseList(num1);
        num2 = reverseList(num2);
        
        // Add the numbers
        Node result = addLists(num1, num2);
        
        // Reverse back the result
        result = reverseList(result);
        
        return result;
    }
    
    // Helper function to remove leading zeros
    private static Node removeLeadingZeros(Node head) {
        // Skip all leading zeros
        while (head != null && head.data == 0 && head.next != null) {
            head = head.next;
        }
        return head;
    }
    
    // Helper function to reverse a linked list
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    // Helper function to add two reversed lists
    private static Node addLists(Node num1, Node num2) {
        Node dummyHead = new Node(0);
        Node current = dummyHead;
        int carry = 0;
        
        // Add digits while either list has digits or there's a carry
        while (num1 != null || num2 != null || carry > 0) {
            // Get digits from both lists, use 0 if list ends
            int x = (num1 != null) ? num1.data : 0;
            int y = (num2 != null) ? num2.data : 0;
            
            // Calculate sum and new carry
            int sum = x + y + carry;
            carry = sum / 10;
            
            // Create new node with ones digit
            current.next = new Node(sum % 10);
            current = current.next;
            
            // Move to next digits in both lists
            if (num1 != null) num1 = num1.next;
            if (num2 != null) num2 = num2.next;
        }
        
        return dummyHead.next;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends