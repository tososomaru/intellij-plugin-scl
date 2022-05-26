// This is a generated file. Not intended for manual editing.
package com.tososomaru.language.scl.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.tososomaru.language.scl.psi.SCLTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.tososomaru.language.scl.psi.*;

public class SCLPropertyImpl extends ASTWrapperPsiElement implements SCLProperty {

  public SCLPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SCLVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SCLVisitor) accept((SCLVisitor)visitor);
    else super.accept(visitor);
  }

}
