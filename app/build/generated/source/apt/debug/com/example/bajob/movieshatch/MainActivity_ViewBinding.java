// Generated code from Butter Knife. Do not modify!
package com.example.bajob.movieshatch;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  @UiThread
  public MainActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.searchImage = Utils.findRequiredViewAsType(source, R.id.imageView, "field 'searchImage'", ImageView.class);
    target.searchText = Utils.findRequiredViewAsType(source, R.id.searchText, "field 'searchText'", EditText.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.tv_show_progress_bar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.searchImage = null;
    target.searchText = null;
    target.recyclerView = null;
    target.progressBar = null;

    this.target = null;
  }
}
