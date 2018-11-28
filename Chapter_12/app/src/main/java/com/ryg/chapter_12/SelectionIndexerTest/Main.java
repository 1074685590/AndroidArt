package com.ryg.chapter_12.SelectionIndexerTest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.ryg.chapter_12.R;

import java.util.ArrayList;

public class Main extends Activity {
    /** Called when the activity is first created. */  
    @Override  
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);
        ListView list = (ListView) findViewById(R.id.myListView);
        ArrayList<String> stringList = InitListViewData();
        MyAdapter adapter = new MyAdapter(this, stringList);  
        list.setAdapter(adapter);  
        SideBar indexBar = (SideBar) findViewById(R.id.sideBar);  
        indexBar.setListView(list);  
    }  
    private ArrayList<String> InitListViewData() {  
        ArrayList<String> stringList = new ArrayList<String>();  
        stringList.add("aback");  
        stringList.add("abash");  
        stringList.add("abbey");  
        stringList.add("abhor");  
        stringList.add("abide");  
        stringList.add("abuse");  
        stringList.add("candidate");  
        stringList.add("capture");  
        stringList.add("careful");  
        stringList.add("catch");  
        stringList.add("cause");  
        stringList.add("celebrate");  
        stringList.add("forever");  
        stringList.add("fable");  
        stringList.add("fidelity");  
        stringList.add("fox");  
        stringList.add("funny");  
        stringList.add("fail");  
        stringList.add("jail");  
        stringList.add("jade");  
        stringList.add("jailor");  
        stringList.add("january");  
        stringList.add("jasmine");  
        stringList.add("jazz");  
        stringList.add("zero");  
        stringList.add("zoo");  
        stringList.add("zeus");  
        stringList.add("zebra");  
        stringList.add("zest");  
        stringList.add("zing");  
        return stringList;  
    }  
}