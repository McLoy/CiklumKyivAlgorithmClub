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

 */
public class Solution { //Tests not started
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int max = Integer.MIN_VALUE;
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            digits.add(in.nextInt());
        }

        List<Integer> pid = new ArrayList<>();
        while (digits.size() != 1){
            for (int j = 0; j < digits.size(); j++) {
                    int summ = 0;
                    summ = digits.get(j);

                if (summ > max) {
                    max = summ;
                }
                summ = 0;

                    pid = digits.subList(0, j+1);

                    for (int k = 0; k < pid.size(); k++) {
                        summ = summ + pid.get(k);
                    }
                    if (summ > max) {
                        max = summ;
                    }
            }
            digits.remove(0);

        }


        System.out.println(max);
    }
}