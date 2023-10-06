package num;

/**
 * 100724. 돌 가져오기_함수 작성
 * 게임에서 승리한 참여자는 몇 번 참여자일까?
 */
public class FetchStone100724 {
    public static void main(String[] args) {
        FetchStone100724 q = new FetchStone100724();
        int n = 3;
        int k = 10;
        int[] rocks = {2, 3, 1, 2, 3, 2};

        System.out.println(q.solution(n, k, rocks));
    }

    private int solution(int n, int k, int[] rocks) {
        int answer = 0;
        int num = 0;
        Outer:
        for (int i = 0; i < rocks.length; i++) {
            for (int j = 0; j < rocks[i]; j++) {
                num++;
                if (num == k) {
                    answer = (i % n) + 1;
                    break Outer;
                }
            }
        }
        return answer;
    }
}
