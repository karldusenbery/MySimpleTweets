package com.codepath.apps.mysimpletweets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.mysimpletweets.models.Tweet;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jdusenbery on 2/22/16.
 */
//taking the Tweet objects and turning them into Views displayed in the list
public class TweetsArrayAdapter extends ArrayAdapter<Tweet>{

    public TweetsArrayAdapter(Context context, List<Tweet> tweets) {
        super(context, android.R.layout.simple_list_item_1,  tweets);
    }

    //override and setup simple_list_item_1 template for a custom template


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Get the tweet
        Tweet tweet = getItem(position);

        // 2. Find or inflate the template
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tweet, parent, false);
        }

        // 3. Find the subviews to fill with data in the template
        ImageView ivProfileImage = (ImageView) convertView.findViewById(R.id.ivProfileImage);
        TextView tvUserName = (TextView) convertView.findViewById(R.id.tvUserName);
        TextView tvBody = (TextView) convertView.findViewById(R.id.tvBody);

        // 4. populate data into the subviews
        tvUserName.setText(R.string.blank_text); //clear out the old text for a recycled view
        tvUserName.setText(tweet.getUser().getScreenName());

        tvBody.setText(R.string.blank_text); //clear out the old text for a recycled view
        tvBody.setText(tweet.getBody());

        ivProfileImage.setImageResource(android.R.color.transparent);//clear out the old image for a recycled view
        Picasso.with(getContext()).load(tweet.getUser().getProfileImageUrl()).into(ivProfileImage);

        // 5. return the view to be inserted into the list
        return convertView;
    }
}
