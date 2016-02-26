package com.example.theblurosx.youtubeproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheBlurOSX on 2/26/16.
 */
public class ClassYoutube
{
    private String kind;

    public String getKind()
    {
        return kind;
    }

    private String etag;

    public String getEtag()
    {
        return etag;
    }

    private String nextPageToken;

    public String getNextPageToken()
    {
        return nextPageToken;
    }

    private String regionCode;

    public String getRegionCode()
    {
        return regionCode;
    }

    private PageInfo pageInfo;

    public PageInfo getPageInfo()
    {
        return pageInfo;
    }


    private ArrayList<Items> items;

    public ArrayList<Items> getItems()
    {
        return items;
    }



}
