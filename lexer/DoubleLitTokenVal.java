package lexer;

public class DoubleLitTokenVal extends TokenVal {
  // new field: the value of the integer literal
    public double doubleVal;
  // constructor
    public DoubleLitTokenVal(int line, int ch, double val) {
        super(line, ch);
        doubleVal = val;
    }
}
