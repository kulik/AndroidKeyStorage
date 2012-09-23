package com.kulik.keystore;

import android.content.Context;
import android.content.Intent;
import android.drm.DrmStore;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 22.09.12
 * Time: 12:39
 * To change this template use File | Settings | File Templates.
 */
public class KeyListAdapter extends ArrayAdapter<KeyItem> implements AdapterView.OnItemLongClickListener {

    private static final String TAG = KeyListAdapter.class.getSimpleName();

    private LayoutInflater mLayoutInflater;
    private ClipboardProvider mClipboardProvider;

    public KeyListAdapter(Context context, List<KeyItem> objects) {
        super(context, 0, objects);
        mLayoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mClipboardProvider = new ClipboardProvider(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null || !(convertView instanceof LinearLayout)) {
            convertView = mLayoutInflater.inflate(R.layout.keystore_item_layout, parent, false);
        }

        KeyItem keyItem = getItem(position);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_key_title);
        tvTitle.setText(keyItem.getTitle());

        TextView tvLogin = (TextView) convertView.findViewById(R.id.tv_login);
        tvLogin.setText(keyItem.getLogin());
        tvLogin.setOnClickListener(mClipboardProvider);

        TextView tvPass = (TextView) convertView.findViewById(R.id.tv_pass);
        tvPass.setText(keyItem.getPassword());
        tvPass.setOnClickListener(mClipboardProvider);

        TextView tvNote = (TextView) convertView.findViewById(R.id.tv_note);
        tvNote.setText(keyItem.getNote());

        return convertView;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(TAG, "onItemLongClick()");

        Intent editIntent = new Intent(ActionEditKey.class.getName());
        editIntent.putExtra(KeyItem.class.getName(), getItem(i));

        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(editIntent);
        return true;
    }
}
