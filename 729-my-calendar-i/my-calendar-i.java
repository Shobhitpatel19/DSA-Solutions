class MyCalendar {
    TreeMap<Integer, Integer> calcy;
    public MyCalendar() {
        calcy = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // Find the event that ends just before or overlaps with the new event
        Integer prevBook = calcy.floorKey(start);
        // Find the event that starts just after or overlaps with the new event
        Integer nextBook = calcy.ceilingKey(start);

        // Check if the new event overlaps with the previous event
        if (prevBook != null && calcy.get(prevBook) > start) {
            return false; // Overlaps with previous booking
        }

        // Check if the new event overlaps with the next event
        if (nextBook != null && nextBook < end) {
            return false; // Overlaps with next booking
        }

        // If no overlap, add the new event to the calendar
        calcy.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */