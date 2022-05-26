package com.tososomaru.language.scl.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.tososomaru.language.scl.SCLFileType;
import com.tososomaru.language.scl.SCLLanguage;
import org.jetbrains.annotations.NotNull;

public class SCLFile extends PsiFileBase {
    public SCLFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, SCLLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return SCLFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "SCL File";
    }
}
