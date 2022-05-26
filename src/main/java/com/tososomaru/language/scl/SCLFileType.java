package com.tososomaru.language.scl;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SCLFileType extends LanguageFileType {

    public static final SCLFileType INSTANCE = new SCLFileType();

    private SCLFileType() {
        super(SCLLanguage.INSTANCE);
    }

    @Override
    public @NotNull String getName() {
        return "SCL File";
    }

    @Override
    public @NotNull String getDescription() {
        return "SCL language file";
    }

    @Override
    public @NotNull String getDefaultExtension() {
        return "scl";
    }

    @Override
    public @Nullable Icon getIcon() {
        return SCLIcons.FILE;
    }
}
