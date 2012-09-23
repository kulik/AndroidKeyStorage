package com.kulik.keystore;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 23.09.12
 * Time: 13:37
 */
public class ActionManager {

    public static void registrateActions(Activity activity, List<MyAction> actions) {
        if (actions != null) {
            LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(activity);
            for (MyAction action : actions) {
                if (action != null) {
                    action.onRegistrate(activity);
                    broadcastManager.registerReceiver(action, action.getIntentFilter());
                }
            }
        }
    }

    public static void registrateAction(Activity activity, MyAction action) {
        if (action != null) {
            LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(activity);
            action.onRegistrate(activity);
            broadcastManager.registerReceiver(action, action.getIntentFilter());
        }
    }

    public static void unregistrateActions(Context context, List<MyAction> actions) {
        if (actions != null) {
            LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(context);
            for (MyAction action : actions) {
                if (action != null) {
                    action.onUnRegistrate();
                    broadcastManager.unregisterReceiver(action);
                }
            }
        }
    }

    public static void unregistrateAction(Context context, MyAction action) {
        if (action != null) {
            LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(context);
            action.onUnRegistrate();
            broadcastManager.unregisterReceiver(action);
        }
    }

}
