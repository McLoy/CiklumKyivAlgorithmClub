package ua.com.vtkachenko.ciklum.lviv.algorythms.club3.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
Фермер Львівський, бізнес якого заснований на кроликах, зіткнувся з проблемою пошуку кролика, який не має пари.
На його кролефермі кролики пронумеровані так, що кролики з однієї родини мають однакові номери, причому кількість
кроликів у кожній родині парна. Ніякої системи у нумерації немає, лише відомо, що номер є натуральним числом, а також відомо, що кролик-холостяк – єдиний.

INPUT
1 6 2 3 4 6 3 1 2 3 4 3 6
or
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1999997999 1
 */
public class Solution {

    public static void main(String[] args) { //my Solution
        Scanner in = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        Integer value;
        Integer count = 0;
        String [] s = in.nextLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            value = Integer.valueOf(s[i]);
            if(!map.isEmpty()){
                if(map.containsKey(value)){
                    count = map.get(value);
                }
            }
            if (count == 0){
                map.put(value,1);
            } else {
                count++;
                map.put(value, count);
            }
        }
        for (Integer i : map.keySet()){
            if (map.get(i)%2 == 1){
                System.out.println(i);
                return;
            }
        }
        in.close();
    }
//    public static void main(String[] args) throws IOException { //first Solution
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String[] line = reader.readLine().split(" ");
//
//        Map<String, Integer> map = new HashMap<>();
//
//        for (String s : line) {
//            if (map.containsKey(s)) {
//                map.put(s, map.get(s) + 1);
//            } else {
//                map.put(s, 1);
//            }
//        }
//
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if (entry.getValue() % 2 == 1) {
//                System.out.println(entry.getKey());
//                return;
//            }
//        }
//    }
}