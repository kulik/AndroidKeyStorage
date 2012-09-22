package com.kulik.keystore;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class KeyListActivity extends Activity {
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
