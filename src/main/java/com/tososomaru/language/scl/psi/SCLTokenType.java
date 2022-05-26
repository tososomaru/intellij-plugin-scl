package com.tososomaru.language.scl.psi;

import com.intellij.psi.tree.IElementType;
import com.tososomaru.language.scl.SCLLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SCLTokenType extends IElementType {
    
    public SCLTokenType(@NonNls @NotNull String debugName) {
        super(debugName, SCLLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "SCLTokenType." + super.toString();
    }
}
