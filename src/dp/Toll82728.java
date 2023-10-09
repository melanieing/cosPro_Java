package dp;
/**
 * 82728. 통행료_디버깅
 * 영희가 (1, 1)에서 (n, n)까지 이동하는 동안 지불해야 하는 통행료 총 합의 최솟값?
 */
public class Toll82728 {

    int[][] dp;
    int N;
    int[][] Tolls;

    public static void main(String[] args) {
        Toll82728 q = new Toll82728();
        int n = 3;
        int[][] tolls = {{1,2,3}, {0,0,0}, {4,5,6}};

        System.out.println(q.solution(n, tolls));
    }

    private int solution(int n, int[][] tolls) {
        N = n;
        Tolls = tolls.clone();
        dp = new int[1000][1000];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        proc(0, 0);
        return dp[0][0];
    }

    public int proc(int x, int y) {
        if (dp[x][y] > -1) {
            return dp[x][y];
        }
        int ret = -1;
        if (x == N - 1 && y == N - 1) {
            ret = 0;
        } else if (x == N - 1) {
            ret = proc(x, y + 1);
        } else if (y == N - 1) {
            ret = proc(x + 1, y);
        } else {
            ret = Math.min(proc(x + 1, y), proc(x, y + 1));
        }

        dp[x][y] = ret + Tolls[x][y];
        return dp[x][y];
    }
}
