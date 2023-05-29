//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//    static int L;
//    static String str;
//    static int[] pi;
//
//    static void failureFunction() {
//        pi = new int[str.length()];
//        int j = 0;
//        for (int i = 1; i < str.length(); i++) {
//            while (j > 0 && str.charAt(i) != str.charAt(j)) {
//                j = pi[j - 1];
//            }
//            if (str.charAt(i) == str.charAt(j)) {
//                pi[i] = ++j;
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        L = Integer.parseInt(br.readLine());
//        str = br.readLine();
//
//        failureFunction();
//        System.out.println(L - pi[str.length() - 1]);
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String res = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++) {
            String input = Integer.toBinaryString(i);
            sb.append(input);
        }
        System.out.println(sb);
    }
}