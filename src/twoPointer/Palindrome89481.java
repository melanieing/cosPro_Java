package twoPointer;
/**
 * 89481. 팰린드롬_디버깅
 * 팰린드롬이 : 왼쪽에서부터 읽을 때와 오른쪽에서부터 읽을 때가 같은 문자열
 * 팰린드롬이 몇 개인지 return
 */
public class Palindrome89481 {
    public static void main(String[] args) {
        Palindrome89481 q = new Palindrome89481();
        String[] palindrome = {"aBa", "bccb", "AbBa"};

        System.out.println(q.solution(palindrome));
    }

    private int solution(String[] palindrome) {
        int count = 0;
        
        for (String str : palindrome) {
            if (isPalindrome(str)) count++;
        }
        
        return count;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
