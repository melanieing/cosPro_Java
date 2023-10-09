package num;
/**
 * 78077. 숫자 압축_디버깅
 * num을 한 자리로 압축한 숫자를 반환
 */
public class ZipNum78077 {
    public static void main(String[] args) {
        ZipNum78077 q = new ZipNum78077();
        int num = 345;

        System.out.println(q.solution(num));

    }

    private int solution(int num) {
        while (num >= 10) {
            int total = 0;
            while (num > 0) {
                total += num % 10; // 각 자릿수 더하기
                num /= 10;
            }
            num = total;
        }
        return num;
    }
}
