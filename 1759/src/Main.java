//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int L, C;
//    static char[] arr, newArr;
//    static boolean[] visit;
//    static StringBuilder sb = new StringBuilder();
//
//    static void bt(int start, int depth, int c, int v) {
//        if (depth == L) {
//            if (v >= 1 && c >= 2) {
//                for (int i = 0; i < newArr.length; i++) {
//                    sb.append(newArr[i]);
//                }
//                sb.append('\n');
//                return;
//            }
//            return;
//        }
//        for (int i = start; i < C; i++) {
//                visit[i] = true;
//                newArr[depth] = arr[i];
//                bt(i+1,i + 1, c + (!check(arr[i]) ? 1 : 0), v + (!check(arr[i]) ? 0 : 1));
//                visit[i] = false;
//
//        }
//
//    }
//
//    static boolean check(char a) {
//        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
//            return true;
//        else
//            return false;
//    }
//
//    static void solution() {
//        int depth = 0;
//        bt(0,0, 0, 0);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        L = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//        arr = new char[C];
//        newArr = new char[L];
//        visit = new boolean[C];
//        String[] input = br.readLine().split(" ");
//        for (int i = 0; i < C; i++) {
//            arr[i] = input[i].charAt(0);
//        }
//        Arrays.sort(arr);
//        solution();
//        System.out.println(sb);
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] arr, newArr;
    static char[] Mo = {'a', 'e', 'i', 'o', 'u'};
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    static void bt(int depth, int start) {
        if (depth == L) {
            int c = 0;
            int v = 0;
            for (int i = 0; i < newArr.length; i++) {
                if (newArr[i] == 'a' || newArr[i] == 'e' || newArr[i] == 'i' || newArr[i] == 'o' || newArr[i] == 'u')
                    v++;
                else c++;
            }
            if (v >= 1 && c >= 2) {
                for (int i = 0; i < newArr.length; i++) {
                    sb.append(newArr[i]);
                }
                sb.append('\n');
                return;
            }
            return;
        }
        for (int i = start; i < C; i++) {
            if (!visit[i]) {
                visit[i] = true;
                newArr[depth] = arr[i];
                bt(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }

    static void solution() {
        int depth = 0;
        bt(0, 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        newArr = new char[L];
        visit = new boolean[C];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            arr[i] = input[i].charAt(0);
        }
        Arrays.sort(arr);
        solution();
        System.out.println(sb);
    }
}
