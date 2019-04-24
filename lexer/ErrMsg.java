package lexer;
/**
 * This class is used to generate warning and fatal error messages.
 */
public class ErrMsg {
    public static int count;
    /**
     * Generates a fatal error message.
     * @param lineNum line number for error location
     * @param charNum character number (i.e., column) for error location
     * @param msg associated message for error
     */
    public static void fatal(int lineNum, int charNum, String msg) {
        count ++;
        System.err.println(lineNum + ":" + charNum + " ***ERROR*** " + msg);
    }

    /**
     * Generates a warning message.
     * @param lineNum line number for warning location
     * @param charNum character number (i.e., column) for warning location
     * @param msg associated message for warning
     */
    public static void warn(int lineNum, int charNum, String msg) {
        System.err.println(lineNum + ":" + charNum + " ***WARNING*** " + msg);
    }

    public static boolean hasFatalError() {
        return (count != 0);
    }

    public static void reset() {
        count = 0;
    }
}
