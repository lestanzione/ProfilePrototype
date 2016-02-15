package com.stanzione.profileprototype;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by lstanzione on 2/15/2016.
 */
public class FriendDecorationColumns extends RecyclerView.ItemDecoration {

    private int sizeGridSpacingPx;

    public FriendDecorationColumns(int sizeGridSpacingPx) {
        this.sizeGridSpacingPx = sizeGridSpacingPx;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        outRect.top = sizeGridSpacingPx;
        outRect.bottom = sizeGridSpacingPx;
        outRect.left = sizeGridSpacingPx;
        outRect.right = sizeGridSpacingPx;

    }

}
