package lexer;

public class StrLitTokenVal extends TokenVal {
  // new field: the value of the string literal
    public String strVal;
  // constructor
    public StrLitTokenVal(int line, int ch, String val) {
        super(line, ch);
        strVal = val;
    }
}
