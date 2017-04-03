package ua.com.vtkachenko.ciklum.kyiv.algorythms.club48topcoderpractice.task3;

/*
problem

The score of a string is its length multiplied by the number of different characters in the string. For example, the score of “abbcdxc” is 7 * 5 = 35. This is because the length of this string is 7 and there are five different characters: a, b, c, d, x.

Bear Limak wants to find a sequence of strings satisfying the following conditions:

There number of strings is between 1 and 50, inclusive. The length of each string is between 1 and 50, inclusive. The sum of scores of the strings is exactly K.
Each character in each string is a lowercase English letter (‘a’ - ‘z’). You are given the K. Compute and return any sequence of strings with the above properties.
If there are multiple solutions, you may return any one of them.

NOT SOLVED

 */
public class Solution {

    public String[] findAny(int K){

        int index = 0;
        int number = K / 50 + ((K%1300 > 50) ? 2 : 1);
        String[] result = new String[number];
        while (K > 0){
            if (K >= 1300){
                result[index++] = genAlph(26, 50);
                K -= 1300;
            } else if (K > 50){
                int unicNumber = K/50;
                result[index++] = genAlph(unicNumber, 50);
                K -= unicNumber*50;
            } else {
                result[index++] = genAlph(1, K);
                K -= K;
            }
        }
        return result;
    }

    public String genAlph(int unic, int length){
        StringBuilder sb = new StringBuilder();
        for (char i = 'a'; i < unic + 'a';) {
            sb.append(i++);
        }
        for (int i = unic; i < length; i++) {
            sb.append('a');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAny(5));
    }

}
