package ua.com.vtkachenko.ciklum.kyiv.algorythms.belkacontest.task1;

import java.util.Scanner;

/*
Злічити Одиниці

Дано два цілі числа S і E де -2147483648 <= S <= 2147483647, S <= E <= 2147483647. Вам необхідно порахувати суму всіх одиниць(включаючи знаковий біт), в бінарному представленні, всіх чисел від S до E включно.
Різниця S і E не більше 2000000.

Вхідні дані: Два цілих числа S, E записані через пробіл.
Вихідні дані: Єдине число - сума одиниць.
Приклад

Input
3 5

Output
5

Пояснення: 3(11), 4(100), 5(101). 1+1 + 1+0+0 + 1+0+1 = 5.

 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int S = in.nextInt();
        int E = in.nextInt();

//            int S = 3;
//            int E = 5;


        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(S));
        int K = S + 1;
        if (E > S) {

            while (K < E) {
                sb.append(Integer.toBinaryString(K));
                K++;
            }
        }
        if (E != S) {

            sb.append(Integer.toBinaryString(E));
        }
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
//            if (Integer.parseInt(String.valueOf(sb.charAt(i))) == 1){
            count += Integer.parseInt(String.valueOf(sb.charAt(i)));
//            }
        }
        System.out.println(count);

    }
}
