package com.example.theblurosx.youtubeproject;

import android.provider.MediaStore;

import java.util.List;

/**
 * Created by TheBlurOSX on 2/26/16.
 */
public class Snippet
{
    private String publishedAt;

    public String getPublishedAt()
    {
        return publishedAt;
    }

    private String channelId;

    public String getChannelId()
    {
        return channelId;
    }

    private String title;

    public String getTitle()
    {
        return title;
    }

    private String description;

    public String getDescription()
    {
        return description;
    }

    private Thumbnails thumbnails;

    public Thumbnails getThumbnails()
    {
        return thumbnails;
    }

    private String channelTitle;

    public String getChTitle()
    {
        return channelTitle;
    }

    private String liveBroadcastContent;

    public String getLiveBroadcast()
    {
        return liveBroadcastContent;
    }

}
