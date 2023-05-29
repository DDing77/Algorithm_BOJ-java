import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] opNumber;
    static int[] arr1;
    static int[] arr2;
    static int[][] tree;
    static int[] maxTree;

    static void init(int start, int end, int nodeNum) {
        if (start == end) tree[nodeNum] = new int[]{opNumber[start]};
        else {
            int mid = (start + end) >> 1;
            init(start, mid, nodeNum * 2);
            init(mid + 1, end, nodeNum * 2 + 1);
            merge(start, end, nodeNum);
        }
    }

    static int initMax(int start, int end, int nodeNum) {
        if (start == end) return maxTree[nodeNum] = start;
        int mid = (start + end) >> 1;
        int aa = initMax(start, mid, nodeNum * 2);
        int bb = initMax(mid + 1, end, nodeNum * 2 + 1);

        if (arr2[aa] > arr2[bb]) maxTree[nodeNum] = aa;
        else maxTree[nodeNum] = bb;

        return maxTree[nodeNum];
    }

    static void merge(int start, int end, int nodeNum) {
        tree[nodeNum] = new int[end - start + 1];
        int l = start;
        int mid = (start + end) >> 1;
        int r = mid + 1;
        int idx = 0;
        while (l <= mid && r <= end) {
            if (opNumber[l] < opNumber[r]) tree[nodeNum][idx++] = opNumber[l++];
            else tree[nodeNum][idx++] = opNumber[r++];
        }
        while (l <= mid) tree[nodeNum][idx++] = opNumber[l++];
        while (r <= end) tree[nodeNum][idx++] = opNumber[r++];

        for (int i = start; i <= end; i++) opNumber[i] = tree[nodeNum][i - start];
    }

    static int lowerBound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    static int getCntQuery(int start, int end, int queryLeft, int queryRight, int nodeNum, int target) {
        int res = 0;

        if (start > queryRight || end < queryLeft) return 0;
        if (queryLeft <= start && end <= queryRight) {
            int idx = lowerBound(tree[nodeNum], target);
            if (0 <= idx && idx < tree[nodeNum].length) return tree[nodeNum].length - idx;
            else return 0;
        }

        int mid = (start + end) >> 1;
        res = getCntQuery(start, mid, queryLeft, queryRight, nodeNum * 2, target) +
                getCntQuery(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1, target);
        return res;
    }

    static int maxQuery(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        int res = 0;
        if (start > queryRight || end < queryLeft) return -1;
        if (queryLeft <= start && end <= queryRight) return maxTree[nodeNum];

        int mid = (start + end) >> 1;
        int aa = maxQuery(start, mid, queryLeft, queryRight, nodeNum * 2);
        int bb = maxQuery(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);

        if (aa < 0) res = bb;
        else if (bb < 0) res = aa;
        else {
            if (arr2[aa] > arr2[bb]) res = aa;
            else res = bb;
        }
        return res;
    }

    static class Card {
        int front;
        int back;

        public Card(int front, int back) {
            this.front = front;
            this.back = back;
        }
    }

    static class Info implements Comparable<Info> {
        int number;
        int idx;

        public Info(int number, int idx) {
            this.number = number;
            this.idx = idx;
        }

        @Override
        public int compareTo(Info o) {
            return number - o.number;
        }
    }

    static Card[] cards;
    static Info[] infos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int startLeaf = 1;
        while (startLeaf < M) startLeaf *= 2;
        int length = startLeaf * 2;

        cards = new Card[N];
        infos = new Info[M];
        opNumber = new int[M];
        arr1 = new int[M];
        arr2 = new int[M];
        tree = new int[length + 1][];
        maxTree = new int[length + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            cards[i] = new Card(front, end);
        }

        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(br.readLine());
            infos[i] = new Info(number, i);
            opNumber[i] = number;
        }

        Arrays.sort(infos);

        for (int i = 0; i < M; i++) {
            arr1[i] = infos[i].number;
            arr2[i] = infos[i].idx;
        }

        init(0, M - 1, 1);
        initMax(0, M - 1, 1);

        long ans = 0;

        for (int i = 0; i < N; i++) {
            int minCard = Math.min(cards[i].front, cards[i].back);
            int maxCard = Math.max(cards[i].front, cards[i].back);
            int minIdx = lowerBound(arr1, minCard);
            int maxIdx = lowerBound(arr1, maxCard);
            int a = 0;

            if (minIdx < maxIdx) {
                int start = maxQuery(0, M - 1, minIdx, maxIdx - 1, 1);
                start = arr2[start];
                a = getCntQuery(0, M - 1, start + 1, M - 1, 1, maxCard);
                ans += a % 2 == 0 ? maxCard : minCard;

                System.out.println("start " + start);

            } else {
                a = getCntQuery(0, M - 1, 0, M - 1, 1, maxCard);
                ans += a % 2 == 0 ? cards[i].front : cards[i].back;

            }
            System.out.println("ans : " + ans);
            System.out.println("mindCard : " + minCard);
            System.out.println("maxCard : " + maxCard);
            System.out.println("minIdx : " + minIdx);
            System.out.println("maxIdx : " + maxIdx);

            System.out.println("a : " + a);
            System.out.println("------------------");
        }
//        for(int i=0; i<=length; i++) System.out.println(Arrays.toString(tree[i]));
//        System.out.println(Arrays.toString(maxTree));
        System.out.println(ans);
    }
}
