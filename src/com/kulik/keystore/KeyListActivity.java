package com.kulik.keystore;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

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

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
        initActions();
        ActionManager.registrateActions(this, mActions);
    }

    private void initActions() {
        mActions.add(new ActionEditKey());
        mActions.add(new ActionNewKey());
    }

    private void init() {

        ListView keyListView = (ListView) findViewById(R.id.lv_keys);
        mKeyListAdapter = new KeyListAdapter(this, getKeyListStub());
        keyListView.setAdapter(mKeyListAdapter);
        keyListView.setOnItemLongClickListener(mKeyListAdapter);

        Button btnNew = (Button) findViewById(R.id.btn_new);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onItemLongClick()");

                Intent editIntent = new Intent(ActionNewKey.class.getName());
                //editIntent.putExtra(KeyItem.class.getName(), new Item);

                LocalBroadcastManager.getInstance(KeyListActivity.this).sendBroadcast(editIntent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public List<KeyItem> getKeyListStub() {
        List<KeyItem> keyListStub = new ArrayList<KeyItem>();
        keyListStub.add(new KeyItem(10, "GIT HUB", "githublogin", "Gfdg3rf", "Password from github account"));
        keyListStub.add(new KeyItem(11, "Git Mobidev", "login@mobidev.biz", "g3rf", "My mobidev git pass"));
        keyListStub.add(new KeyItem(12, "SVN", "githublogin", "Gfdg3rf", "My google account"));
        keyListStub.add(new KeyItem(13, "VKontakte", "Vkontakte@mytechlab.biz", "Gfdg3rf", "Vkontakte account "));
        keyListStub.add(new KeyItem(14, "projectaccount", "login", "Gfdg3rf", "Password from account"));
        keyListStub.add(new KeyItem(15, "GIT HUB2", "githublogin2", "Gefdg3rf", "Password from github2 account"));
        keyListStub.add(new KeyItem(16, "GIT HUB3", "githublogin3", "Gfqwedg3rf", "Password from github3 account"));
        keyListStub.add(new KeyItem(17, "GIT HUB4", "githublogin4", "gtrfdg3rf", "Password from github4 account"));
        keyListStub.add(new KeyItem(18, "GIT HUB5", "githublogin5", "csdf87", "Password from github5 account"));
        keyListStub.add(new KeyItem(19, "GIT HUB6", "githublogin6", "csd87f6gsoi", "Password from github6 account"));
        keyListStub.add(new KeyItem(20, "GIT HUB7", "githublogin7", "cgwlkeFSGiw3", "Password from github7 account"));
        keyListStub.add(new KeyItem(21, "GIT HUB8", "githublogin8", "VCDFGCcsdf$", "Password from github8 account"));
        keyListStub.add(new KeyItem(22, "GIT HUB9", "githublogin9", "cQg33gcQ3", "Password from github9 account"));
        keyListStub.add(new KeyItem(23, "GIT HUB10", "githublogin10", "GTWC3553", "Password from github10 account"));

        return keyListStub;
    }
}
