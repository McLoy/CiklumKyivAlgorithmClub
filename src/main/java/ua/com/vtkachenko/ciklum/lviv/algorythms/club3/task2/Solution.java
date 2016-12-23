package ua.com.vtkachenko.ciklum.lviv.algorythms.club3.task2;

import java.util.Scanner;
/* //Union Find
not solved
У фермера Львівського, бізнес пішов вгору, і тепер йому треба багато подорожувати літаком і вкладати угоди з міжнародними партнерами по всьому світу.
Нажаль не завжди є прямі рейси між M містами [1..M] і приходиться робити багато пересадок, але нашого фермера це не лякає.
З нового року йому прийдеться здійснити P подорожей, по одній в день. І в той же час авіакомпанії планують відміняти один рейс кожного дня.
Допоможіть фермеру Львівькому запланувати зустрічі. Необхідно дати відповідь чи зможе він потрапити в i-й день [1..P] з міста X в місто Y.
До скасувань, було M-1 рейсів між містами, так що всі міста мають сполученя один з одним. Кожен рейс працює в дві сторони, з міста X в Y і навпаки.

Формат вхідних даних

В першому рядку записане єдине число M, кількість міст.
Далі йде M-1 рядків. В кожному, пара чисел X і Y, що означає регулярний рейс з міста X в місто Y. Кожний рейс має номер від 1 до M-1.
Рейси виводяться в порядку збільшення номера. X,Y належать [1..M] В наступному рядку йде число P, кількість запланованих польотів.
Потім P трійок чисел, X Y V. Запланований політ з міста X в Y. V - номер відміненого рейсу в той день. V належить [1..M-1]

Формат вихідних даних

P рядків, в кожному вивести YES якщо політ можливо здійснити в день i та NO в іншому виподку.

Обмеження

2 <= M <= 1000, 1 <= P <= 30

Приклад

INPUT

5
1 2
2 3
2 4
1 5
4
1 4 3
1 4 2
3 5 3
2 1 1

OUTPUT

NO
YES
YES
NO
 */
public class Solution {
//    public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//
//    int M = in .nextInt();
//    int[] from = new int[M;
//        int[] to = new int[M];
//
//
//        for (int i = 0; i <= M-1 ; i++) {
//            from[i] = in.nextInt();
//            to[i] = in.nextInt();
//
//        }
//
//        int P = in.nextInt();
//
//        for (int j = 0; j <= P; j++) {
//            int X = in.nextInt();
//            int Y = in.nextInt();
//            int V = in.nextInt();
//
//            UF uf = new UF(M+2);
//
//            for (int k = 0; k <= M-1 ; k++) {
//                if (k != V){
//                    uf.union(from[k], to[k]);
//                }
//            }
//            System.out.println(uf.connected(X,Y)?"YES":"NO");
//
//        }
//
//    }
//
//    public static class UF{
//        int[] tree;
//        int[] size;
//
//        public UF(int capacity){
//            this.tree = new int[capacity];
//            this.size = new int[capacity];
//
//            for (int i = 0; i < tree.length; i++) {
//                tree[i] = i;
//                size[i] = 1;
//            }
//        }
//
//        int root(int i){
//            while (tree[i] != i){
//                i = tree[i];
//            }
//            return i;
//        }
//
//        public boolean connected(int i, int j){
//            return root(i) == root(j);
//        }
//
//        public void union(int i, int j){
//            i = root(i);
//            j = root(j);
//
////            if (tree[i] == 0) {
////                tree[i] = i;
////                size[i] = 1;
////            }
////            if (tree[j] == 0) {
////                tree[j] = i;
////                size[j] = 1;
////            }
//
//            if (size[i] < size[j]){
//                tree[i] = j;
//                size[j] += size[i];
//            } else {
//                tree[j] = i;
//                size[i] += size[j];
//            }
//        }
//    }


}
