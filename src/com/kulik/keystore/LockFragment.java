package com.kulik.keystore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.kulik.keystore.Actions.ActionNewKey;
import com.kulik.keystore.Actions.ActionUnLock;

/**
 * Created with IntelliJ IDEA.
 * User: kulik
 * Date: 22.09.12
 * Time: 21:06
 * To change this template use File | Settings | File Templates.
 */
public class LockFragment extends Fragment {

    private static final String TAG = LockFragment.class.getSimpleName();

    private KeyListAdapter mKeyListAdapter;

    public LockFragment() {
    }

    @Override
    public void onResume() {
        super.onResume();
        EditText etCode = (EditText) getView().findViewById(R.id.et_code);
        etCode.setText("");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lock_fragment, container, false);

     //   init(view);

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
        final EditText codeEditText= (EditText) rootView.findViewById(R.id.et_code);

        View.OnClickListener numbersListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = (String) ((Button)v).getText();
                Log.d(TAG, "onClick():" + text);
                String etText = codeEditText.getText().toString();
                if (etText.length() < 4) {
                    codeEditText.setText(etText + text);
                }
            }
        };
//        ((Button) rootView.findViewById(R.id.num_0)).setOnClickListener(numbersListener);
//        ((Button) rootView.findViewById(R.id.num_1)).setOnClickListener(numbersListener);
//        ((Button) rootView.findViewById(R.id.num_2)).setOnClickListener(numbersListener);
//        ((Button) rootView.findViewById(R.id.num_3)).setOnClickListener(numbersListener);
//        ((Button) rootView.findViewById(R.id.num_4)).setOnClickListener(numbersListener);
//        ((Button) rootView.findViewById(R.id.num_5)).setOnClickListener(numbersListener);
//        ((Button) rootView.findViewById(R.id.num_6)).setOnClickListener(numbersListener);
//        ((Button) rootView.findViewById(R.id.num_7)).setOnClickListener(numbersListener);
//        ((Button) rootView.findViewById(R.id.num_8)).setOnClickListener(numbersListener);
//        ((Button) rootView.findViewById(R.id.num_9)).setOnClickListener(numbersListener);
//        Button enter = ((Button) rootView.findViewById(R.id.enter_btn));
//        enter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if ("1234".equals(codeEditText.getText().toString())) {
//                    Log.d(TAG, "Pass phrase wascorrect");
//                    Intent unlockIntent = new Intent(ActionUnLock.class.getName());
//                    LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(unlockIntent);
//                }
//            }
//        });

    }



}
