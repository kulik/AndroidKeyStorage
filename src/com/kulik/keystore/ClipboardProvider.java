package com.kulik.keystore;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 22.09.12
 * Time: 13:47
 * To change this template use File | Settings | File Templates.
 */
public class ClipboardProvider implements View.OnClickListener {

    ClipboardManager mClipboard;

    public ClipboardProvider(Context context) {

        mClipboard = (ClipboardManager)
                context.getSystemService(Context.CLIPBOARD_SERVICE);

    }

    @Override
    public void onClick(View view) {
        TextView tv = (TextView) view;
        String text = (String) tv.getText();
        ClipData clip = ClipData.newPlainText("key provider", text);
        mClipboard.setPrimaryClip(clip);
    }
}
