package ua.com.vtkachenko.ciklum.kyiv.algorythms.club43.task1;

import java.util.Scanner;

/*
Есть фигура и точка...нужно узнать входит ли точка в фигуру
Используется площа фигуры для определения
Опуклый многоугольник
sqrt(p(p-a)(p-b)(p-c)), p = (a+b+c)/2

Можно проверить если пустить луч, если количество пересечений парное то точка в середине фигуры, если количество непарное - то точка вне фигуры.
Restricted area

Restricted area is enclosed into polygon. Its vertices have coordinates (x1, y1), ..., (xn, yn). Check if object with coordinates (x0,y0) is inside or outside this area. Objects on the area border are considered as inside
Input Format

First line contains the number of vertices in restricted area n . Next n lines contain pair of integer numbers xi, yi, that represent coordinates of area vertices The last line contains two integers x0, y0 - coordinates of object
Output Format

On a single line print "Inside" if object is inside restricted area, "Outside" in other case
Sample Input

4
-1 -2
-4 3
0 3
4 2
1 1
Sample Output

Inside

 */
public class Solution {

    static boolean intersect(int x0, int y0, int x1, int y1, int x2, int y2){

        /*
        We will see corner cases:
        1) When y1 = y2
        If y2 < y1 then we change this two point coordinates

        (x-x1)/(x2-x1) = (y-y1)/(y2-y1) Из теоремы про пропорциональные отрезки ->
        (x-x1)*(y2-y1) = (x2-x1)*(y-y1) ->
        x = (((x2-x1)*(y0-y1))/(y2-y1))+x1

         */

        if (y1 == y2){
            return false;
        }

        int temp;
        if (y2 < y1){
            temp = y2;
            y2 = y1;
            y1 = temp;

            temp = x2;
            x2 = x1;
            x1 = temp;
        }

        if (y0 == y1){
            return false;
        }
        if (y0 == y2){
            return x0 <= x2;
        }

        if ((y0 - y2)*(y0-y1) > 0 ){
            return false;
        }

        return (x2-x1)*(y0-y1) - (x0-x1)*(y2-y1) > 0; //Решение через векторное умножение...не будет проблем с точностью

//        int x = (((x2-x1)*(y0-y1))/(y2-y1))+x1; // Могут быть проблемы с точностью
//        return x >= x0;


    }

    public static double length(int x1, int y1, int x2, int y2){
        return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));

    }


    public static boolean onSegment(int x0, int y0, int x1, int y1, int x2, int y2){
        return Math.abs(length(x1,y1,x2,y2) - length(x0,y0,x1,y1) - length(x0,y0,x2,y2)) < 1e-6;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in .nextInt();

        int[] x = new int[n+1];
        int[] y = new int[n+1];

        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }

        x[n] = x[0];
        y[n] = y[0];

        int x0 = in.nextInt();
        int y0 = in.nextInt();

        //Нужно пробежаться по всем отрезкам
        //Но если точка лежит на стороне - то нужно отдельно рассматривать этот случай
        int count = 0;
        for (int i = 0; i < n; i++) {

            if (onSegment(x0,y0,x[i],y[i],x[i+1],y[i+1])){
                System.out.println("Inside");
                return;
            }

            if (intersect(x0, y0, x[i], y[i], x[i+1], y[i+1])){
                count++;
            }
        }

        if (count%2 == 0){
            System.out.println("Outside");
        } else {
            System.out.println("Inside");
        }

    }
}
