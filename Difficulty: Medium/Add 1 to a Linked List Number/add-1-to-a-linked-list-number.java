//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    /* Function to create a new node with given data */
    public Node newNode(int data)
    {
        Node new_node = new Node(data);
        // new_node.data = data;
        // new_node.next = null;
        return new_node;
    }
 
    /* Function to reverse the linked list */
    public Node reverse(Node head)
    {
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
    public Node addOneUtil(Node head)
    {
        // res is head node of the resultant list
        Node res = head;
        Node temp = null, prev = null;
 
        int carry = 1, sum;
 
        while (head != null) // while both lists exist
        {
            // Calculate value of next digit in resultant
            // list. The next digit is sum of following
            // things (i) Carry (ii) Next digit of head list
            // (if there is a next digit)
            sum = carry + head.data;
 
            // update carry for next calculation
            carry = (sum >= 10) ? 1 : 0;
 
            // update sum if it is greater than 10
            sum = sum % 10;
 
            // Create a new node with sum as data
            head.data = sum;
 
            // Move head and second pointers to next nodes
            temp = head;
            head = head.next;
        }
 
        // if some carry is still there, add a new node to
        // result list.
        if (carry > 0)
            temp.next = newNode(carry);
 
        // return head of the resultant list
        return res;
    }
    public Node addOne(Node head) {
        // code here.
        // Reverse linked list
        head = reverse(head);
 
        // Add one from left to right of reversed
        // list
        head = addOneUtil(head);
 
        // Reverse the modified list
        return reverse(head);
    }
}
