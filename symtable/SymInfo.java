package symtable;

import java.util.*;

/**
 * The SymInfo class defines a Symbol Table entry. 
 * Each SymInfo contains a type (a Type object).
 */
public class SymInfo {
    
    private Type.AbstractType type;
    private boolean global;
    private boolean param = false;
    private int offset;

    /**
     * Create a SymInfo object of type 'type'
     */
    public SymInfo(Type.AbstractType type) {
        this.type = type;
        offset = 0;
    }

    /**
     * Return the type of the SymInfo
     */
    public Type.AbstractType getType() {
        return type;
    }

    /**
     * Return a String representation of the SymInfo
     * (for debuggung purpose)
     */
    public String toString() {
        return type.toString();
    }

    public void setGlobal(boolean g) {
        global = g;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setOffset(int o) {
        offset = o;
    }

    public int getOffset() {
        return offset;
    }

    public void setParam(boolean p) {
        param = p;
    }

    public boolean isParam() {
        return param;
    }
}
