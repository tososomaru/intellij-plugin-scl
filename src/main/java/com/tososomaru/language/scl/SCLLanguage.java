package com.tososomaru.language.scl;

import com.intellij.lang.Language;
public class SCLLanguage extends Language {

    public static final SCLLanguage INSTANCE = new SCLLanguage();

    private SCLLanguage() {
        super("SCL");
    }
}
