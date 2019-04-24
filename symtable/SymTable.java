package symtable;

import java.util.*;

/**
 * A class for Symbol Table
 */
public class SymTable {

    private List<Map<String,SymInfo>> bindings;
    private boolean isGlobal;

    /**
     * Create a Symbol Table with one empty scope
     */
    public SymTable() {
        bindings = new ArrayList<Map<String,SymInfo>>();
        bindings.add(new HashMap<String,SymInfo>());
        isGlobal = true;
    }

    /**
     * Add a declaration (i.e. a pair [name,sym]) in the inner scope
     */
    public void addDecl(String name, SymInfo sym) throws DuplicateSymException, EmptySymTableException {
        if ( name == null || sym == null )
            throw new NullPointerException();
        if ( bindings.isEmpty() )
            throw new EmptySymTableException();
        Map<String,SymInfo> map = bindings.get(0);
        if ( map.get(name) != null )
            throw new DuplicateSymException();
        sym.setGlobal(isGlobal);
        map.put(name, sym);
    }

    /**
     * Add a new inner scope
     */
    public void addScope() {
        bindings.add(0, new HashMap<String,SymInfo>());
        isGlobal = false;
    }

    /**
     * Lookup for 'name' in the inner scope
     */
    public SymInfo lookupLocal(String name) throws EmptySymTableException {
        if ( bindings.isEmpty() )
            throw new EmptySymTableException();
        return bindings.get(0).get(name);
    }

    /**
     * Lookup for 'name' sequentially in all scopes from inner to outer
     */
    public SymInfo lookupGlobal(String name)  throws EmptySymTableException {
        if ( bindings.isEmpty() )
            throw new EmptySymTableException();
        for ( Map<String,SymInfo> map : bindings )  {
            SymInfo sym = map.get(name);
            if ( sym != null )
                return sym;
        }
        return null;
    }

    /**
     * Remove the inner scope
     */
    public void removeScope() throws EmptySymTableException {
        if ( bindings.isEmpty() )
            throw new EmptySymTableException();
        bindings.remove(0);
    }

    /**
     * Print the Symbol Table on System.out
     */
    public void print() {
        System.out.print("\nSym Table\n");
        for ( Map<String,SymInfo> map : bindings )
            System.out.println(map);
        System.out.println();
    }

    public int setOffset(int o) {
        for ( Map<String,SymInfo> map : bindings )  {
            for ( SymInfo info : map.values() ) {
                if(info instanceof StructInfo) {
                    SymInfo i = ((StructInfo)info).getStructType().info();
                    SymTable structSymTable = ((StructDefInfo)i).getSymTable();
                    o = structSymTable.setOffset(o);
                } else {
                    info.setOffset(o);
                    o -= 4;
                }
            }
        }
        return o;
    }
}
