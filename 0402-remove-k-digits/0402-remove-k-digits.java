class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        int n = num.length();

        // We use a stack to keep track of the digits we want to keep.
        Stack<Character> stack = new Stack<>();

        // Iterate over the digits of the number.
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);

            // While we have digits to remove and the stack is not empty and the digit at the top of the stack is greater than the current digit, we pop the top of the stack.
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }

            // We push the current digit onto the stack.
            stack.push(c);
        }

        // While we still have digits to remove and the stack is not empty, we pop the top of the stack.
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // We append the digits from the stack to the StringBuilder.
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        // We reverse the StringBuilder to get the smallest possible number.
        sb.reverse();

        // We remove any leading zeros from the StringBuilder.
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // If the StringBuilder is empty, we return "0".
        if (sb.isEmpty()) {
            return "0";
        }

        // We return the StringBuilder as a string.
        return sb.toString();
    }
}