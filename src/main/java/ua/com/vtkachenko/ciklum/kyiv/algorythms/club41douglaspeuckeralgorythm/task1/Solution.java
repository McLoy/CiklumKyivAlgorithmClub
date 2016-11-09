package ua.com.vtkachenko.ciklum.kyiv.algorythms.club41douglaspeuckeralgorythm.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
A polygonal chain(polyline) P= {p1,...,pn} is connected series of line segments pipi+1 (i=1,N)
Polyline simplification is the process of reducing the resolution of a polyline.
This is achieved be removing vertices and edges, while maintaining a

Uses in Map Generalization
github.com/hgoebl/simplify-java - implementation code

Given line that given like array of points p1-pn, need to find subsequence of indexes Q = {P[i][j]}
from Pi to Pi(j-1)Pi(j) < e(число)

Solution is algorythm of Douglas Peucker uses recursion - is the fastest way

Recursion:
We add base line - we made union of first and last point(line0), and we searching point1 on maksimum length from line0
and made line1 from first point to it and length of this line1 must be < e (if we not found such line
then we have a solution of this task). Then we line1 divide: line1/2;
Then we repeat this algorithm from point1 like from start/
We will make solution and it need that line not cross itself

Iterative variant:
Another approach: We make itarable algorithm that goes from point0 each point and control that
length from maximum to line0 < e. If line0 > 0 then we go to previous point and mark it like point1
(this algorithm not optimal, but it is very simple if base lines line0 not cross another(like in case of spiral))

O(n logn) and the worst case O(n*n)
 */
/*
Input format
n eps
x1 y1
....
xn yn
Output format
x1 y1
...
xk yk

primer
https://github.com/banamir/DouglasPeucker

 */
public class Solution {

    public static Point vect(Point a, Point b){
        return new Point(b.x - a.x, b.y - a.y);
    }

    private static double abs2(Point a) {
        return Math.pow(a.x, 2) + Math.pow(a.y, 2);
    }

    public static double abs(Point a){
        return Math.sqrt(abs2(a));
    }

    public static double vectProduct(Point a, Point b){
        return a.x*b.y - a.y*b.x;
    }

    public static double dist(Point a, Point b, Point p){
        Point r1 = vect(a, p);
        Point r2 = vect(b, p);
        Point r = vect(a, b);
        if (abs2(r2) >= abs2(r1) + abs2(r)){
            return abs(r1);
        }
        if (abs2(r1) >= abs2(r2) + abs2(r)){
            return abs(r2);
        }
        return Math.abs(vectProduct(r, r1)/abs(r));
    }

    public static int indexMaxDist(Point[] points, int i, int j){
        int res = i;
        double maxDist = Double.MAX_VALUE;
        for (int k = i; k < j ; k++) {
            double dist = dist(points[i], points[j], points[k]);
            if (dist > maxDist){
                maxDist = dist;
                res = k;
            }
        }
        return res;
    }

    public static class Point{

        public Point() {
            this(0, 0);
        }

        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }

        double x,y;
    }

    public static Point[] solve(Point[] polyline, double eps){
        List<Point> list = new ArrayList<Point>();
        int left = 0;
        list.add(polyline[0]);
        for (int i = 0; i < polyline.length; i++) {
            int index = indexMaxDist(polyline, left, i);
            if (eps > dist(polyline[left], polyline[i], polyline[index])){
                list.add(polyline[i-1]);
                left = i - 1;
            }
        }
        list.add(polyline[polyline.length - 1]);
        return list.toArray(new Point[0]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double eps = in.nextDouble();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(in.nextDouble(), in.nextDouble());
        }
        Point[] res = solve(points, eps);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i].x + " " + res[i].y);
        }

    }

}
