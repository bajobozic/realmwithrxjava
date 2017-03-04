package com.example.bajob.movieshatch;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by bajob on 2/12/2017.
 */
public abstract class BaseActivity extends AppCompatActivity {
    AlertDialog errorDialog;

    void showErrorDialog(final Throwable throwable, final DialogInterface.OnClickListener onClickListener) {
        if (errorDialog != null) {
            errorDialog.cancel();
            errorDialog=null;
        }
        errorDialog =new AlertDialog.Builder(BaseActivity.this)
                .setTitle(getResources().getString(R.string.app_name))
                .setMessage(getErrrorMessage(throwable))
                .setPositiveButton(android.R.string.ok,onClickListener)
                .create();
        errorDialog.show();
    }

    private String getErrrorMessage(Throwable throwable) {
        if (throwable instanceof TimeoutException) {
            return "TimeOut Error";
        }else if (throwable instanceof UnknownHostException) {
            return "Network Error";
        }else if (throwable instanceof HttpException) {
            switch (((HttpException) throwable).code()) {
                case 401:
                    return "Unauthorized error";
                default:
                    return "Unexpected error";
            }
        }
        return throwable.getMessage();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeRealmInstance();
    }

    protected abstract void closeRealmInstance();
}
