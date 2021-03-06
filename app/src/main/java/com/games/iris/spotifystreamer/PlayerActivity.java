package com.games.iris.spotifystreamer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.games.iris.spotifystreamer.Util.Constants;
import com.games.iris.spotifystreamer.models.TrackP;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        if (toolbar != null)
//        {
//            boolean isTablet = getIntent().getBooleanExtra(Constants.EXTRA_IS_TABLET, false);
//            if (isTablet) {
//                setSupportActionBar(toolbar);
//            }
//            else {
//                toolbar.setVisibility(View.GONE);
//            }
//        }
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null)
        {
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            int index = getIntent().getIntExtra(Constants.EXTRA_TRACK_INDEX, 0);
            ArrayList<TrackP> tracksList = getIntent().getParcelableArrayListExtra(Constants.EXTRA_TRACKS_LIST_PARCELABLE);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                                                               PlayerFragment.newInstance(index, tracksList)).commit();
        }

    }

    //    @Override
    //    public boolean onCreateOptionsMenu(Menu menu) {
    //        // Inflate the menu; this adds items to the action bar if it is present.
    //        getMenuInflater().inflate(R.menu.menu_player, menu);
    //
    //        return true;
    //    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
