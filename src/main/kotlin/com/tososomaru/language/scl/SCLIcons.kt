package com.tososomaru.language.scl

import com.intellij.openapi.util.IconLoader
import org.apache.commons.lang.NotImplementedException

class SCLIcons private constructor() {
    init {
        throw NotImplementedException()
    }

    companion object {
        val FILE = IconLoader.getIcon("/icons/experiment.png", SCLIcons::class.java)
    }
}