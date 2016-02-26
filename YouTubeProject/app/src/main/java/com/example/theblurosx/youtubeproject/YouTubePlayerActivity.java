package com.example.theblurosx.youtubeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import org.w3c.dom.Text;

public class YouTubePlayerActivity extends YouTubeFailureRecoveryActivity {

    private String id;
    private String title;
    private String author;
    private String description;
    private String publication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_player);

        YouTubePlayerFragment youTubePlayerFragment = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
        youTubePlayerFragment.initialize("AIzaSyBQzncSLAoTqRXQHh4jVcKSYPI4Xd41zbY", this);

        Bundle extra = getIntent().getExtras();
        if(extra != null)
        {
            id = extra.getString("id");
            title = extra.getString("title");
            author = extra.getString("author");
            description = extra.getString("descrip");
            publication = extra.getString("publ");
        }

        TextView Title = (TextView) findViewById(R.id.TitleText);
        TextView Author = (TextView) findViewById(R.id.AuthorText);
        TextView Description = (TextView) findViewById(R.id.DescriptionText);
        TextView Date = (TextView) findViewById(R.id.DateText);


        Title.setText(title);
        Author.setText(author);
        Description.setText(description);
        Date.setText(publication);



    }

    @Override
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b)
    {
        if (!b) {
            youTubePlayer.cueVideo(id);
        }
    }
}
