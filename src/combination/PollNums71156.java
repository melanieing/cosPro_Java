package combination;

import java.util.Arrays;

/**
 * 71156. 숫자 뽑기_함수작성
 * 선택한 숫자 중 가장 큰 수와 가장 작은 수의 차이가 최소가 되록 arr에서 숫자 K개를 선택했을 때, 최댓값과 최솟값의 차이
 */
public class PollNums71156 {
    public static void main(String[] args) {
        PollNums71156 q = new PollNums71156();
        int[] arr = {9, 11, 9, 6, 4, 19};
        int K = 4;

        System.out.println(q.solution(arr, K));
    }

    private int solution(int[] arr, int k) {
        Arrays.sort(arr);

        int answer = arr[arr.length - 1]; // 최댓값으로 초기화

        for (int i = 0; i <= arr.length - k; i++) {
            answer = Math.min(answer,  arr[i + k - 1] - arr[i]);
        }

        return answer;
    }

}
