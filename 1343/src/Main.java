import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void makeResult(int size) {
        while (size > 0) {
            if (size >= 4) {
                sb.append("AAAA");
                size -= 4;
            } else {
                sb.append("BB");
                size -= 2;
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if (s.equals("X")) {
            System.out.println(-1);
            return;
        }

        char c;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == 'X') {
                count++;
                if (i == s.length() - 1) {
                    if (count % 2 == 1) {
                        System.out.println(-1);
                        return;
                    } else {
                        makeResult(count);
                    }
                }
            } else if (c == '.') {
                if (count % 2 == 1) {
                    System.out.println(-1);
                    return;
                } else {
                    makeResult(count);
                    sb.append('.');
                    count = 0;
                }
            }
        }
        System.out.println(sb);
    }


}