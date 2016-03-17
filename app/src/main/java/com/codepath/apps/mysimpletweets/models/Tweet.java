package com.codepath.apps.mysimpletweets.models;

/*
example JSON object returned in the JSONArray of tweets
{
      "created_at":"Mon Feb 22 16:24:08 +0000 2016",
      "id":701804678716252160,
      "id_str":"701804678716252160",
      "text":"RT @DashStarWars: I hope this song brightens your morning as it has mine https:\/\/t.co\/Iy40v4OGjQ  #Chiptune #HappyMondayMorning https:\/\/t.c…",
      "source":"<a href=\"http:\/\/twitter.com\/_chiptune\" rel=\"nofollow\">_chiptune<\/a>",
      "truncated":false,
      "in_reply_to_status_id":null,
      "in_reply_to_status_id_str":null,
      "in_reply_to_user_id":null,
      "in_reply_to_user_id_str":null,
      "in_reply_to_screen_name":null,
      "user":{
         "id":1417474730,
         "id_str":"1417474730",
         "name":"Chiptune",
         "screen_name":"_chiptune",
         "location":"In the cupboard.",
         "description":"In association with @microCollective. Made by @_2xAA - Powered by Pi.",
         "url":"http:\/\/t.co\/TiD503Ea2g",
         "entities":{
            "url":{
               "urls":[
                  {
                     "url":"http:\/\/t.co\/TiD503Ea2g",
                     "expanded_url":"http:\/\/howhotismypi.com\/",
                     "display_url":"howhotismypi.com",
                     "indices":[
                        0,
                        22
                     ]
                  }
               ]
            },
            "description":{
               "urls":[

               ]
            }
         },
         "protected":false,
         "followers_count":885,
         "friends_count":1,
         "listed_count":314,
         "created_at":"Fri May 10 07:49:25 +0000 2013",
         "favourites_count":0,
         "utc_offset":null,
         "time_zone":null,
         "geo_enabled":false,
         "verified":false,
         "statuses_count":26679,
         "lang":"en",
         "contributors_enabled":false,
         "is_translator":false,
         "is_translation_enabled":false,
         "profile_background_color":"4B3683",
         "profile_background_image_url":"http:\/\/pbs.twimg.com\/profile_background_images\/864769739\/c47f65e5a8760a4cdcfdba864d5e1007.gif",
         "profile_background_image_url_https":"https:\/\/pbs.twimg.com\/profile_background_images\/864769739\/c47f65e5a8760a4cdcfdba864d5e1007.gif",
         "profile_background_tile":false,
         "profile_image_url":"http:\/\/pbs.twimg.com\/profile_images\/3639194543\/d48fbc4b50abb3ef688ec6f8e9cbeb59_normal.png",
         "profile_image_url_https":"https:\/\/pbs.twimg.com\/profile_images\/3639194543\/d48fbc4b50abb3ef688ec6f8e9cbeb59_normal.png",
         "profile_link_color":"024EAB",
         "profile_sidebar_border_color":"FFFFFF",
         "profile_sidebar_fill_color":"DDEEF6",
         "profile_text_color":"333333",
         "profile_use_background_image":true,
         "has_extended_profile":false,
         "default_profile":false,
         "default_profile_image":false,
         "following":true,
         "follow_request_sent":false,
         "notifications":false
      }
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Tweet {


    //list out the attributes
    private String body;
    private long uid; //unique database id for the tweet
    private User user; //store embedded User object
    private String createdAt;

    public String getBody() {

        return body;
    }

    public long getUid() {

        return uid;
    }

    public User getUser() {

        return user;
    }

    public String getCreatedAt() {

        return createdAt;
    }

    //deserialize the JSON and turn it into a Java object
    // Tweet.fromJSON("{...}") => returns a Tweet object
    public static Tweet fromJSON(JSONObject jsonObject){
        Tweet tweet = new Tweet(); //initialize a new Tweet object
        //extract the values form the JSON, then store them

        //list out things from the JSON we want to store
        try {
            tweet.body = jsonObject.getString("text");
            tweet.uid = jsonObject.getLong("id");
            tweet.createdAt = jsonObject.getString("created_at");
            tweet.user = User.fromJSON(jsonObject.getJSONObject("user")); //the key is "user" from the JSON object
        } catch (JSONException e) {
            e.printStackTrace();
        }


        // return the Tweet object created
        return tweet;
    }


    //Tweet.fromJSONArray([{...}, {...}, {...}]) => List<Tweet>
    public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray){
        ArrayList<Tweet> tweets = new ArrayList<>();

        //iterate through the JSONArray and create tweets
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject tweetJson = jsonArray.getJSONObject(i);
                Tweet tweet = Tweet.fromJSON(tweetJson);
                if (tweet != null) {
                    tweets.add(tweet);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                continue;
            }
        }


        //return the finished list
        return tweets;
    }

}
