package com.ryg.chapter_12.jiexiSecTest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;

import com.ryg.chapter_12.R;

import java.util.ArrayList;

/**
 * Created by liumeng on 2017/4/18 on 16:12
 */

public class MyAdapter  extends BaseAdapter implements SectionIndexer {
    private   ArrayList<String> stringArray;
    private Context           context;
    public MyAdapter(Context _context, ArrayList<String> arr) {
        stringArray = arr;
        context = _context;
    }
    @Override
    public int getCount() {
        return stringArray.size();
    }

    @Override
    public Object getItem(int position) {
        return stringArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflate = ((Activity) context).getLayoutInflater();
        View view = (View) inflate.inflate(R.layout.listview_row, null);
        LinearLayout header = (LinearLayout) view.findViewById(R.id.section);
        String label = stringArray.get(position);
        return null;
    }

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
