package search;
/**
 * 78075. 전단지_빈칸채우기
 * 전단지가 P장만큼 겹쳐서 붙어있는 부분의 넓이
 */
public class Flyers78075 {

    public int[][] board = new int[100][100];

    public static void main(String[] args) {
        Flyers78075 q = new Flyers78075();
        int[][] flyers = {{20,20}, {30,10}, {35,35}};

        System.out.println(q.solution(flyers));
    }

    private int solution(int[][] flyers) {
        for (int[] flyer : flyers) {
            funcC(flyer[0], flyer[1]); // 전단지 영역 표시
        }

        int maxOverlap = funcB(); // 겹친 전단지 최대 개수

        return funcA(maxOverlap); // 해당 개수만큼 붙은 넓이 구하기
    }

    public int funcA(int param) {
        int ret = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (param == board[i][j]) {
                    ret++;
                }
            }
        }
        return ret;
    }

    public int funcB() {
        int ret = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                ret = Math.max(ret, board[i][j]);
            }
        }
        return ret;
    }

    public void funcC(int x, int y) {
        for (int i = x; i < x + 20; i++) {
            for (int j = y; j < y + 30; j++) {
                board[i][j]++;
            }
        }
    }
}
