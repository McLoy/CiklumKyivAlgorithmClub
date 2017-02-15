package ua.com.vtkachenko.ciklum.kyiv.algorythms.belkacontest.task3;

import java.util.Scanner;
/*
Паліндром

Дано рядок S довжиною N (1<=N<=1000). Над ним можна виконувати 3 операції:

  1. Замінити один символ рядка на будь-який інший.
  2. Вставити в будь-яке місце в рядку будь-який символ.
  3. Видалити будь-який символ з рядка.

Вам потрібно за найменшу кількість операцій перетворити даний рядок на паліндром (рядок, який читається однаково зліва направо і справа наліво).

Вхідні дані: В першому рядку міститься ціле число N, довжина вхідного рядка. В другому рядок S довжиною N, який складається тільки з маленьких латинських літер.

Вихідні дані: Вивести найменшу кількість операцій за яку даний рядок можна перетворити на паліндром.
Приклад

Input
4
abbc

Output
1

Пояснення: В рядку "abbc" достатньо замінити одну літеру 'c' на 'a', щоб отримати паліндром.

 */
public class Solution {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        String S = in.next();

        int N = 10;
//        String S = "abbc";
//        String S = "babad";
        String S = "ababcaacba";
        StringBuilder sb = new StringBuilder(S);

        int count = 0;
        int ost = S.length()%2;
        for (int i = 0; i < S.length()/2; i++) {
            if (sb.charAt(S.length()/2-ost-i) != sb.charAt(S.length()/2+ost+i)) {
                //необходимо делать операцию
                count++;
            }
        }

        System.out.println(count);
    }
}
