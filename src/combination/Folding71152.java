package combination;
/**
 * 71152. 종이접기_디버깅
 * 격자 선을 따라 종이를 한 번 접었을 때 만나는 격자 칸에 적힌 숫자의 합 중 최댓값
 */
public class Folding71152 {
    public static void main(String[] args) {
        Folding71152 q = new Folding71152();
        int[][] grid = {{1, 4, 16, 1}, {20, 5, 15, 8}, {6, 13, 36, 14}, {20, 7, 19, 15}};

        System.out.println(q.solution(grid));
    }

    private int solution(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = j + 1; k < 4; k += 2) {
                    answer = Math.max(answer, Math.max(grid[i][j] + grid[i][k], grid[j][i] + grid[k][i]));
                }
            }
        }

        return answer;
    }
}
