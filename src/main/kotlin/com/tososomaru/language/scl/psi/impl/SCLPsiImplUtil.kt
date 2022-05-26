package com.tososomaru.language.scl.psi.impl

import com.tososomaru.language.scl.psi.SCLProperty
import com.tososomaru.language.scl.psi.SCLTypes

object SCLPsiImplUtil {

    @JvmStatic
    fun getKey(element: SCLProperty): String? {
        val keyNode = element.node.findChildByType(SCLTypes.KEY)
        return keyNode?.text?.replace("\\\\ ", " ")
    }

    @JvmStatic
    fun getValue(element: SCLProperty): String? {
        return element.node.findChildByType(SCLTypes.VALUE)?.text
    }
}