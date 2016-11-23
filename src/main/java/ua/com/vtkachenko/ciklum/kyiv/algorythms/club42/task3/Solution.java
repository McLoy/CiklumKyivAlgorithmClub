package ua.com.vtkachenko.ciklum.kyiv.algorythms.club42.task3;

/*
Задано рядок, який складається з малих латинських літер. Дозволяється видаляти з рядка певні літери.
Скількома різними способами можна при цьому отримати паліндром?

Вхідні дані: заданий рядок, довжина його не перевищує 30 символів
Вихідні дані: в перший рядок треба вивести шукану кількість способів отримання паліндрому

Приклад вхідних і вихідних даних:
INPUT
aab

OUTPUT
4

Пояснення: паліндром можна отримати, видаливши символи: 1) 1 і 2; 2) 1 і 3; 3) 2 і 3; 4) 3
 */
public class Solution {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.next();
        String s = "aab";
        int length = s.length();
        int[][] a = new int[length][length+1];

        for (int i = 0; i < length; i++) {
            a[i][1] = 1;

        }

        for (int k = 2; k <= length; k++) {
            for (int i = 0; i <= length-k; i++) {
                a[i][k] = a[i][k-1] + 1;
                char c = s.charAt(i+k-1);
                for (int j = i; j < i+k-1; j++) {
                    if (s.charAt(j) == c){
                        a[i][k] += a[j+1][i+k-2-j] + 1;
                    }
                }
            }
        }

        System.out.println(a[0][length]);
    }



}
