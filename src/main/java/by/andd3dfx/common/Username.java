package by.andd3dfx.common;

/**
 * Implement the validate function, which accepts a username and returns true
 * if it's acceptable and false if it's not.
 * <p>
 * A username is valid if it satisfies the following rules:
 * <pre>
 * - The username must be at least 6 characters long and not exceed 16 characters.
 * - The username must contain only letters, numbers and optionally one hyphen (-).
 * - The username must start with a letter, and must not end with a hyphen.
 * </pre>
 * For example, Username.validate("Mike Standish") would return false because it contains space.
 */
public class Username {

    private static final String[] patterns = {
            "^[A-Za-z0-9\\-]{6,16}$",               // Allowed only chars and digits, definite size range
            "^[A-Za-z].*",                          // Start character
            "^[A-Za-z0-9]*[-]{0,1}[A-Za-z0-9]+$"    // Not ended with '-', no more than one '-'
    };

    public static boolean validate(String username) {
        for (var pattern : patterns) {
            if (!username.matches(pattern)) {
                return false;
            }
        }
        return true;
    }
}
