package com.codepath.apps.mysimpletweets;

import android.content.Context;
import android.util.Log;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

/*
 * 
 * This is the object responsible for communicating with a REST API. 
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes: 
 *   https://github.com/fernandezpablo85/scribe-java/tree/master/src/main/java/org/scribe/builder/api
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 * 
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 * 
 */
public class TwitterClient extends OAuthBaseClient {
	public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class; // Changed to use the Twitter APi
	public static final String REST_URL = "https://api.twitter.com/1.1"; // Change this, base API URL
	public static final String REST_CONSUMER_KEY = "MMHIALTNFNP3JesKJzFY9qkh0";       // Changed
	public static final String REST_CONSUMER_SECRET = "tRjnaVEPe9Hd49wEvEn806SVws2Tdsc5rCreli7OplnBLObGsb"; // Changed
	public static final String REST_CALLBACK_URL = "oauth://cpsimpletweets"; // Changed this (here and in manifest)

	public TwitterClient(Context context) {
		super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
	}


	/* 1. Define the endpoint URL with getApiUrl and pass a relative path to the endpoint
	 * 	  i.e getApiUrl("statuses/home_timeline.json");
	 * 2. Define the parameters to pass to the request (query or body)
	 *    i.e RequestParams params = new RequestParams("foo", "bar");
	 * 3. Define the request method and make a call to the client
	 *    i.e client.get(apiUrl, params, handler);
	 *    i.e client.post(apiUrl, params, handler);
	 */



	/*
	GET the tweets
	Endpoint: Home timeline for the user
   			GET statuses/home_timeline
   			Full URL: https://api.twitter.com/1.1/statuses/home_timeline.json
   			params:
   				count=2
   				since_id=1
	 */
	public void getHomeTimeline(AsyncHttpResponseHandler handler) {
		String apiurl = getApiUrl("statuses/home_timeline.json");

		//specify the params
		RequestParams params = new RequestParams();
		params.put("count", 25);
		params.put("since_id", 1);

		//execute the request
		getClient().get(apiurl, params, handler);
		Log.d("DEBUG-HomeTimelineURL", apiurl);
	}

	public void getMentionsTimeline(AsyncHttpResponseHandler handler) {
		String apiurl = getApiUrl("statuses/mentions_timeline.json");

		//specify the params
		RequestParams params = new RequestParams();
		params.put("count", 25);

		//execute the request
		getClient().get(apiurl, params, handler);
		Log.d("DEBUG-MentionsURL", apiurl);

	}

	public void getUserTimeline(String screenName, AsyncHttpResponseHandler handler) {
		String apiurl = getApiUrl("statuses/user_timeline.json");

		//specify the params
		RequestParams params = new RequestParams();
		params.put("count", 25);
		params.put("screen_name", screenName);

		//execute the request
		getClient().get(apiurl, params, handler);
		Log.d("DEBUG-UserTimelineURL", apiurl);

	}

	public void getUserInfo(AsyncHttpResponseHandler handler) {
		String apiurl = getApiUrl("account/verify_credentials.json");

		//execute the request
		getClient().get(apiurl, null, handler);
		Log.d("DEBUG-Account-UserCredentials_URL", apiurl);

	}

	/*
	POST a tweet
	Endpoint: Compose a tweet for the user
   			Full URL: https://api.twitter.com/1.1/
   			params:
   				...
	 */


}