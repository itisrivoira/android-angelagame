package com.example.angelagamefinale;

import android.view.View;
import android.widget.ScrollView;

public class ScrollListener implements ScrollView.OnScrollChangeListener{

    private ScrollView scroll1;
    private ScrollView scroll2;
    private ScrollView scroll3;

    ScrollListener(ScrollView scroll1, ScrollView scroll2, ScrollView scroll3) {
        this.scroll1 = scroll1;
        this.scroll2 = scroll2;
        this.scroll3 = scroll3;
    }

    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        switch(v.getId()){
            case R.id.scroll1:
                scroll1.setOverScrollMode(View.OVER_SCROLL_NEVER);
                scroll2.scrollTo(scrollX,scrollY);
                scroll3.scrollTo(scrollX,scrollY);
                break;
            case R.id.scroll2:
                scroll2.setOverScrollMode(View.OVER_SCROLL_NEVER);
                scroll1.scrollTo(scrollX,scrollY);
                scroll3.scrollTo(scrollX,scrollY);
                break;
            case R.id.scroll3:
                scroll3.setOverScrollMode(View.OVER_SCROLL_NEVER);
                scroll2.scrollTo(scrollX,scrollY);
                scroll1.scrollTo(scrollX,scrollY);
                break;
        }
    }
}
