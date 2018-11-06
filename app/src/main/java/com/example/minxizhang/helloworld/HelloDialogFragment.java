package com.example.minxizhang.helloworld;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;

public class HelloDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View savedTripView = inflater.inflate(R.layout.dialog_saves_trip_name, null);

        EditText tripNameView = savedTripView.findViewById(R.id.saves_trip_name_entry);
        tripNameView.setText("北京之旅");
        tripNameView.setSelection(0);

        AlertDialog alertDialog = new AlertDialog.Builder(requireActivity(), R.style.EditDlgFrag_DlgStyle)
                .setView(savedTripView)
                .setTitle("收藏至行程")
                .setPositiveButton("保存", null)
                .setNegativeButton("取消", null)
                .create();

//        Window window = alertDialog.getWindow();
//        if (window != null) {
//            window.setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_VISIBLE |
//                    LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//        }

        return alertDialog;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_VISIBLE |
                    LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        }
    }
}
