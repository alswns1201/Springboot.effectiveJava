package codingTest.character;

import java.util.Stack;

public class match {

    static int answer =0 ;

    static String input ="{()}}";
    public static void main(String[] args) {
        isValid(input);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '(') {
                stack.push(ch); // 여는 괄호를 스택에 추가
            } else if (ch == '}' || ch == ')') {
                if (stack.isEmpty()) {
                    return false; // 닫는 괄호가 여는 괄호 없이 나타났을 때
                }
                char top = stack.pop(); // 스택에서 여는 괄호를 제거
                if (!isMatchingPair(top, ch)) {
                    return false; // 여는 괄호와 닫는 괄호가 일치하지 않을 때
                }
            }
        }

        // 모든 괄호가 올바르게 매칭되었는지 확인
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '{' && close == '}') || (open == '(' && close == ')');
    }
}
