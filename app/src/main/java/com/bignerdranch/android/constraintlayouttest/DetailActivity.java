package com.bignerdranch.android.constraintlayouttest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class DetailActivity extends SignleFragmentActivity {

    private static final String EXTRA_DATE_URI = "com.bignerdranch.android.constraintlayouttest.date_uri";

    @Override
    protected Fragment createFragemt() {
        Uri dateUri = getIntent().getParcelableExtra(EXTRA_DATE_URI);
        return DetailFragment.newInstance(dateUri);
    }

    public static Intent newIntent(Context packageContext, Uri dateUri) {
        Intent intent = new Intent(packageContext, DetailActivity.class);
        intent.putExtra(EXTRA_DATE_URI, dateUri);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }




}
