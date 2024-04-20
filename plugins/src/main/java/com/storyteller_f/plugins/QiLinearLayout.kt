package com.storyteller_f.plugins

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class QiLinearLayout @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attributeSet, defStyleAttr) {
    @Suppress("MemberVisibilityCanBePrivate")
    var forceDirection: Int = UNSET
        set(value) {
            field = value
            requestLayout()
        }

    override fun getLayoutDirection() =
        if (forceDirection == UNSET) super.getLayoutDirection() else forceDirection

    companion object {
        const val UNSET = -2
    }
}