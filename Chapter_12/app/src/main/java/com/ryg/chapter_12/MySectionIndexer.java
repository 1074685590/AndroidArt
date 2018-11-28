package com.ryg.chapter_12;

import android.widget.SectionIndexer;

/**
 * Created by liumeng on 2017/4/18 on 13:39
 */

public class MySectionIndexer implements SectionIndexer {
    //获取被选中的对象
    @Override
    public Object[] getSections() {
        return new Object[0];
    }


    @Override
    public int getPositionForSection(int sectionIndex) {
        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }
}
