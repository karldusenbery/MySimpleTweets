package com.codepath.apps.mysimpletweets.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jdusenbery on 2/22/16.
 */

/*

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
public class User {

    //list the attributes
    private String name;
    private long uid;
    private String screenName;
    private String profileImageUrl;
    private String tagline;
    private int followersCount;
    private int followingCount;

    public String getName() {

        return name;
    }
    public long getUid() {

        return uid;
    }
    public String getScreenName() {

        return screenName;
    }
    public String getProfileImageUrl() {

        return profileImageUrl;
    }

    public String getTagline() {
        return tagline;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public int getFriendsCount() {
        return followingCount;
    }

    //deserialize the "user" JSON => into a User object
    public static User fromJSON(JSONObject json){
        User u = new User();

        //extract and fill values from the JSON
        try {
            u.name = json.getString("name");
            u.uid = json.getLong("id");
            u.screenName = json.getString("screen_name");
            u.profileImageUrl = json.getString("profile_image_url");
            u.tagline = json.getString("description");
            u.followersCount = json.getInt("followers_count");

            u.followingCount = json.getInt("friends_count");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        //return a user
        return u;
    }

}
