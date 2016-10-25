package com.example.administrator.myretroftutils.NetworkRequest;


import com.example.administrator.myretroftutils.Constants;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 贾帅帅 on 2016/7/13.
 */
public class RetrofitRequestManger {
    private static final String TAG = "RetrofitRequestManger";
    private Retrofit.Builder retrofitBuilder;
    private int connectTimeOut;
    private boolean retryOnConnectionFailure;
    private HeaderInterceptor headerInterceptor;

    public RetrofitRequestManger() {
        retrofitBuilder = new Retrofit.Builder();
        defaultParams();
    }

    private static volatile RetrofitRequestManger retrofitRequestManger = null;

    /**
     * 实例化retrofitRequestConfig
     *
     * @return
     */
    public static RetrofitRequestManger getInstance() {
        RetrofitRequestManger inst = retrofitRequestManger;
        if (inst == null) {
            synchronized (RetrofitRequestManger.class) {
                inst = retrofitRequestManger;
                if (inst == null) {
                    inst = new RetrofitRequestManger();
                    retrofitRequestManger = inst;
                }
            }
        }
        return inst;
    }

    /**
     * 请求超时时间
     *
     * @param timeOut
     */
    public RetrofitRequestManger connectTimeout(int timeOut) {
        connectTimeOut = timeOut;
        return retrofitRequestManger;
    }

    /**
     * 错误重连
     */
    public RetrofitRequestManger retryOnConnectionFailure() {
        retryOnConnectionFailure = true;
        return retrofitRequestManger;
    }

    /**
     * 初始化请求api
     *
     * @return
     */
    public NetworkRequestApi initializeRequestApi() {
        return configRetrofit().create(NetworkRequestApi.class);
    }

    /**
     * 配置网络请求参数
     *
     * @return
     */
    private Retrofit configRetrofit() {
        Retrofit retrofit = retrofitBuilder.addConverterFactory(GsonConverterFactory.create())//解析方法
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constants.REQUEST_URL_PREFIX_new)//请求域名
                .client(configRequestClient())
                .build();
        return retrofit;
    }

    /**
     * 配置请求客户端
     *
     * @return
     */
    private OkHttpClient configRequestClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(connectTimeOut, TimeUnit.SECONDS)
                .retryOnConnectionFailure(retryOnConnectionFailure)
                .addInterceptor(headerInterceptor).addInterceptor(getLogIntercepter())
                .build();
        defaultParams();
        return client;
    }

    /**
     * 配置默认参数
     */
    private void defaultParams() {
        connectTimeOut = 5;
        retryOnConnectionFailure = false;
        headerInterceptor = new HeaderInterceptor();
    }

    /**
     * 请求
     *
     * @param totalBeanObservable 返回的Observable
     * @param classbean           bean泛型
     * @param call                请求回调
     * @param loadingStatusCall   统一回调
     * @param <T>
     */
    public <T extends BaseBean> void requestConfig(Observable<TotalBean> totalBeanObservable, Class<T> classbean, ResponseCall call, LoadingStatusCall loadingStatusCall) {
        totalBeanObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//结果在主线程
                .flatMap(new MyFuncBandData<T>(classbean))
                .subscribe(new ResponseResultSubscriber(call, loadingStatusCall));
    }

    /**
     * @param totalBeanObservable 返回的Observable
     * @param classbean           泛型
     * @param call                请求回调
     * @param loadingCall         加载匡回调
     * @param toastCall           toast回调
     * @param goToLoginCall       登录超时回调
     * @param <T>
     */
    public <T extends BaseBean> void requestConfig(Observable<TotalBean> totalBeanObservable, Class<T> classbean, ResponseCall call, LoadingCall loadingCall, ToastCall toastCall, GoToLoginCall goToLoginCall) {
        totalBeanObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//结果在主线程
                .flatMap(new MyFuncBandData<T>(classbean))
                .subscribe(new ResponseResultSubscriber(call, loadingCall, toastCall, goToLoginCall));
    }

    /**
     * 请求日志拦截器
     *
     * @return
     */
    public XZQBInterceptor getLogIntercepter() {

        XZQBInterceptor httpLoggingInterceptor = new XZQBInterceptor();
        httpLoggingInterceptor.setLevel(XZQBInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    /**
     * 头部拦截器
     */
    public class HeaderInterceptor implements Interceptor {
        private Map<String, String> headermap;

        public HeaderInterceptor(Map<String, String> headermap) {
            this.headermap = headermap;
        }

        public HeaderInterceptor() {
            headermap = new HashMap<>();
            headermap.put("Accept", "application/json");
            headermap.put("Content-Type", "application/json; charset=UTF-8");
        }

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request.Builder requestBuilder = originalRequest.newBuilder()
                    .headers(okhttp3.Headers.of(headermap))
                    .method(originalRequest.method(), originalRequest.body());
            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
    }

}
