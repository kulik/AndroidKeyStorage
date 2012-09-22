package com.kulik.keystore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 22.09.12
 * Time: 12:39
 * To change this template use File | Settings | File Templates.
 */
public class KeyListAdapter extends ArrayAdapter<KeyItem> implements View.OnLongClickListener, AdapterView.OnItemLongClickListener {
    private LayoutInflater mLayoutInflater;
    private ClipboardProvider mClipboardProvider;

    public KeyListAdapter(Context context, List<KeyItem> objects) {
        super(context, 0, objects);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mClipboardProvider = new ClipboardProvider(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.keystore_item_layout, parent);
        }

        convertView.setOnLongClickListener(this);

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

        return super.getView(position, convertView, parent);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent editIntent = new Intent();
        editIntent.
        getContext().sendBroadcast(editIntent);
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
