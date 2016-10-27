package ua.com.vtkachenko.ciklum.kyiv.algorythms.club40.task3;

/*
Задано рядок, який складається з малих латинських літер. Потрібно
розбити його на мінімальну можливу кількість паліндромів.
Вхідні дані: заданий рядок знаходиться в файлі palindrome2.dat,
довжина не перевищує 2000 символів
150
Вихідні дані: в перший рядок треба вивести
мінімальну кількість паліндромів, на які можна розбити рядок
Приклад вхідних і вихідних даних:
INPUT
abbacbb
OUTPUT
3
Пояснення: abbacbb=abba+c+bb
 */
public class Solution {

    public int findPalindroms(String a){

        char[] s = a.toCharArray();
        int n = s.length;
        boolean[][] isPal = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPal[i][i] = true;
        }
        for (int i = 0; i < n-1; i++) {
            isPal[i][i+1] = s[i] == s[i+1];
        }
        for (int w = 2; w < n; w++) {
            for (int i = 0; i + w < n; i++) {
                isPal[i][i+w] = s[i] == s[i+w]&&isPal[i+1][i+w-1];
            }
        }
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (isPal[0][i]) res[i] = 1;
            else {
                res[i] = i+1;
                for (int j = 0; j <= i; j++) {
                    if (isPal[j][i]){
                        res[i] = Math.min(res[i], 1 + res[j - 1]);
                    }
                }
            }
        }
        return res[n-1];
    }
}
