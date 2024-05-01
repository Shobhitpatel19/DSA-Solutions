class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx == -1) // If the character is not found in the word
            return word;

        String first = word.substring(0, idx + 1);
        String second = word.substring(idx + 1);

        StringBuilder f = new StringBuilder(first);
        f.reverse();

        return f.append(second).toString();
    }
}
