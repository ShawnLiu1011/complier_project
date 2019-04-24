package parser;
/**
 * An exception class for syntax errors detected by the parser.
 * Notice: this class inherits from RuntimeException instead of
 * Exception because it is thrown by the method syntax_error from
 * the generated parser. This method overwrite a default method of 
 * same name which is *not* throwing any Exception and consequently
 * it is not possible to add any "throws" clause to this method
 */
public class SyntaxErrorException extends RuntimeException {

	private static final long serialVersionUID = 11111;

    public SyntaxErrorException() {
    }
}
