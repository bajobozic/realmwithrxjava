package com.example.bajob.movieshatch;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by bajob on 2/12/2017.
 */
public abstract class BaseActivity extends AppCompatActivity {
    AlertDialog errorDialog;

    void showErrorDialog(final String message, final DialogInterface.OnClickListener onClickListener) {
        if (errorDialog != null) {
            errorDialog.cancel();
            errorDialog=null;
        }
        errorDialog =new AlertDialog.Builder(BaseActivity.this)
                .setTitle(getResources().getString(R.string.app_name))
                .setMessage(message)
                .setPositiveButton(android.R.string.ok,onClickListener)
                .create();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeRealmInstance();
    }

    protected abstract void closeRealmInstance();
}
