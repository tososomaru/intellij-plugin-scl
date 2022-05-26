package com.tososomaru.language.scl.psi;

import com.intellij.psi.tree.IElementType;
import com.tososomaru.language.scl.SCLLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SCLElementType extends IElementType {

    public SCLElementType(@NotNull @NonNls String debugName) {
        super(debugName, SCLLanguage.INSTANCE);
    }
}
