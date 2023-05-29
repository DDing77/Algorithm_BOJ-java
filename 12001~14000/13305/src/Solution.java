import java.util.*;

class Solution {
    public int solution(int[][] tower, int k) {
        int ans = 0;

        for (int i = 1; i <= 10; i++) { // 높이
            int L = 0, R = 0;
            Boolean firstTower = true;
            for (int j = 0; j < tower.length; j++) {// 가로 좌표
                if (tower[j][1] != i) continue;
                else {
                    if (firstTower) { // 처음 송전탑
                        L = tower[j][0];
                        R = tower[j][0];
                        ans++;
                        firstTower = false;
                    } else {
                        R = tower[j][0];
                        if (R - L <= k) { // 연결 가능 경우
                            L = R;
                        } else { // 연결 불가능 경우
                            L = R;
//                            firstTower = true;
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

}