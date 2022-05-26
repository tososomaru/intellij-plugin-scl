package com.tososomaru.language.scl

import com.intellij.lexer.FlexAdapter

class SCLLexerAdapter : FlexAdapter(SCLLexer(null))