package com.ryg.chapter_12.SelectionIndexerTest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.ryg.chapter_12.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter implements SectionIndexer {
    private ArrayList<String> stringArray;
    private Context           context;
    public MyAdapter(Context _context, ArrayList<String> arr) {  
        stringArray = arr;  
        context = _context;  
    }  
    public int getCount() {  
        return stringArray.size();  
    }  
    public Object getItem(int arg0) {  
        return stringArray.get(arg0);  
    }  
    public long getItemId(int arg0) {  
        return 0;  
    }  
    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater inflate = ((Activity) context).getLayoutInflater();
        View view = (View) inflate.inflate(R.layout.listview_row, null); //布局
        LinearLayout header = (LinearLayout) view.findViewById(R.id.section);
        String label = stringArray.get(position);   //获取数据
        char firstChar = label.toUpperCase().charAt(0);  //变大写
        if (position == 0) {
            setSection(header, label);  //如果是第一项展示字母
        } else {  
            String preLabel = stringArray.get(position - 1);  //获取上一个字母
            char preFirstChar = preLabel.toUpperCase().charAt(0);  //变大写
            if (firstChar != preFirstChar) {   //如何截取的首字母和上一项的首字母不同
                setSection(header, label);  //展示字母
            } else {  
                header.setVisibility(View.GONE);  //相同就不展示
            }  
        }  
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(label);  
        return view;  
    }
    //截取首字母展示
    private void setSection(LinearLayout header, String label) {  
        TextView text = new TextView(context);
        header.setBackgroundColor(0xffaabbcc);  
        text.setTextColor(Color.WHITE);
        text.setText(label.substring(0, 1).toUpperCase());  
        text.setTextSize(20);  
        text.setPadding(5, 0, 0, 0);  
        text.setGravity(Gravity.CENTER_VERTICAL);
        header.addView(text);  
    }
    // Given the index of a section within the array of section objects, returns
//     the starting position of that section within the adapter.
    //在这个地方section定义为char类型更容易理解
    public int getPositionForSection(int section) {  
        if (section == 35) {  
            return 0;  
        }  //不知道什么意思,感觉没必要做这个判断
        //遍历数据,返回首字母第一次出现的位置
        for (int i = 0; i < stringArray.size(); i++) {  
            String l = stringArray.get(i);  
            char firstChar = l.toUpperCase().charAt(0);  
            if (firstChar == section) {  
                return i;  
            }  
        }  
        return -1;  
    }  
    public int getSectionForPosition(int arg0) {  
        return 0;  
    }  
    public Object[] getSections() {  
        return null;  
    }  
}  