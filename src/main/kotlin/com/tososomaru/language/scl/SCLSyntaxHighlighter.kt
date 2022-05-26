package com.tososomaru.language.scl

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.tososomaru.language.scl.psi.SCLTypes

class SCLSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return SCLLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> =
         when(tokenType) {
            SCLTypes.SEPARATOR -> SEPARATOR_KEYS
            SCLTypes.KEY -> KEY_KEYS
            SCLTypes.VALUE -> VALUE_KEYS
            SCLTypes.COMMENT -> COMMENT_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }


    companion object {
        private val SEPARATOR = TextAttributesKey.createTextAttributesKey("SIMPLE_SEPARATOR",
                DefaultLanguageHighlighterColors.OPERATION_SIGN)
        private val KEY = TextAttributesKey.createTextAttributesKey("SIMPLE_KEY",
                DefaultLanguageHighlighterColors.KEYWORD)
        private val VALUE = TextAttributesKey.createTextAttributesKey("SIMPLE_VALUE",
                DefaultLanguageHighlighterColors.STRING)
        private val COMMENT = TextAttributesKey.createTextAttributesKey("SIMPLE_COMMENT",
                DefaultLanguageHighlighterColors.LINE_COMMENT)
        private val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("SIMPLE_BAD_CHARACTER",
                HighlighterColors.BAD_CHARACTER)

        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val SEPARATOR_KEYS = arrayOf(SEPARATOR)
        private val KEY_KEYS = arrayOf(KEY)
        private val VALUE_KEYS = arrayOf(VALUE)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = TextAttributesKey.EMPTY_ARRAY;
    }
}