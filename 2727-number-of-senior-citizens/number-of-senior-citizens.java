class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String str: details){
            String strAge = str.substring(11, 13);
            int age = Integer.parseInt(strAge);

            // System.out.print(age + "  ");
            if(age > 60) count++;
        }
        return count;
    }
}