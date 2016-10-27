package ua.com.vtkachenko.ciklum.kyiv.algorythms.club40.task2;

/*
Для економії пам'яті в новому комп'ютері числа замінюються на
близькі за значенням числа-поліндроми, і як результат запам'ятовується лише
перша половина отриманого поліндрома. Вам потрібно написати програму
для описаного комп'ютера, яка швидко по заданому числу знаходить
найменший поліндром, який більший або рівний цьому числу.
Вхідні дані. в першому рядку файлу number.dat записане єдине
натуральне число, кількість цифр якого не перевищує 1000.
Вихідні дані. в перший рядок виведіть шуканий
поліндром.
Приклад вхідних і вихідних даних:
INPUT
1711
OUTPUT
1771
 */
public class Solution {

    public int findPalindrom(Integer a) {
        String word = a.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length() / 2; i++) {
            sb.append(word.charAt(i));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(sb);
        sb2.reverse();
        sb.append(sb2);

        return Integer.parseInt(sb.toString());
    }

    public String findPal(String s) {
        char[] digits = s.toCharArray();
        int n = digits.length;

        for (int i = 0; i < n/2; i++) {
            digits[n-i-1] = digits[i];
        }
        String newN = new String(digits);
        if (newN.compareTo(s) < 0){
            for (int i = n/2; i >= 0 ; i--) {
                if (digits[i] < '9'){
                    digits[i]++;
                    if (i != n-i-1){
                        digits[n-i-1]++;
                    }
                    break;
                }
            }
        }
        return new String(digits);
    }
}
