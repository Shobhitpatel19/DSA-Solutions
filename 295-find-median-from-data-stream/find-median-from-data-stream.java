class MedianFinder {
    private PriorityQueue<Integer> leftMaxHeap; // max heap to store the smaller half
    private PriorityQueue<Integer> rightMinHeap; // min heap to store the larger half

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>((a, b) -> b - a); // max heap
        rightMinHeap = new PriorityQueue<>(); // min heap
    }
    
    public void addNum(int num) {
        // add num to the correct heap
        if (leftMaxHeap.isEmpty() || num <= leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        // balance the heaps
        if (leftMaxHeap.size() > rightMinHeap.size() + 1) {
            rightMinHeap.add(leftMaxHeap.remove());
        } else if (rightMinHeap.size() > leftMaxHeap.size()) {
            leftMaxHeap.add(rightMinHeap.remove());
        }
    }
    
    public double findMedian() {
        // calculate the median
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            return (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
        } else {
            return (double) leftMaxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */