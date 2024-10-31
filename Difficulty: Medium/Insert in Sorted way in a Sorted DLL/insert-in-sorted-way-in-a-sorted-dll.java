//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline character after t

        while (t-- > 0) {
            String input = sc.nextLine(); // Read the entire line for the array elements
            String[] values = input.split(" ");

            Node head = null, tail = null;
            for (String value : values) {
                int x = Integer.parseInt(value);
                if (head == null) {
                    head = new Node(x);
                    tail = head;
                } else {
                    tail.next = new Node(x);
                    tail.next.prev = tail;
                    tail = tail.next;
                }
            }

            int valueToInsert = sc.nextInt();
            if (sc.hasNextLine()) {
                sc.nextLine(); // Ignore the newline character after the value
            }

            Solution obj = new Solution();
            head = obj.sortedInsert(head, valueToInsert);
            printList(head);
        
System.out.println("~");
}

        sc.close();
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*class of the node of the DLL is as
/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/
class Solution {
    public Node sortedInsert(Node head, int x) {
        // add your code here
        if(head == null) return null;
        if(head.next == null){
            Node dummy = new Node(x);
            
            if(head.data > x){
                // x -> head
                dummy.next = head;
                head.prev = dummy;
                return dummy;
            }else{
                // head -> x
                head.next = dummy;
                dummy.prev = head;
                return head;
            }
        }
        if(x <= head.data){
            Node dummy = new Node(x);
            dummy.next = head;
            head.prev = dummy;
            return dummy;
        }
        
        Node temp = head;
        boolean inserted = false;
        Node previous = head;
        while(temp != null){
            if(temp.data < x){
                previous = temp;
                temp = temp.next;
            }else{
                Node prev = temp.prev;
                Node dummy = new Node(x);
                
                prev.next = dummy;
                dummy.prev = prev;
                
                dummy.next = temp;
                temp.prev = dummy;
                inserted = true;
                break;
            }
        }
        if(inserted == false){
            Node dummy = new Node(x);
            previous.next = dummy;
            dummy.prev = previous;
        }
        return head;
    }
}