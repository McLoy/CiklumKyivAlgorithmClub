package ua.com.vtkachenko.ciklum.kyiv.algorythms.club42.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Задано рядок що складається лише з малих літер латинського алфавіту.
Необхідно порахувати мінімальну кількість літер, які треба замінити,
щоб отримати рядок в якому всі літери однакові.
Приклад

INPUT
bacaabacab

OUTPUT
5

Пояснення: необхідно виконати 5 замін b -> a, c -> a, b -> a, c -> a, b -> a для утворення рядка доскладається лише з літер 'a'.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in .next();
//        String input = "bacaabacab";
        char[] chars = input.toCharArray();
        Map<Character, Integer> dic = new HashMap<>();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            Integer count = dic.get(chars[i]);

            if (count == null){
                count = 0;
            }
            count++;
            dic.put(chars[i], count);

            if (count > max){
                max = count;
            }
        }

        System.out.println(chars.length - max);

    }
}
