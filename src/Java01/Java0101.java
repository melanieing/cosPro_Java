package Java01;

/**
 * #문제1
 * 어느 누군가가 타임머신을 타고 과거로 가서 숫자 0이 없는 수 체계를 전파했습니다.
 * 역사가 바뀌어 이제 사람들의 의식 속엔 0이란 숫자가 사라졌습니다. 따라서, 현재의 수 체계는 1, 2, 3, ..., 8, 9, 11, 12, ...와 같이 0이 없게 바뀌었습니다
 * 0을 포함하지 않은 자연수 num이 매개변수로 주어질 때, 이 수에 1을 더한 수를 return 하도록 solution 메소드를 완성해주세요.
 *
 * #####매개변수 설명
 * 자연수 num이 solution 메소드의 매개변수로 주어집니다.
 * * num은 1 이상 999,999,999,999,999,999 이하의 0을 포함하지 않는 자연수입니다.
 *
 * #####return 값 설명
 * 자연수 num에 1을 더한 수를 return 해주세요.

 * #####예시
 * | num     | return |
 * |---------|---------|
 * | 9949999 | 9951111 |
 *
 * #####예시 설명
 * 9,949,999에 1을 더하면 9,950,000이지만 0은 존재하지 않으므로 9,951,111이 됩니다.
 */
public class Java0101 {
    public long solution1(long num) {
        // Write code here.
        long answer = num; // 일단 원래 수 넣어놓기

        while (true) {
            answer += 1;
            if (!Long.toString(answer).contains("0")) { // 0을 포함하지 않는다면 나오기
                break;
            }
        }

        return answer;
    }

    public long solution2(long num) {
        num++; // 하나 올리고 시작
        long digit = 1;

        while (num / digit % 10 == 0) { // 원래 수를 digit 자릿수로 나눈 몫을 10으로 나눈 나머지가 0일 때만 반복 -> 0이 들어있을 때만 반복
            num += digit; // 자릿수만큼 더해주기
            digit *= 10; // 자릿수 하나 올려주기 -> 자릿수를 뒤에서 앞으로 옮겨가며 검증
        }
        return num;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Java0101 sol = new Java0101();
        long num = 9949999;

        long ret = sol.solution1(num); // 내 풀이
//        long ret = sol.solution2(num); // 예시답안

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}
