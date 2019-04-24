package symtable;
import ast.*;

public class Type {
 /**
 * AbstractType class and its subclasses: 
 * ErrorType, IntType, BoolType, VoidType, StringType, FnType, StructType,
 */
public static abstract class AbstractType {

    /**
     * default constructor
     */
    public AbstractType() {
    }

    /**
     * every subclass must provide a toString method and an equals method
     */
    abstract public String toString();
    abstract public boolean equals(AbstractType t);

    /**
     * default methods for "isXXXType"
     */
    public boolean isErrorType() {
        return false;
    }

    public boolean isIntType() {
        return false;
    }

    public boolean isBoolType() {
        return false;
    }

    public boolean isVoidType() {
        return false;
    }
    
    public boolean isStringType() {
        return false;
    }

    public boolean isFnType() {
        return false;
    }

    public boolean isStructType() {
        return false;
    }
    
    public boolean isStructDefType() {
        return false;
    }

    public boolean isDoubleType() {
        return false;
    }
}

// **********************************************************************
// ErrorType
// **********************************************************************
public static class ErrorType extends AbstractType {

    public boolean isErrorType() {
        return true;
    }

    public boolean equals(AbstractType t) {
        return t.isErrorType();
    }

    public String toString() {
        return "error";
    }
}

// **********************************************************************
// IntType
// **********************************************************************
public static class IntType extends AbstractType {

    public boolean isIntType() {
        return true;
    }

    public boolean equals(AbstractType t) {
        return t.isIntType();
    }

    public String toString() {
        return "int";
    }
}

// **********************************************************************
// BoolType
// **********************************************************************
public static class BoolType extends AbstractType {

    public boolean isBoolType() {
        return true;
    }

    public boolean equals(AbstractType t) {
        return t.isBoolType();
    }

    public String toString() {
        return "bool";
    }
}

// **********************************************************************
// VoidType
// **********************************************************************
public static class VoidType extends AbstractType {

    public boolean isVoidType() {
        return true;
    }

    public boolean equals(AbstractType t) {
        return t.isVoidType();
    }

    public String toString() {
        return "void";
    }
}

// **********************************************************************
// StringType
// **********************************************************************
public static class StringType extends AbstractType {

    public boolean isStringType() {
        return true;
    }

    public boolean equals(AbstractType t) {
        return t.isStringType();
    }

    public String toString() {
        return "String";
    }
}

// **********************************************************************
// FnType
// **********************************************************************
public static class FnType extends AbstractType {

    public boolean isFnType() {
        return true;
    }

    public boolean equals(AbstractType t) {
        return t.isFnType();
    }

    public String toString() {
        return "function";
    }
}

// **********************************************************************
// StructType
// **********************************************************************
public static class StructType extends AbstractType {
    
    private AST.IdNode myId;
    
    public StructType(AST.IdNode id) {
        myId = id;
    }
    
    public boolean isStructType() {
        return true;
    }

    public boolean equals(AbstractType t) {
        return t.isStructType();
    }

    public String toString() {
        return myId.name();
    }
}

// **********************************************************************
// StructDefType
// **********************************************************************
public static class StructDefType extends AbstractType {

    public boolean isStructDefType() {
        return true;
    }

    public boolean equals(AbstractType t) {
        return t.isStructDefType();
    }

    public String toString() {
        return "struct";
    }
}

// **********************************************************************
// DoubleType
// **********************************************************************
public static class DoubleType extends AbstractType {

    public boolean isDoubleType() {
        return true;
    }

    public boolean equals(AbstractType t) {
        return t.isDoubleType();
    }

    public String toString() {
        return "double";
    }
}
}