package com.tososomaru.language.scl.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.tososomaru.language.scl.SCLFileType
import com.tososomaru.language.scl.SCLLanguage

class SCLFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, SCLLanguage) {
    override fun getFileType(): FileType {
        return SCLFileType
    }

    override fun toString(): String {
        return "SCL File"
    }
}