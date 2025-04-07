import java.util.*;

public class Main {
    private static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());

        while (testCase-- > 0) {
            String S = sc.nextLine();
            String T = sc.nextLine();

            int[] mapping = new int[ALPHABET_SIZE]; // c(i) = ?
            boolean[] defined = new boolean[ALPHABET_SIZE]; // 정의 여부

            Arrays.fill(mapping, -1);

            boolean conflict = false;

            for (int i = 0; i < S.length(); i++) {
                int from = S.charAt(i) - 'A';
                int to = T.charAt(i) - 'A';

                if (mapping[from] != -1 && mapping[from] != to) {
                    conflict = true;
                    break;
                }
                mapping[from] = to;
                defined[from] = true;
            }

            // 매핑 충돌 발생하면 결정 불가
            if (conflict) {
                System.out.println("mjau");
                continue;
            }

            // 역함수가 존재하려면 injective 조건 만족해야 함
            boolean[] targetUsed = new boolean[ALPHABET_SIZE];
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                if (mapping[i] != -1) {
                    if (targetUsed[mapping[i]]) {
                        // 두 글자가 같은 알파벳으로 매핑 → injective 아님
                        conflict = true;
                        break;
                    }
                    targetUsed[mapping[i]] = true;
                }
            }

            if (conflict) {
                System.out.println("mjau");
                continue;
            }

            // 전체 mapping이 완전히 주어졌는지 확인
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                if (defined[i] && mapping[i] == -1) {
                    // 정의된 글자인데 매핑이 빠졌음
                    conflict = true;
                    break;
                }
            }

            // 정의되지 않은 알파벳 존재하면 "mjau"
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                if (!defined[i]) {
                    System.out.println("mjau");
                    conflict = true;
                    break;
                }
            }
            if (conflict) continue;

            // 이제 사이클 분해 후 최소공배수 계산
            boolean[] visited = new boolean[ALPHABET_SIZE];
            long lcm = 1;

            for (int i = 0; i < ALPHABET_SIZE; i++) {
                if (!visited[i]) {
                    int count = 0;
                    int cur = i;

                    do {
                        visited[cur] = true;
                        cur = mapping[cur];
                        count++;
                    } while (cur != i);

                    lcm = lcm(lcm, count);
                }
            }

            // 현재 암호화가 S에서 T로 한 번 적용된 상태라면,
            // S가 그대로이면 q=0, 아니면 몇 번 후에 S가 돌아오는지 체크
            if (S.equals(T)) {
                System.out.println(0);
            } else {
                // T != S이고 LCM 존재하면 그게 q
                System.out.println(lcm);
            }
        }
    }

    // 유틸: 최대공약수
    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 유틸: 최소공배수
    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
