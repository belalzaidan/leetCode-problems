import java.util.Arrays;

class Solution {


    public static int mostWordsFound(String[] sentences) {
        int max_words = 1;
        for (int i = 0; i < sentences.length; i++){
            String[] splited = sentences[i].split(" ");
            if (splited.length > max_words){
                max_words = splited.length;
            }
        }

        return max_words;
    }

    public static int arrangeCoins(int n) {
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
    public static int[] shuffle(int[] nums, int n) {
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

    public static int fibonacci(int n) {
        int[] fibo = new int [31];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i < n+1; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        return fibo[n];
    }

    public static String tribonacci(int n) {
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

    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length*2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = ans[i+nums.length] = nums[i];
        }
        return ans;
    }

    public static boolean checkRecord(String s) {
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

}

public class Main {
    public static void main(String[] args) {



//        ** Check Student Absense Record
//        System.out.println(Solution.checkRecord("AAAA"));

//        ** Get Concatenation (Duplicate array)
//        int [] a = {1,2,3,4};
//        System.out.println(Arrays.toString(Solution.getConcatenation(a)));

//        ** Fibonacci (get value) og Tribonacci (print array)
//        System.out.println(Solution.fibonacci(17));
//        System.out.println(Solution.tribonacci(17));

//        ** Shuffle array
//        int[] array = {2,5,1,3,4,7};
//        System.out.println(Arrays.toString(Solution.shuffle(array, 3)));

//        **  Arrange coins
//        System.out.println(Solution.arrangeCoins(44));

//        ** String star = "*";
//        for (int i = 0; i < 11; i++){
//            System.out.println(star);
//            star += star;
//        }
    }
}