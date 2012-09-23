package com.kulik.keystore;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 23.09.12
 * Time: 13:37
 */
public class ActionManager {

    public static void registrateActions(Context context, List<MyAction> actions) {
        if (actions != null) {
            LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(context);
            for (MyAction action : actions) {
                if (action != null) {
                    broadcastManager.registerReceiver(action, action.getIntentFilter());
                }
            }
        }
    }

    public static void registrateAction(Context context, MyAction action) {
        if (action != null) {
            LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(context);
            broadcastManager.registerReceiver(action, action.getIntentFilter());
        }
    }

    public static void unregistrateActions(Context context, List<MyAction> actions) {
        if (actions != null) {
            LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(context);
            for (MyAction action : actions) {
                if (action != null) {
                    broadcastManager.unregisterReceiver(action);
                }
            }
        }
    }

    public static void unregistrateAction(Context context, MyAction action) {
        if (action != null) {
            LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(context);
            broadcastManager.unregisterReceiver(action);
        }
    }

}
