package num;
/**
 * 89477. 333_빈칸채우기
 * 3이 적어도 세 번 이상 연속으로 들어간 숫자를 차례대로 나열했을 때 n 번째 숫자
 */
public class TripleThree89477 {
    public static void main(String[] args) {
        TripleThree89477 q = new TripleThree89477();
        int n = 1;

        System.out.println(q.solution(n));
    }

    private int solution(int n) {
        int count = 0;
        int i = 333;

        while (true) {
            int k = i;

            while (k != 0) {
                if (k % 1000 == 333) { // 3이 적어도 세 번 이상 연속
                    count += 1;
                    break;
                } else {
                    k = k / 10;
                }
            }

            if (count == n) return i;
        }
    }
}
