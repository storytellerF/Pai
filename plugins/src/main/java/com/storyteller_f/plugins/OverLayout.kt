package com.storyteller_f.plugins

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.view.children

class OverLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = MeasureSpec.getSize(widthMeasureSpec)
        children.forEach {
            val layoutParams = it.layoutParams
            val widthSpec =
                if (layoutParams.width == LayoutParams.MATCH_PARENT)
                    MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY)
                else
                    MeasureSpec.UNSPECIFIED
            val heightSpec =
                if (layoutParams.height == LayoutParams.MATCH_PARENT)
                    MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY)
                else
                    MeasureSpec.UNSPECIFIED
            it.measure(widthSpec, heightSpec)
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        children.forEach {
            it.layout(0, 0, it.measuredWidth, it.measuredHeight)
        }
    }
}