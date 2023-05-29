import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static boolean[] isVisited;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Point> homes;
    static ArrayList<Point> chickens;
    static ArrayList<Point> tempChicken;

    static int getDistance(Point home, Point chicken) {
        int temp = Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
        return temp;
    }

    static void combination(int depth, int start) {
        if (depth == M) {
//            System.out.println("tempChicken size : " + tempChickens.size());
            int totalDistance = 0;
            for (Point home : homes) {
                int tempDistance = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (isVisited[j]) {
                        tempDistance = Math.min(tempDistance, getDistance(home, chickens.get(j)));
                    }
                }
                totalDistance += tempDistance;
            }
//            System.out.println("totalDistance : " + totalDistance);
            min = Math.min(totalDistance, min);
            return;
        } else {
            for (int i = start; i < chickens.size(); i++) {
                isVisited[i] = true;
                combination(depth + 1, i + 1);
                isVisited[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        homes = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) homes.add(new Point(i, j));
                else if (value == 2) chickens.add(new Point(i, j));
            }
        }

        isVisited = new boolean[chickens.size()];

        tempChicken = new ArrayList<>();

        combination(0, 0);

        System.out.println(min);
    }
}
