package com.codepath.apps.mysimpletweets;

//import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.mysimpletweets.fragments.HomeTimelineFragment;
import com.codepath.apps.mysimpletweets.fragments.MentionsTimelineFragment;

public class TimelineActivity extends ActionBarActivity {

    /*
        //show toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.My_Tweets_toolbar);
        setSupportActionBar(toolbar);
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        //get the viewpager
        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);

        //set the viewpager adapter for the pager
        vpPager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager()));

        //find the pager sliding tabsrip
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);

        //attach the pager tabstrip to the viewpager
        tabStrip.setViewPager(vpPager);

    }

    //return the order of the fragments in the ViewPager
    public class TweetsPagerAdapter extends FragmentPagerAdapter {

        private String tabTitles[] = { "Home", "Mentions" };

        //how the adapter gets the manager that it uses to insert or remove fragments from activity
        public TweetsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //controls the order of fragments within the pager
        @Override
        public Fragment getItem(int position) {
            if ( position == 0) {
                return new HomeTimelineFragment();
            } else if (position == 1) {
                return new MentionsTimelineFragment();
            } else {
                return null;
            }
        }

        //returns the tab title at the top
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        //defines how many fragments there are to swipe between
        @Override
        public int getCount() {
            return tabTitles.length;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void onProfileView(MenuItem mi) {
        // Launch the profileView activity
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);

    }
}
