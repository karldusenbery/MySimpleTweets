package com.codepath.apps.mysimpletweets.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.codepath.apps.mysimpletweets.TwitterApp;
import com.codepath.apps.mysimpletweets.TwitterClient;
import com.codepath.apps.mysimpletweets.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by jdusenbery on 2/23/16.
 */
public class HomeTimelineFragment extends TweetsListFragment {

    private TwitterClient client;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get the client
        client = TwitterApp.getRestClient(); //singleton client

        //populate the TimeLine
        populateTimeline();
    }

    //Send an API request to get the timeline JSON
    //Fill the ListView by creating the tweet objects from the JSON
    private void populateTimeline() {
        client.getHomeTimeline(new JsonHttpResponseHandler() {
            // SUCCESS
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray json) {
                Log.d("DEBUG-Success", json.toString());
                //JSON comes in HERE
                //deserialize the JSON
                //create models and add them to the adapter
                //load the model data into the ListView
                addAll(Tweet.fromJSONArray(json));
                //Log.d("DEBUG", aTweets.toString());

            }


            // FAILURE
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("DEBUG-Failure", errorResponse.toString());
            }
        });
    }

}
