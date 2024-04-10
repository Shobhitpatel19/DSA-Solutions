class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Queue<Integer> index = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            index.add(i);
        }

        Arrays.sort(deck);
        int[] rst = new int[n];
        for (int card : deck) {
            // assign one value to the rst each time
            rst[index.poll()] = card;
            // do the simulation (remove the next value to the queue's end)
            if (!index.isEmpty()) {
                index.add(index.poll());
            }
        }
        return rst;
    }
}