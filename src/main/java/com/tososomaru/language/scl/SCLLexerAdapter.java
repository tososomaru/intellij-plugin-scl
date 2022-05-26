package com.tososomaru.language.scl;

import com.intellij.lexer.FlexAdapter;

public class SCLLexerAdapter extends FlexAdapter {
    public SCLLexerAdapter() {
        super(new SCLLexer(null));
    }
}
