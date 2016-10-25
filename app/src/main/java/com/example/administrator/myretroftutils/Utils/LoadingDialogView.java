package com.example.administrator.myretroftutils.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.example.administrator.myretroftutils.R;


/**
 * Created by 贾帅帅 on 2016/7/22.
 */
public class LoadingDialogView extends AlertDialog {

    public LoadingDialogView(Context context) {
        super(context, R.style.Loading_Dialog);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_loading_layout);
    }
}
