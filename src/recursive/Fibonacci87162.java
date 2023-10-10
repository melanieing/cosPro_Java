package recursive;
/**
 * 87162. 피보나치 수열의 합_함수 작성
 * 피보나치수열의 a번째 항부터 b번째 항까지의 합
 */
public class Fibonacci87162 {
    public static void main(String[] args) {
        Fibonacci87162 q = new Fibonacci87162();
        int a = 2;
        int b = 5;

        System.out.println(q.solution(a, b));
    }

    public int solution(int a, int b) {
        int answer = 0;

        for (int i = a; i <= b; i++) {
            answer += fibo(i);
        }

        return answer;
    }

    public int fibo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
