package ua.com.vtkachenko.ciklum.kyiv.algorythms.club43.task2;

import java.util.Scanner;

/*
Polygon square

There is polygon with vertices (x1, y1), ..., (xn, yn). Calculate its square
Input Format

First line contains the number of vertices in polygon n . Next n lines contain pair of integer numbers xi, yi, that represent coordinates of vertices
Output Format

On a single line print double number with one decimal place
Sample Input

4
-1 -2
-4 3
0 3
4 2
Sample Output

20.5

 */
/*
Решаем методом трапеций, площадь трапеции s = (a+b)/2 * h, h - высота трапеции
Если у нас есть триугольник с точками (x1,y1), (x2,y2), (x3,y3) - мы делаем проекции на ось иксов и выделяем 3 трапеции
Общая площадь s = (x2-x1)*(y1+y2)/2 + (x3-x2)*(y3+y2)/2 + (x1-x3)*(y3+y1)/2
 */
public class Solution {
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


        double s = 0;
        for (int i = 0; i < n; i++) {
            s += (x[i+1] - x[i])*(y[i+1] + y[i]);
        }

        System.out.printf("%.1f", Math.abs(s/2));
    }
}
