package com.kulik.keystore;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.kulik.keystore.Actions.ActionEditKey;
import com.kulik.keystore.Actions.ActionNewKey;
import com.kulik.keystore.Actions.ActionUnLock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KeyListActivity extends FragmentActivity {

    private static final String TAG = KeyListActivity.class.getSimpleName();

    private KeyListAdapter mKeyListAdapter;
    private List<MyAction> mActions = new ArrayList<MyAction>();

    @Override
    protected void onDestroy() {
        ActionManager.unregistrateActions(this, mActions);

        super.onDestroy();
    }

    private void initActions() {
        mActions.add(new ActionEditKey());
        mActions.add(new ActionNewKey());
        mActions.add(new ActionUnLock());
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ActionManager.registrateActions(this, mActions);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment lockFrg = fm.findFragmentById(R.id.lock_fragment);
         if (lockFrg == null) {
             lockFrg = new LockFragment();
         }
        ft.replace(R.id.fragment_container, lockFrg);
        ft.commit();
    }


}
