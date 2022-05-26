package com.tososomaru.language.scl.psi

import com.intellij.psi.tree.IElementType
import com.tososomaru.language.scl.SCLLanguage
import org.jetbrains.annotations.NonNls

class SCLElementType(debugName: @NonNls String) : IElementType(debugName, SCLLanguage)