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

class LinkedList {
    // Function to print nodes in a given circular linked list
    static void printList(Node head) {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int key = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            tail.next = head; // Make the list circular
            Solution ob = new Solution();
            Node current = ob.deleteNode(head, key);
            Node rev = ob.reverse(current);
            printList(rev);
        }
    }
}

// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class Solution {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        if (head == null || head.next == head) {
            return head;  // Empty list or single-node list
        }

        Node prev = null;
        Node current = head;
        Node next = null;
        Node tail = head;

        // Traverse the list to reverse the links
        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);

        // Fix the circular part
        head.next = prev;
        head = prev;
        
        return head;
    }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        if (head == null) {
            return null;  // Empty list
        }

        Node current = head;
        Node prev = null;

        // Special case if the node to be deleted is the head
        if (head.data == key) {
            // Find the last node to maintain the circular property
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            
            if (head == head.next) {  // Only one node in the list
                return null;  // Deleting the only node
            }
            
            tail.next = head.next;  // Remove the head node
            head = head.next;  // Update head
            return head;
        }

        // Traverse the list to find the node with the key
        do {
            prev = current;
            current = current.next;
            if (current.data == key) {
                prev.next = current.next;  // Bypass the current node
                return head;
            }
        } while (current != head);

        // If no node is found, return the list as is
        return head;
    }
}