package ua.com.vtkachenko.ciklum.kyiv.algorythms.club48topcoderpractice.task2;
/*
// BEGIN CUT HERE
/*
// PROBLEM STATEMENT
//
You have a n x n board and several checkers placed on it. The i-th checker is in the cell at row x[i], column y[i]. All coordinates are 1-based. There can be more
than one checker in the same cell. A move consists of taking one checker and moving it one cell up, down, left or right.
You want to put each checker in one of the four corners of the board. Return the minimum number of moves necessary to achieve the goal.
DEFINITION
Class:TheSimpleGame
Method:count
Parameters:int, int[], int[]
Returns:int
Method signature:int count(int n, int[] x, int[] y)
CONSTRAINTS
-n will be between 1 and 100, inclusive.
-x will contain between 1 and 50 elements, inclusive.
-y will contain the same number of elements as x.
-Each element of x will be between 1 and n, inclusive.
-Each element of y will be between 1 and n, inclusive.
EXAMPLES
0)
4
{2}
{3}
Returns: 2
You need two moves to put the only checker to cell (1, 4).
1)
3
{2, 2, 1, 3}
{2, 2, 3, 1}
Returns: 4
For the first two checkers you can choose any of the four corners.
2)
7
{7, 1, 7, 7, 1, 7, 1}
{7, 1, 1, 1, 1, 7, 7}
Returns: 0
All checkers are already in the corners.
*/
// END CUT HERE

public class Solution {

    public static void main(String[] args) {

     Solution solution = new Solution();
     System.out.println(solution.count(3, new int[]{2,2,1,3}, new int[]{2,2,3,1}));
    }
//    int xSteps = n-x > (n+1)/2 ? x : n-x;
//    int ySteps = n-y > (n+1)/2 ? y : n-y;

    public int count(int n, int[] x, int[] y){
        int  result = 0;
        for (int i = 0; i < x.length; i++) {
            int dmin = 2*n;
            int[] dx = {1,n,n,1};
            int[] dy = {1,1,n,n};
            for (int j = 0; j < 4; j++) {
                int currentD = Math.abs(x[i] - dx[j]) + Math.abs(y[i] - dy[j]);
                dmin = Math.min(dmin, currentD);
            }
            result += dmin;
        }
        return result;
    }


}
