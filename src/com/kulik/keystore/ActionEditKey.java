package com.kulik.keystore;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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

    public ActionEditKey() {
        super(new IntentFilter(ActionEditKey.class.getName()));
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onRecive()!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
        KeyItem keyItem = intent.getParcelableExtra(KeyItem.class.getName());
    }

}
