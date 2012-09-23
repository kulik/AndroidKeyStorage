package com.kulik.keystore;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 22.09.12
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
public class EditFragmentDialog extends DialogFragment {

    private static final String TAG = EditFragmentDialog.class.getSimpleName();

    private KeyItem mKeyItem;

    public enum KeyEditType{NEW, EDIT};

    public EditFragmentDialog(KeyItem mKeyItem) {
        this.mKeyItem = mKeyItem;
    }

    public EditFragmentDialog() {
    }

    @Override
    public void onResume() {
        super.onResume();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_fragment, container, false);

        restoreState(savedInstanceState);
        restoreUIState(view);

        Button btnCancel = (Button) view.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((DialogFragment) EditFragmentDialog.this).dismiss();
            }
        });

        return view;
    }

    private void restoreState(Bundle savedState) {
        if (savedState != null) {
            mKeyItem = savedState.getParcelable(KeyItem.class.getName());
        }
    }

    private void restoreUIState(View rootView) {
        if (mKeyItem != null) {
            EditText title = (EditText) rootView.findViewById(R.id.et_title);
            EditText login = (EditText) rootView.findViewById(R.id.et_login);
            EditText pass = (EditText) rootView.findViewById(R.id.et_password);
            EditText note = (EditText) rootView.findViewById(R.id.et_note);
            Button btnPositive = (Button) rootView.findViewById(R.id.btn_positive);

            title.setText(mKeyItem.getTitle());
            login.setText(mKeyItem.getLogin());
            pass.setText(mKeyItem.getPassword());
            note.setText(mKeyItem.getNote());

            btnPositive.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Log.v(TAG, "positive btn TODO implement saving");
                }
            });
            btnPositive.setText((mKeyItem.getId() == -1) ? "Create" : "Save");

        } else {
            mKeyItem = new KeyItem();
        }
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

    public void setKeyItem(KeyItem mKeyItem) {
        this.mKeyItem = mKeyItem;
    }

}
