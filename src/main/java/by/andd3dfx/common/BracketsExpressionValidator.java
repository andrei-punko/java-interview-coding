package by.andd3dfx.common;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * Есть скобочное выражение с разными видами скобок: {}, (), [], <>.
 * Проверить, что оно правильное.
 * Других символов, кроме скобок, быть не может.
 *
 * ([{}]) -> true
 * ([)] -> false
 * </pre>
 */
public class BracketsExpressionValidator {

    private static final Set<Character> CLOSING_BRACKETS = Set.of('}', ')', ']', '>');
    private static final Map<Character, Character> CLOSING_2_OPENING_BRACKET_MAP = Map.of(
            ')', '(',
            '}', '{',
            ']', '[',
            '>', '<'
    );

    /**
     * Проходим по массиву символов, складываем их в стек.
     * Когда находим закрывающую скобку - проверяем, есть ли вверху стека парная к ней открывающая.
     * Если нет - выражение ошибочно. Если есть - продолжаем обход.
     * После обхода, если стек пустой - валидация прошла успешно.
     */
    public static boolean validate(String expression) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : expression.toCharArray()) {
            if (CLOSING_BRACKETS.contains(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }

                var expectedOpeningBracket = CLOSING_2_OPENING_BRACKET_MAP.get(ch);
                if (stack.peek() != expectedOpeningBracket) {
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
