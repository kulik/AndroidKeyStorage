package com.kulik.keystore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import com.kulik.keystore.Actions.ActionEditKey;
import com.kulik.keystore.Actions.ActionNewKey;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 22.09.12
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
public class KeysFragment extends Fragment {

    private static final String TAG = KeysFragment.class.getSimpleName();

    private KeyListAdapter mKeyListAdapter;

    public KeysFragment() {
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.keys_fragment, container, false);

        init(view);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void init(View rootView) {

        ListView keyListView = (ListView) rootView.findViewById(R.id.lv_keys);
        mKeyListAdapter = new KeyListAdapter(getActivity(), getKeyListStub());
        keyListView.setAdapter(mKeyListAdapter);
        keyListView.setOnItemLongClickListener(mKeyListAdapter);

        Button btnNew = (Button) rootView.findViewById(R.id.btn_new);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onItemLongClick()");

                Intent editIntent = new Intent(ActionNewKey.class.getName());
                LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(editIntent);

            }
        });
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
