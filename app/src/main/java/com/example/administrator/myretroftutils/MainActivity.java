package com.example.administrator.myretroftutils;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.myretroftutils.MainActivityMVP.MainActivityPresenter;
import com.example.administrator.myretroftutils.MainActivityMVP.MainActivityView;

public class MainActivity extends BaseActivity<MainActivityView, MainActivityPresenter> implements MainActivityView {
    private TextView tv;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.requestData();
            }
        });

    }

    @Override
    public MainActivityPresenter initPresenter() {
        return new MainActivityPresenter();
    }


    @Override
    public void setTvTest(String s) {
        tv.setText(s);
    }
}
