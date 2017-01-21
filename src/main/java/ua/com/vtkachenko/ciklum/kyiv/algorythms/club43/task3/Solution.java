//package ua.com.vtkachenko.ciklum.kyiv.algorythms.club43.task3;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
///*
//Closest points
//
//There are points with coordinates (x1, y1), ..., (xn, yn). Find distance between pair of closes points
//Input Format
//
//First line contains the number of points n . Next n lines contain pair of integer numbers xi, yi, that represent coordinates of points
//Output Format
//
//On a single line print double number with five decimal places
//Sample Input
//
//4
//-1 -2
//-4 3
//0 3
//4 2
//Sample Output
//
//4.00000
//
// */
//
///*
//Теорема 7 ближайших точек
// */
//public class Solution {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//        List<Point> pointsx = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//           pointsx.add(new Point(in.nextInt(), in.nextInt()));
//        }
//        Collections.sort(pointsx, (p1, p2) -> p1.x - p2.x);
//
//        List<Point> pointsy = new ArrayList<>(pointsx);
//        Collections.sort(pointsy, (p1, p2) -> p1.y - p2.y);
//
//
//
//        System.out.println(min(pointsx, pointsy, 0, n-1));
//    }
//
//    static double getLength(Point a, Point b){
//        return (a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y);
//    }
//
//    static double min(List<Point> pointsx, List<Point> pointsy, int left, int right){
//        if (left >= right) return Double.MAX_VALUE;
//        if (left + 1 == right) return getLength(pointsx.get(left), pointsx.get(right));
//        int mid = (left + right)/2;
//        while (mid < right && pointsx.get(mid + 1).x == pointsx.get(mid).x){
//            mid++;
//        }
//
//        double d = Math.min(min(pointsx, pointsy, left, mid), min(pointsx, pointsy, mid + 1, right));
//
//        final double from = pointsx.get(mid).x - d;
//        final double to = pointsx.get(mid).x + d;
//
//        List<Point> slice = pointsy
//                .stream()
//                .filter(p->p.x >= from && p.x <= to)
//                .collect(Collectors.toList());
//
//        for (int i = 0; i < slice.size(); i++) {
//            for (int j = i + 1; j < i + 7 && j < slice.size(); j++) {
//                d = Math.min(d, getLength(slice.get(i), slice.get(j));
//            }
//        }
//
//        return d;
//    }
//
//    static class Point{
//        int x;
//        int y;
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//}
