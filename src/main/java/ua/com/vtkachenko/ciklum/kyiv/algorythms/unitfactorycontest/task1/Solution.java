package ua.com.vtkachenko.ciklum.kyiv.algorythms.unitfactorycontest.task1;

import java.util.*;
/*
Цифри

Порахувати суму цифр числа X.
Вхідні дані

В першому рядку чисто T, кількість тестів.
В наступних T рядках записане число Xi для якого треба порахувати суму цифр.
Вихідні дані

T рядків. В і-му записана сума цифр Xі-го числа.
0 <= Xi <= 2147483647
Приклад

Input
2
123
9042

Output
6
15
Пояснення : В першому тесті сума цифр 1+2+3=6, в другому 9+0+4+2 = 15.

 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(in.next());
            int count = 0;
            for (int j = 0; j < sb.length(); j++) {
                count = count + Integer.parseInt(String.valueOf(sb.charAt(j)));
            }
            System.out.println(count);
        }

    }
}