package com.tososomaru.language.scl;

import com.intellij.lexer.FlexAdapter;

public class SCLFlexAdapter extends FlexAdapter {
    public SCLFlexAdapter() {
        super(new SCLLexer(null));
    }
}
