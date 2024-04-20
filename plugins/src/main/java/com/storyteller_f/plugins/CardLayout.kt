package com.storyteller_f.plugins

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children

class CardLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        assert(childCount == 1)
        val parentWidth = MeasureSpec.getSize(widthMeasureSpec)
        val child = children.first()
        val childWidth = child.layoutParams.width
        val childHeight = child.layoutParams.height
        child.measure(
            MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY)
        )
        val parentHeight = (childHeight.toFloat() * parentWidth / childWidth).toInt()
        child.setScale(parentWidth.toFloat() / childWidth)
        child.translationX = (parentWidth - childWidth).toFloat() / 2
        child.translationY = (parentHeight - childHeight).toFloat() / 2
        setMeasuredDimension(parentWidth, parentHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        children.first().let {
            it.layout(0, 0, it.measuredWidth, it.measuredHeight)
        }
    }
}

fun View.setScale(fl: Float) {
    scaleX = fl
    scaleY = fl
}
