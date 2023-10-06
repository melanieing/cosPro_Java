package dp;

/**
 * 100722. 최장 감소 부분수열_디버깅
 * 최장 감소 부분수열의 길이
 * 최장 감소 부분수열 : 어떤 임의의 수열에서 몇 개의 수를 제거하여 만든 부분수열 중 내림차순으로 정렬된 가장 긴 수열
 */
public class MaxDescSeq100722 {
    public static void main(String[] args) {
        MaxDescSeq100722 q = new MaxDescSeq100722();
        int[] sequence = {1, 4, 3, 3, 5, 1};

        System.out.println(q.solution(sequence));
    }

    private int solution(int[] sequence) {
        int n = sequence.length;
        int[] dp = new int[n]; // dp[i]: index i에서의 최장 감소 부분수열의 길이

        for (int i  = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence[i] < sequence[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
