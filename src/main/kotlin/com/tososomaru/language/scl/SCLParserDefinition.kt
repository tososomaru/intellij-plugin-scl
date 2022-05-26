package com.tososomaru.language.scl

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.tososomaru.language.scl.parser.SCLParser
import com.tososomaru.language.scl.psi.SCLFile
import com.tososomaru.language.scl.psi.SCLTypes

class SCLParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = SCLLexerAdapter()

    override fun createParser(project: Project): PsiParser = SCLParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = COMMENTS

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode): PsiElement = SCLTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = SCLFile(viewProvider)

    override fun getWhitespaceTokens(): TokenSet = WHITE_SPACES

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements {
        return SpaceRequirements.MAY
    }

    companion object {
        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        val COMMENTS = TokenSet.create(SCLTypes.COMMENT)
        val FILE = IFileElementType(SCLLanguage)
    }
}