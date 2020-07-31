package com.example.eyedemo.ui.common.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eyedemo.extension.dp2px

class GridListItemDecoration(private val spanCount: Int = 2, private val space: Float = 2f) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val count = parent.adapter?.itemCount
        val spanIndex = (view.layoutParams as GridLayoutManager.LayoutParams).spanIndex
        val lastRowFirstItemPostion = count?.minus(spanCount)
        val space = dp2px(space)

        when {
            position < spanCount -> {
                outRect.bottom = space
            }
            position < lastRowFirstItemPostion!! -> {
                outRect.top = space
                outRect.bottom = space
            }
            else -> {
                outRect.top = space
            }
        }
        when (spanIndex) {
            0 -> {
                outRect.right = space
            }
            spanCount - 1 -> {
                outRect.left = space
            }
            else -> {
                outRect.left = space
                outRect.right = space
            }
        }
    }
}