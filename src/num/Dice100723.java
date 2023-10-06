package num;
/**
 * 100723. 주사위_함수 작성
 * 주사위를 던져서 받게 될 총 상금
 */
public class Dice100723 {
    public static void main(String[] args) {
        Dice100723 q = new Dice100723();
        int[][] dice = {{3,3}, {2,5}};

        System.out.println(q.solution(dice));
    }

    private int solution(int[][] dice) {
        int answer = 0;

        for (int[] arr : dice) {
            if (arr[0] == arr[1]) {
                answer += arr[0] * 1000;
            } else {
                int max = Math.max(arr[0], arr[1]);
                int min = Math.min(arr[0], arr[1]);
                answer += (max * 500 + min * 100);
            }
        }

        return answer;
    }


}
