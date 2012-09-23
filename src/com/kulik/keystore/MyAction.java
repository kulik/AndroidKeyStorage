package com.kulik.keystore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 22.09.12
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
public abstract class MyAction extends BroadcastReceiver {

    private IntentFilter mIntentFilter;

    protected MyAction(IntentFilter intentFilter) {
        mIntentFilter = intentFilter;
    }

    public IntentFilter getIntentFilter() {
        return mIntentFilter;
    }


}
