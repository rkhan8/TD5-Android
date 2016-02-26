package com.example.theblurosx.youtubeproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheBlurOSX on 2/26/16.
 */
public class YoutubeAdapter extends ArrayAdapter<Items> {

    public YoutubeAdapter(Context context, ArrayList<Items> items)
    {
        super(context, 0, items);
    }

    static class ViewHolder {
        public TextView Title;
        public ImageView image;
        public TextView Description;
    }


    @Override
    public View getView(final int position, View view, final ViewGroup parent) {

        final Items item = getItem(position);

        final ViewHolder viewHolder;


        if (view == null)
        {
            view = LayoutInflater.from(getContext()).inflate(R.layout.contrat_layout, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.Title = (TextView) view.findViewById(R.id.Title);
            viewHolder.image = (ImageView) view.findViewById(R.id.imageView);
            viewHolder.Description = (TextView) view.findViewById(R.id.descriptionText);
            view.setTag(viewHolder); //get position
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag(); //No needed
        }


        viewHolder.Title.setText(item.getSnippet().getTitle());

        new ImageDownloader(viewHolder.image).execute(item.getSnippet().getThumbnails().getMedium().getUrl());

        viewHolder.Description.setText(item.getSnippet().getDescription());


        final String videoId = "id"; // item.getId().toString();
        final String title = "title";
        final String author = "author";
        final String description = "descrip";
        final String publication = "publ";


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();
                Intent intent = new Intent(v.getContext().getApplicationContext(), YouTubePlayerActivity.class);
                intent.putExtra(videoId, item.getId().getVideoId());
                intent.putExtra(title, item.getSnippet().getTitle());
                intent.putExtra(author, item.getSnippet().getChTitle());
                intent.putExtra(description, item.getSnippet().getDescription());
                intent.putExtra(publication, item.getSnippet().getPublishedAt());

                context.startActivity(intent);


            }
        });


        return view;

    }

    private class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public ImageDownloader(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            Bitmap mIcon = null;
            try {
                InputStream in = new java.net.URL(url).openStream();
                mIcon = BitmapFactory.decodeStream(in);
            } catch (Exception e) {

            }
            return mIcon;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}
