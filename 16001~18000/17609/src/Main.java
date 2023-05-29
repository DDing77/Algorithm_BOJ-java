import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String s;

    static boolean isPalindrome_1(int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindrome_2(int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                boolean lSide = isPalindrome_1(left+1, right);
                boolean rSide = isPalindrome_1(left, right-1);
                if (!lSide && !rSide) return false;
                else return true;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            s = br.readLine();
            int len = s.length() -1;
            if (isPalindrome_1(0, len)) {
                sb.append(0).append('\n');
                continue;
            }
            if (isPalindrome_2(0, len)) sb.append(1).append('\n');
            else sb.append(2).append('\n');
        }
        System.out.println(sb);
    }
}
