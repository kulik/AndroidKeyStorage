package com.kulik.keystore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.drm.DrmStore;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 22.09.12
 * Time: 19:47
 * To change this template use File | Settings | File Templates.
 */
public class ActionEditKey extends MyAction {
    private static final String TAG = ActionEditKey.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onRecive()");
        KeyItem keyItem = intent.getParcelableExtra(KeyItem.class.getName());
    }
}
