package by.andd3dfx.interview.wf.exam;

public class Username {

  static String[] patterns = {
      "^[A-Za-z0-9\\-]{6,16}$",             // Allowed only chars and digits, definite size range
      "^[A-Za-z].*",                        // Start character
      ".*[^\\-]$",                          // Not ended with '-'
      "^[A-Za-z0-9]*[-]{0,1}[A-Za-z0-9]*$"  // No more than one '-'
  };

  public static boolean validate(String username) {
    for (String pattern : patterns) {
      if (!username.matches(pattern)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(validate("Mike-Standish"));    // Valid username
    System.out.println(validate("Mike Standish"));    // Invalid username
  }
}
