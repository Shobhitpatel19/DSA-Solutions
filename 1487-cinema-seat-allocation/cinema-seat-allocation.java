class Solution {
	public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		int count = 0;
		Map<Integer, List<Integer>> rowReserved = new HashMap<>();
		for (int [] row: reservedSeats) {
			if (rowReserved.containsKey(row[0]))
				rowReserved.get(row[0]).add(row[1]);
			else
				rowReserved.put(row[0], new ArrayList<>(Arrays.asList(row[1])));
		}
		count = (n - rowReserved.size()) * 2; //  here no reservation
		for (List<Integer> list: rowReserved.values()) {
			boolean filled = false;
			if (!list.contains(2) && !list.contains(3) && !list.contains(4) && !list.contains(5)) {
				filled = true;
				count += 1;
			}
			if (!list.contains(6) && !list.contains(7) && !list.contains(8) && !list.contains(9)) {
				filled = true;
				count += 1;
			}
			if (!filled) {
				if (!list.contains(4) && !list.contains(5) && !list.contains(6) && !list.contains(7)) {
					count += 1;
				}
			}
		}
		return count;
    }
}