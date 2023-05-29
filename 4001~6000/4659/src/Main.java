import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static char[] vowList = {'a', 'e', 'i', 'o', 'u'};

    // 모음 확인
    static boolean isVow(char cur) {
        for (int i = 0; i < vowList.length; i++) {
            if (cur == vowList[i]) return true;
        }
        return false;
    }

    // 연속 중복 확인
    static boolean isDuplicate(String str, int preIdx, int curIdx) {
        String sub = str.substring(preIdx, curIdx + 1);
        if (sub.equals("ee") || sub.equals("oo")) return false;
        else if (sub.charAt(0) == sub.charAt(1)) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;

            int vowCnt = 0;
            int conCnt = 0;
            boolean isAcceptable = true;
            boolean hasVow = false;

            for (int i = 0; i < input.length(); i++) {
                char cur = input.charAt(i);
                boolean vow = isVow(cur);

                // 모음일 때
                if (vow) {
                    hasVow = true;
                    vowCnt++;
                    conCnt = 0;
                } else { // 자음일 때
                    conCnt++;
                    vowCnt = 0;
                }

                if (i == input.length() - 1) {
                    if (!hasVow) {
                        sb.append('<').append(input).append("> is not acceptable.").append('\n');
                        isAcceptable = false;
                        break;
                    }
                }

                if (1 <= i) {
                    if (isDuplicate(input, i - 1, i)) {
                        sb.append('<').append(input).append("> is not acceptable.").append('\n');
                        isAcceptable = false;
                        break;
                    } else if (vowCnt >= 3 || conCnt >= 3) {
                        sb.append('<').append(input).append("> is not acceptable.").append('\n');
                        isAcceptable = false;
                        break;
                    }
                }
            }
            if (isAcceptable) sb.append("<" + input + "> is acceptable.").append('\n');
        }
        System.out.print(sb);
    }
}