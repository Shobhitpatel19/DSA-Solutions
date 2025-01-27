//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache {
    // Node class for doubly linked list
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    // Class members
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head;  // Most recently used
    private Node tail;  // Least recently used
    
    // Constructor for initializing the cache capacity
    LRUCache(int cap) {
        this.capacity = cap;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);  // Dummy head
        this.tail = new Node(0, 0);  // Dummy tail
        head.next = tail;
        tail.prev = head;
    }
    
    // Remove a node from the doubly linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // Add node right after head (most recently used position)
    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    // Move node to front (after accessing)
    private void moveToFront(Node node) {
        removeNode(node);
        addNode(node);
    }
    
    // Function to return value corresponding to the key
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToFront(node);  // Move to front as it was just accessed
            return node.value;
        }
        return -1;
    }
    
    // Function for storing key-value pair
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Key exists, update value and move to front
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            // New key
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            
            // Check capacity
            if (cache.size() > capacity) {
                // Remove least recently used item (before tail)
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
        }
    }
}
