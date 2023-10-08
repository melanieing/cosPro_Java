package num;

/**
 * 71150. Up and down_빈칸채우기
 * 현재 정답이 될 수 있는 숫자는 몇 개?
 */
public class UpDown71150 {
    public static void main(String[] args) {
        UpDown71150 q = new UpDown71150();
        int k = 10;
        int[] numbers = {4, 9, 6};
        String[] upDown = {new String("UP"), new String("DOWN"), new String("UP")};

        System.out.println(q.solution(k, numbers, upDown));

    }

    private int solution(int k, int[] numbers, String[] upDown) {
        int left = 1;
        int right = k;

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (upDown[i].equals("UP")) {
                left = Math.max(num + 1, left);
            } else if (upDown[i].equals("DOWN")) {
                right = Math.min(num - 1, right);
            } else if (upDown[i].equals("RIGHT")) {
                return 1;
            }
        }

        return right - left + 1;
    }


}
