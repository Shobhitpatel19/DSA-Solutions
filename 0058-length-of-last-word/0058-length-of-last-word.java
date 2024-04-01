class Solution {
    public int lengthOfLastWord(String s) {
        /*
          \\s: This represents any whitespace character.
          +: This quantifier matches one or more occurrences of the preceding element, which in this case is whitespace characters.
          $: This asserts the position at the end of the input.
        */
        // Trim trailing spaces
        s = s.replaceAll("\\s+$", "");

        // Find the last space character
        int lastSpace = s.lastIndexOf(' ');

        // Calculate the length of the last word
        return lastSpace == -1 ? s.length() : s.length() - lastSpace - 1;
    }
}