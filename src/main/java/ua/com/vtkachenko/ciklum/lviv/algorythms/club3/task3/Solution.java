package ua.com.vtkachenko.ciklum.lviv.algorythms.club3.task3;

import javax.naming.ldap.HasControls;
import java.util.*;

/*
Кенгуру знаходиться на старті бігової доріжки. Кенгуру може стрибати на відстань від 1 до 10 метрів.
Але щоб стрибнути на 10 метрів йому потрібно добряче розігнатися. Завдяки явищу інерції кожен наступний стрибок
може бути або на 1 метр довший або на 1 метр коротший за попередній, також може бути рівний попередньому.
Відповідно кенгуру не може зупинитися в будь-який момент, а лише коли довжина попереднього стрибка була рівною 1 метру.

На біговій доріжці є ряд перешкод у вигляді ям різної ширини. Попавши в яму кенгуру більше не може з неї вибратися.
Будь-який стрибок кенгуру займає 1 секунду часу. За який найменший час кенгуру може фінішувати на заданій доріжці?
Кенгуру повинен зупинитися точно на фініші. Кенгуру не повинен попадати в жодну яму. Якщо яма знаходиться на фініші, то вважати фініш недосяжним.

Початкові дані

В першому рядку вхідного потоку міститься одне ціле число L – довжина бігової доріжки в метрах, 1<=L<=30000.
В другому рядку вхідного потоку міститься L чисел розділених пропусками, що позначають стан бігової доріжки в позиціях 1, 2, 3, ..., L метрів відповідно. 0 позначає добрий стан доріжки, 1 позначає яму в заданій позиції. Інших позначень немає.
Результат

В перший рядок вихідного потоку вивести єдине ціле число – найменший час в секундах, за який кенгуру може сягнути фінішу за умови повної зупинки на фініші. Якщо кенгуру взагалі не може досягнути фінішу, вивести -1.

Приклад початкових даних

Початкові дані, що відповідають малюнку наведеному вище:

14
0 1 0 0 1 0 0 0 1 1 0 0 0 0
Приклад результату:

Результат, який відповідає початковим даним, що наведені вище: 7
 */
public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        boolean[] track = new boolean[L];

        for (int i = 0; i < L; i++) {
            track[i] = in.nextInt() == 0;
        }

        Queue<Point> q = new LinkedList<>();
        Set<Point> visited = new HashSet<>();

        Point first = new Point(0, 1, 1);
        q.add(first);
        visited.add(first);

        int minTime = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == L - 1 && p.speed == 1) {
                minTime = Math.min(minTime, p.time);
            }

            int nextX = p.x + p.speed - 1;
            Point next = new Point(nextX, p.speed - 1, p.time + 1);
            if (!visited.contains(next) && next.x > p.x && next.speed >= 1 && nextX < L && track[nextX]) {
                q.add(next);
                visited.add(next);
            }

            nextX = p.x + p.speed;
            next = new Point(nextX, p.speed, p.time + 1);
            if (!visited.contains(next) && nextX < L && track[nextX]) {
                q.add(next);
                visited.add(next);
            }

            nextX = p.x + p.speed + 1;
            next = new Point(nextX, p.speed + 1, p.time + 1);
            if (!visited.contains(next) && next.speed <= 10 && nextX < L && track[nextX]) {
                q.add(next);
                visited.add(next);
            }
        }

        if (minTime == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minTime);
        }

    }

    public static class Point {
        int x, speed, time;

        public Point(int x, int speed, int time) {
            this.x = x;
            this.speed = speed;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return speed == point.speed;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + speed;
            return result;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", speed=" + speed +
                    ", time=" + time +
                    "}";
        }
    }
}
