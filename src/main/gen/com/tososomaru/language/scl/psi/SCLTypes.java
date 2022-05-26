// This is a generated file. Not intended for manual editing.
package com.tososomaru.language.scl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.tososomaru.language.scl.impl.*;

public interface SCLTypes {

  IElementType PROPERTY = new SCLElementType("PROPERTY");

  IElementType COMMENT = new SCLTokenType("COMMENT");
  IElementType CRLF = new SCLTokenType("CRLF");
  IElementType KEY = new SCLTokenType("KEY");
  IElementType SEPARATOR = new SCLTokenType("SEPARATOR");
  IElementType VALUE = new SCLTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new SCLPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
