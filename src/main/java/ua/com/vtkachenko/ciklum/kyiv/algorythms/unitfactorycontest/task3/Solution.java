package ua.com.vtkachenko.ciklum.kyiv.algorythms.unitfactorycontest.task3;

import java.util.*;

/*
Найбільша Сума

Дано масив з N чисел. Необхідно знайти максимальну суму підмасива. Підмасив - набір чисел, що йдуть підряд у вхідному масиві, мінімальна кількість яких 1, максимальна N.
Вхідні дані

В першому рядку єдине число N.
В другому через пробіл записані N чисел.
Вихідні дані

Єдине число - максимальна сума підмасиву.
Приклад

Input
9
-1 2 -3 2 -1 3 1 -5 3

Output
5
Пояснення : З усіх можливих підмасивів, максимальну суму дає [2, -1, 3, 1], відповідь 5.

=================
5
-2 -4 -3 -1 -2
*/
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int max = Integer.MIN_VALUE;
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = in.nextInt();
        }
    System.out.println(maxSubArray(digits));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
