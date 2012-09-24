package com.kulik.keystore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 22.09.12
 * Time: 19:47
 * To change this template use File | Settings | File Templates.
 */
public class ActionEditKey extends MyAction {

    private static final String TAG = ActionEditKey.class.getSimpleName();

    private WeakReference<Activity> mActivity;

    public ActionEditKey() {
        super(new IntentFilter(ActionEditKey.class.getName()));
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onRecive()");
        KeyItem keyItem = intent.getParcelableExtra(KeyItem.class.getName());

        FragmentManager fragmentManager =  ((FragmentActivity) mActivity.get()).getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.edit_fragment);
         if (fragment == null) {
             Log.d(TAG, "Fragmnt is absent");
             fragment = new EditFragmentDialog(keyItem);
         } else {
             Log.d(TAG, "Fragment already exist");
             ((EditFragmentDialog) fragment).setKeyItem(keyItem);
         }
        ((EditFragmentDialog) fragment).show(fragmentManager, "asdfsd");
    }

    @Override
    public void onRegistrate(Activity activity) {
        mActivity = new WeakReference<Activity>(activity);
    }

    @Override
    public void onUnRegistrate() {

    }
}
