package com.kulik.keystore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 22.09.12
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
public class EditFragmentDialog extends Fragment {
    private KeyItem mKeyItem;

    @Override
    public void onResume() {
        super.onResume();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_fragment, container);

        return view;
    }

    private void restoreState(View rootView, Bundle savedState) {
        mKeyItem = savedState.getParcelable(KeyItem.class.getName());

        EditText title = (EditText) rootView.findViewById(R.id.et_title);
        EditText login = (EditText) rootView.findViewById(R.id.et_login);
        EditText pass = (EditText) rootView.findViewById(R.id.et_password);
        EditText note = (EditText) rootView.findViewById(R.id.et_note);

        title.setText(mKeyItem.getTitle());
        login.setText(mKeyItem.getLogin());
        pass.setText(mKeyItem.getPassword());
        note.setText(mKeyItem.getNote());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KeyItem.class.getName(), mKeyItem);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
