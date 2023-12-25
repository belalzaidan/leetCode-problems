import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static int mostWordsFound(String[] sentences) { // no. 2114
        int max_words = 1;
        for (int i = 0; i < sentences.length; i++){
            String[] splited = sentences[i].split(" ");
            if (splited.length > max_words){
                max_words = splited.length;
            }
        }

        return max_words;
    }

    public static int arrangeCoins(int n) { // no. 441
        int i = 0;
        while (n >= i) {
            n = n - i;
            i++;
        }

        return i - 1;

        /* Alternative answer, less effictive
        ArrayList<Integer> buffer = new ArrayList<>();
        int i = 1;

        while (n >= i) {
            buffer.add(i);
            n = n - i;
            i++;
        }

        return buffer.size();
         */
    }
    public static int[] shuffle(int[] nums, int n) { // no. 1470
        int[] newArray = new int[nums.length];
        int index = 0;
        while (index < nums.length){
            for (int i = 0; i < n; i++){
                newArray[index] = nums[i];
                index+=2;
            }
            index = 1;
            for (int i = n; i < nums.length; i++){
                newArray[index] = nums[i];
                index+= 2;
            }
        }
        return newArray;
    }

    public static int fibonacci(int n) { // no. 509
        int[] fibo = new int [31];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i < n+1; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        return fibo[n];
    }

    public static String tribonacci(int n) { // no. 1137
        int[] tribo = new int[n+1];
        if (n >= 2){
            tribo[0] = 0;
            tribo[1] = tribo[2] = 1;
            for (int i = 0; i < n - 2; i++) {
                tribo[i+3] = tribo[i] + tribo[i+1] + tribo[i+2];
            }
        }
        return Arrays.toString(tribo);

    }

    public static int[] getConcatenation(int[] nums) { // no. 1929
        int[] ans = new int[nums.length*2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = ans[i+nums.length] = nums[i];
        }
        return ans;
    }

    public static boolean checkRecord(String s) { // no. 551
        char[] record = s.toCharArray();
        int absense = 0;
        for (int i = 0; i < record.length; i++){
            if (record[i] == 'A') {
                absense += 1;
            }
            if (absense > 2 || (i + 2 < record.length && (record[i] == 'L'
                    && record[i + 1] == 'L' && record[i + 2] == 'L'))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isHappy(int n) {      // no. 202 - Still not solved
        String numStr = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += Math.pow(digit, 2);
        }
        if (sum == 1){
            return true;
        } else {
            return isHappy(sum);
        }
    }

    public static boolean isIsomorphic(String s, String t) { // no. 205
        HashMap<Character, Character> s_to_t = new HashMap<>();
        HashMap<Character, Character> t_to_s = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (s_to_t.containsKey(sChar)){
                if (!(s_to_t.get(sChar) == tChar)) {return false;}
            }
            else s_to_t.put(sChar, tChar);

            if (t_to_s.containsKey(tChar)){
                if (!(t_to_s.get(tChar) == sChar)) {return false;}
            }
            else t_to_s.put(tChar, sChar);
        }

        return true;


        //alternative answer, less efficent
//        String [] listOfStrings = new String[s.length()];
//
//        for (int i = 0; i < s.length(); i++){
//            String str = "";
//            str += String.valueOf(s.charAt(i))
//                    + String.valueOf(t.charAt(i));
//            listOfStrings[i] = str;
//        }
//        for (String listOfString : listOfStrings) {
//            for (int j = 1; j < listOfStrings.length; j++) {
//                boolean firstLettersMatch = listOfString.charAt(0) == listOfStrings[j].charAt(0);
//                boolean secondLettersMatch = listOfString.charAt(1) == listOfStrings[j].charAt(1);
//                if (firstLettersMatch){
//                    if (!secondLettersMatch) return false;
//                }
//                else if (secondLettersMatch){
//                    if (!(firstLettersMatch)) return false;
//
//                }
//            }
//        }
//        return true;
    }


    public static int chalkReplacer(int[] chalk, long k) { // no. 1894
        long totalChalks = 0;
        for (int j : chalk) {
            totalChalks += j;
        }
        k %=  totalChalks; // all steps so far are to skip the repeating, what we
        // care about is the last part that's not enough chalks for everyone and
        // are trying to find the one who is replacing.

        int i = 0;
        while(k >= chalk[i]){
            k -= chalk[i];
            i++;
            if(i == chalk.length) i = 0;
        }
        return i;

//        // Another way where the code reloop if we still have enough chalks
//        // Less efficent
//        int i = 0;
//        while (true){
//            if(k < chalk[i]) return i;
//            else{
//                while(k >= chalk[i]){
//                    k -= chalk[i];
//                    i++;
//                    if(i == chalk.length) {
//                        i = 0;
//                    }
//                }
//            }
//        }
    }
}
