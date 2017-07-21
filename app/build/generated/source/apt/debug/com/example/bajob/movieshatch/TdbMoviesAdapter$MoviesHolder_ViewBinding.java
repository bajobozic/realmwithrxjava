// Generated code from Butter Knife. Do not modify!
package com.example.bajob.movieshatch;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TdbMoviesAdapter$MoviesHolder_ViewBinding<T extends TdbMoviesAdapter.MoviesHolder> implements Unbinder {
  protected T target;

  @UiThread
  public TdbMoviesAdapter$MoviesHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.imageView = Utils.findRequiredViewAsType(source, R.id.imageView3, "field 'imageView'", ImageView.class);
    target.textView = Utils.findRequiredViewAsType(source, R.id.textView7, "field 'textView'", TextView.class);
    target.textView1 = Utils.findRequiredViewAsType(source, R.id.textView8, "field 'textView1'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.imageView = null;
    target.textView = null;
    target.textView1 = null;

    this.target = null;
  }
}
