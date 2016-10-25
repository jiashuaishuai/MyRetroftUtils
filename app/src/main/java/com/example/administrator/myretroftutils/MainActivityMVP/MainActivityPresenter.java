package com.example.administrator.myretroftutils.MainActivityMVP;

import com.example.administrator.myretroftutils.Bean.MarketNewProductBean1;
import com.example.administrator.myretroftutils.MVPUtils.BasePresenter;
import com.example.administrator.myretroftutils.NetworkRequest.SuccessCall;

/**
 * Created by Administrator on 2016/10/13 0013.
 */
public class MainActivityPresenter extends BasePresenter<MainActivityView> {
    public MainActivityPresenter() {
    }

    public void requestData() {
        requestApiHelper.newProduct(sharedPreferencesUtils.getRequestParams(), new SuccessCall<MarketNewProductBean1>() {
            @Override
            public void succeed(MarketNewProductBean1 marketNewProductBean1) {
                mView.setTvTest(marketNewProductBean1.data.loans3.toString());
            }
        });
    }
}
