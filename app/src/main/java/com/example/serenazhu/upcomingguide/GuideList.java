package com.example.serenazhu.upcomingguide;

import java.util.List;
import java.util.ArrayList;

//List of the Java object Guide
public class GuideList {

    List<Guide> data;

    public Guide get(int i){
        return data.get(i);
    }

    //public constructor
    public GuideList() {
        data = new ArrayList<Guide>();
    }

}
