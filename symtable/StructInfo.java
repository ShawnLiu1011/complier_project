package symtable;

import ast.*;

/**
 * The StructInfo class is a subclass of the Sym class just for variables 
 * declared to be a struct type. 
 */
public class StructInfo extends SymInfo {
    // new fields
    private AST.IdNode structType;  // name of the struct type
    
    public StructInfo(AST.IdNode id) {
        super(new Type.StructType(id));
        structType = id;
    }

    public AST.IdNode getStructType() {
        return structType;
    }    
}
