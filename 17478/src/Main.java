import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static StringBuilder sb;

    static String tab = "____";
    static String start = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    static String one = "\"재귀함수가 뭔가요?\"";
    static String two = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String three = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String four = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    static String five = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String end = "라고 답변하였지.";

    static String makeTab(int depth) {
        String res = "";
        for (int i = 0; i < depth; i++) res += tab;
        return res;
    }

    static void solve(int depth) {
        if (depth == N) {
            String tab = makeTab(depth);
            sb.append(tab).append(one).append('\n');
            sb.append(tab).append(five).append('\n');
            sb.append(tab).append(end).append('\n');
            return;
        }
        String tab = makeTab(depth);
        sb.append(tab).append(one).append('\n');
        sb.append(tab).append(two).append('\n');
        sb.append(tab).append(three).append('\n');
        sb.append(tab).append(four).append('\n');

        solve(depth + 1);

        sb.append(tab).append(end).append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        sb.append(start).append('\n');
        solve(0);

        System.out.print(sb);
    }
}