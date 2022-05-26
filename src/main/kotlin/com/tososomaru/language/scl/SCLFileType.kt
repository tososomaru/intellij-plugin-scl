package com.tososomaru.language.scl

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object SCLFileType : LanguageFileType(SCLLanguage) {

    override fun getName() = "SCL File"

    override fun getDescription() = "SCL language file"

    override fun getDefaultExtension() = "scl"

    override fun getIcon(): Icon = SCLIcons.FILE
}