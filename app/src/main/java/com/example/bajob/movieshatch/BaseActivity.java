package com.example.bajob.movieshatch;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by bajob on 2/12/2017.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeRealmInstance();
    }

    protected abstract void closeRealmInstance();
}
