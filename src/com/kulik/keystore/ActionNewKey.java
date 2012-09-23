package com.kulik.keystore;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 22.09.12
 * Time: 19:58
 * To change this template use File | Settings | File Templates.
 */
public class ActionNewKey extends MyAction {

    public ActionNewKey() {
        super(new IntentFilter(ActionNewKey.class.getName()));
    }

    @Override
    public void onReceive(Context context, Intent intent) {

    }

}
