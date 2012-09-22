package com.kulik.keystore;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.ListView;

import java.util.ArrayList;

public class KeyListActivity extends FragmentActivity {
    private ListView mKeyListView;
    private KeyListAdapter mKeyListAdapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
        LocalBroadcastManager.getInstance(this).registerReceiver(new ActionEditKey(), new IntentFilter(Intent.ACTION_EDIT));
        LocalBroadcastManager.getInstance(this).registerReceiver(new ActionNewKey(), new IntentFilter(Intent.ACTION_INSERT));
    }

    private void init() {

        mKeyListView = (ListView) findViewById(R.id.lv_keys);
          mKeyListAdapter = new KeyListAdapter(this, new ArrayList<KeyItem>());
          mKeyListView.setAdapter(mKeyListAdapter);
          mKeyListView.setOnItemLongClickListener(mKeyListAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
