package com.bignerdranch.android.constraintlayouttest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

public class ForecastActivity extends SignleFragmentActivity implements ForecastFragment.Callbacks {

    @Override
    protected Fragment createFragemt() {
        return new ForecastFragment();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setElevation(0f);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onItemSelected(Uri dateUri) {

        if (findViewById(R.id.detail_fragment_container) == null) {

            Intent intent = DetailActivity.newIntent(this, dateUri);
            startActivity(intent);
        } else {

            Fragment fragment = DetailFragment.newInstance(dateUri);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
