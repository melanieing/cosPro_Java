package combination;
/**
 * 71153. 보드게임_디버깅
 * 최대로 획득할 수 있는 코인의 양(말은 오른쪽 또는 아래쪽으로만 이동가능)
 */
public class BoardGame71153 {
    public static void main(String[] args) {
        BoardGame71153 q = new BoardGame71153();
        int[][] board = {{6, 7, 1, 2}, {3, 5, 3, 9}, {6, 4, 5, 2}, {7, 3, 2, 6}};

        System.out.println(q.solution(board));
    }

    public int solution(int[][] board) {

        int[][] coins = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0 && j == 0) {
                    coins[i][j] = board[i][j];
                } else if (i == 0 && j != 0) {
                    coins[i][j] = board[i][j] + coins[i][j-1];
                } else if (i != 0 && j == 0) {
                    coins[i][j] = board[i][j] + coins[i-1][j];
                } else {
                    coins[i][j] = board[i][j] + Math.max(coins[i][j-1], coins[i-1][j]);
                }
            }
        }

        return coins[3][3];
    }
}
