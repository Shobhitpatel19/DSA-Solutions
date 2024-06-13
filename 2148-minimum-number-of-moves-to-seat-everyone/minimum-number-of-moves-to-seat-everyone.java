class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int maxPosition = 100;
        int[] seatCount = new int[maxPosition + 1];
        int[] studentCount = new int[maxPosition + 1];
        
        for (int seat : seats) {
            seatCount[seat]++;
        }
        
        for (int student : students) {
            studentCount[student]++;
        }
        
        int seatIdx = 0;
        int studentIdx = 0;
        int moves = 0;
        
        while (seatIdx <= maxPosition && studentIdx <= maxPosition) {
            while (seatIdx <= maxPosition && seatCount[seatIdx] == 0) {
                seatIdx++;
            }
            while (studentIdx <= maxPosition && studentCount[studentIdx] == 0) {
                studentIdx++;
            }
            
            if (seatIdx <= maxPosition && studentIdx <= maxPosition) {
                int count = Math.min(seatCount[seatIdx], studentCount[studentIdx]);
                moves += count * Math.abs(seatIdx - studentIdx);
                seatCount[seatIdx] -= count;
                studentCount[studentIdx] -= count;
            }
        }
        
        return moves;
    }

}