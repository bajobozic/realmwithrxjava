// Generated code from Butter Knife. Do not modify!
package com.example.bajob.movieshatch;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailActivity_ViewBinding<T extends DetailActivity> implements Unbinder {
  protected T target;

  @UiThread
  public DetailActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.collapsingToolbarLayout = Utils.findRequiredViewAsType(source, R.id.detail_colapsing_toolbar, "field 'collapsingToolbarLayout'", CollapsingToolbarLayout.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.detail_toolbar, "field 'toolbar'", Toolbar.class);
    target.imageView = Utils.findRequiredViewAsType(source, R.id.detail_app_bar_image, "field 'imageView'", ImageView.class);
    target.textView = Utils.findRequiredViewAsType(source, R.id.name, "field 'textView'", TextView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.detail_progress_bar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.collapsingToolbarLayout = null;
    target.toolbar = null;
    target.imageView = null;
    target.textView = null;
    target.progressBar = null;

    this.target = null;
  }
}
