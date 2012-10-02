package com.kulik.keystore.Actions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import com.kulik.keystore.*;

import java.lang.ref.WeakReference;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 22.09.12
 * Time: 19:58
 * To change this template use File | Settings | File Templates.
 */
public class ActionUnLock extends MyAction {

    private static final String TAG = ActionUnLock.class.getSimpleName();

    private WeakReference<Activity> mActivity;

    public ActionUnLock() {
        super(new IntentFilter(ActionUnLock.class.getName()));
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        KeyItem keyItem = intent.getParcelableExtra(KeyItem.class.getName());

        FragmentManager fragmentManager =  ((FragmentActivity) mActivity.get()).getSupportFragmentManager();
        Fragment keysFrg = fragmentManager.findFragmentById(R.id.keys_fragment);
        if (keysFrg == null) {
            Log.d(TAG, "Fragmnt is absent");
            keysFrg = new KeysFragment();
        } else {
            Log.d(TAG, "Fragment already exist");
        }
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, keysFrg)
                .commit();
    }

    @Override
    public void onRegistrate(Activity activity) {
       mActivity = new WeakReference<Activity>(activity)
       ;
    }

    @Override
    public void onUnRegistrate() {

    }
}
