package com.example.serenazhu.upcomingguide;


//Class of the information on upcoming guides
//Used to parse data retrieved from server to Java objects


//Commented with examples of the incoming data

public class Guide {

    Object startDate;  //Apr 04, 2018
    Object objType;  //guide
    Object endDate;  //Apr 07,2018
    Object name;  //name of the guide: 2018 ACUI CUPSI
    boolean loginRequired;  //false
    Object url;  // /guide/113637
    Object venue; // {} -- none had actual values for city or state
    Object icon; // a url to find the icon

    //Getter functions
    public Object getStartDate() {
        return startDate;
    }

    public Object getObjType() {
        return objType;
    }

    public Object getEndDate() {
        return endDate;
    }

    public Object getName() {
        return name;
    }

    public boolean getLoginRequired() {
        return loginRequired;
    }

    public Object getUrl() {
        return url;
    }

    public Object getVenue() {
        return venue;
    }

    public Object getIcon() {
        return icon;
    }
}
