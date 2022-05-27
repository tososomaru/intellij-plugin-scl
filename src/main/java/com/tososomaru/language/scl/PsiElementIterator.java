package com.tososomaru.language.scl;

import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiWhiteSpace;

import java.util.Iterator;
import java.util.NoSuchElementException;

class PsiElementIterator implements Iterator<PsiElement> {

    private final PsiElement element;

    public PsiElementIterator(PsiElement element) {
        this.element = element;
    }

    @Override
    public boolean hasNext() {
        return (element instanceof PsiComment || element instanceof PsiWhiteSpace);
    }

    @Override
    public PsiElement next() {

        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return element.getPrevSibling();
    }
}
