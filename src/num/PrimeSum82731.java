package num;
/**
 * 82731. 약수의 합_함수 작성
 * n의 모든 약수의 합?
 */
public class PrimeSum82731 {
    public static void main(String[] args) {
        PrimeSum82731 q = new PrimeSum82731();
        int n = 12;

        System.out.println(q.solution(n));
    }

    private int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) { // 약수일 경우
                answer += i;
            }
        }

        return answer;
    }
}
