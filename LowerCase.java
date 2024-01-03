/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the upper-case letters are converted to lower-case letters.
     * Non-letter characters are left as is.
     */
    public static String lowerCase(String s) {
        String result = "";
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            // Check if the character is an uppercase letter based on ASCII values
            if (currentChar >= 'A' && currentChar <= 'Z') {
                // Convert the uppercase letter to lowercase using ASCII manipulation
                result += (char) (currentChar + ('a' - 'A'));
            } else {
                result += currentChar;
            }
        }
        
        return result;
    }
}
