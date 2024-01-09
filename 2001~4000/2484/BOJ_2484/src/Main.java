import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final int DICE_SIZE = 4;
    int N;
    HashMap<Integer, Integer> inputDice;
    int res = 0;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            inputDice = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < DICE_SIZE; j++) {
                int curDice = Integer.parseInt(st.nextToken());
                inputDice.put(curDice, inputDice.getOrDefault(curDice, 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> diceList = new ArrayList<>(inputDice.entrySet());

            diceList.sort((a, b) -> {
                if (Objects.equals(a.getValue(), b.getValue())) {
                    return b.getKey() - a.getKey();
                }
                return Integer.compare(b.getValue(), a.getValue());
            });

//            for (Map.Entry<Integer, Integer> integerIntegerEntry : diceList) {
//                sb.append(integerIntegerEntry.getKey() + " " + integerIntegerEntry.getValue()).append("\n");
//            }
//            sb.append("================").append("\n");

            //size = 4
            if (diceList.size() == DICE_SIZE) {
                res = Math.max(res, diceList.get(0).getKey() * 100);
            }
            //size = 3
            if (diceList.size() == 3) {
                res = Math.max(res, 1_000 + diceList.get(0).getKey() * 100);
            }
            //size == 2
            if (diceList.size() == 2) {
                //3 - 1
                if (diceList.get(0).getValue() == 3) {
                    res = Math.max(res, 10_000 + diceList.get(0).getKey() * 1_000);
                }
                //2 - 2
                if (diceList.get(0).getValue() == 2) {
                    res = Math.max(res, 2_000 + diceList.get(0).getKey() * 500 + diceList.get(1).getKey() * 500);
                }
            }
            //size == 1
            if (diceList.size() == 1) {
                res = Math.max(res, 50_000 + diceList.get(0).getKey() * 5_000);
            }
        }
//        System.out.print(sb);
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Dice implements Comparable<Dice> {
        int number;
        int count;

        public Dice(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Dice o) {
            if (this.count == o.count) {
                return Integer.compare(o.number, this.number);
            }
            return Integer.compare(o.count, this.count);
        }
    }
}
