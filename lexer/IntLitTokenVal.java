package lexer;

public class IntLitTokenVal extends TokenVal {
  // new field: the value of the integer literal
    public int intVal;
  // constructor
    public IntLitTokenVal(int line, int ch, int val) {
        super(line, ch);
        intVal = val;
    }
}
