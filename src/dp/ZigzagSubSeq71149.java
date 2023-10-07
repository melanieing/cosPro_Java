package dp;

/**
 * 71149. 지그재그 부분 수열_빈칸채우기
 * 부분 수열 중 가장 긴 지그재그 수열의 길이를 구하기
 * 지그재그 수열 : 첫 번째 원소부터 인접한 원소의 차이가 ... 증가 → 감소 → 증가 → 감소 ... 순으로 나타나는 수열
 */
public class ZigzagSubSeq71149 {

    final int INC = 0; // 증가
    final int DEC = 1; // 감소

    public static void main(String[] args) {
        ZigzagSubSeq71149 q = new ZigzagSubSeq71149();
        int[] arr = {2, 5, 7, 3, 4, 6, 1, 8, 9};

        System.out.println(q.solution(arr));
    }

    public int solution(int[] arr) {
        int[] check = checkIncDec(arr);
        int[] dp = makeZigzagSeq(check);
        return getMax(dp);
    }

    public int[] checkIncDec(int[] arr) { // 각 숫자가 바로 이전 숫자보다 증가했는지, 혹은 감소했는지 표시한 배열을 만들기
        int length = arr.length;
        int[] check = new int[length];
        check[0] = -1; // 첫 번째 숫자는 증가도, 감소도 하지 않았다는 의미에서 -1로 표시

        for (int i = 1; i < length; i++) {
            if (arr[i] > arr[i-1]) {
                check[i] = INC;
            } else if (arr[i] < arr[i-1]) {
                check[i] = DEC;
            }
        }

        return check;
    }

    public int[] makeZigzagSeq(int[] check) { // 1단계에서 만든 증가, 감소 배열을 이용해 각 숫자를 마지막으로 하는 지그재그 수열 중 가장 긴 것의 길이를 담은 배열을 만들기
        int[] maxLengths = new int[check.length];
        maxLengths[0] = 1;

        for (int i = 1; i < check.length; i++) {
            if (check[i] != check[i-1]) {
                maxLengths[i] = maxLengths[i-1] + 1;
            } else {
                maxLengths[i] = 2;
            }
        }
        return maxLengths;
    }

    public int getMax(int[] dp) { // 2단계에서 구한 배열에 담긴 값 중 최댓값 -> 부분 수열 중 가장 긴 지그재그 수열의 길이
        int ret = 0;

        for (int j : dp) {
            if (ret < j) ret = j;
        }

        if (ret == 2) return 0;

        return ret;
    }






    
    


}
