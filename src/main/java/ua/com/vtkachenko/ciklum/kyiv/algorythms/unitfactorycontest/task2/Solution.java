package ua.com.vtkachenko.ciklum.kyiv.algorythms.unitfactorycontest.task2;

import java.util.*;
/*
Пари

Дано N цілих чисел. Порахувати всі пари чисел сума яких дорівнює S. Всі числа унікальні.
Спробуйте знайти рішення зі складністю по часу O(N*log(N)).
Вхідні дані

В першому рядку записані N і S.
В наступному, через пробіл, N чисел.
Вихідні дані

Єдине число - кількість пар, сума яких дорівнює S.
Приклад

Input
5 6
2 5 1 3 4

Output
2
Пояснення : Є лише 2 пари числел (5, 1) і (2, 4) сума яких дає 6.

 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long s = in.nextLong();

        int fin = 0;
        long[] digits = new long[n];
        for (int i = 0; i < n; i++) {
            digits[i] = in.nextLong();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (digits[i] + digits[j] == s)
                    fin++;
            }
        }

        System.out.println(fin);
    }
}