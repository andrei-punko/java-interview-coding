package by.andd3dfx.common;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Есть скобочное выражение с разными видами скобок {}, (), [], <>.
 * Проверить, что оно правильное.
 * Других символов, кроме скобок, быть не может.
 * <p>
 * ([{}]) -> true
 * ([)] -> false
 */
public class BracketsExpressionValidator {

    /**
     * Проходим по массиву символов, складываем их в стек.
     * Когда находим закрывающую скобку - проверяем, есть ли вверху стека парная к ней открывающая.
     * Если нет - выражение ошибочно. Если есть - продолжаем обход.
     * После обхода, если стек пустой - валидация прошла успешно.
     */
    public static boolean validate(String expression) {
        Stack<Character> stack = new Stack<>();
        Set<Character> closingBrackets = Set.of('}', ')', ']', '>');
        Map<Character, Character> close2OpenBracketMap = Map.of(
                ')', '(',
                '}', '{',
                ']', '[',
                '>', '<'
        );

        for (char ch : expression.toCharArray()) {
            if (closingBrackets.contains(ch)) {
                if (stack.isEmpty() || stack.peek() != close2OpenBracketMap.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
