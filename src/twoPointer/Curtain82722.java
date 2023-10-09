package twoPointer;

import java.util.Arrays;

/**
 * 82722. 커튼_빈칸채우기
 * 영희가 구매하게 될 커튼의 가로길이?
 */
public class Curtain82722 {
    public static void main(String[] args) {
        Curtain82722 q = new Curtain82722();
        int width = 200;
        int[] curtain = {100, 300, 250, 190};

        System.out.println(q.solution(width, curtain));
    }

    private int solution(int width, int[] curtain) {
        int answer = 0;
        Arrays.sort(curtain);// 오름차순으로 정렬하면 가장 짧은 커튼을 구할 수 있음

        int left = 0, mid, right = curtain.length - 1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (curtain[mid] >= width) { // 영희 방 벽의 가로길이보다 같거나 긴 가로길이의 커튼
                answer = curtain[mid];
                right = right-1;
            } else {
                left = left+1;
            }
        }

        return answer;
    }
}
