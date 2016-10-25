package com.example.administrator.myretroftutils;

/**
 * Created by Administrator on 2016/10/13 0013.
 */
public interface Constants {
    /**
     * 指示是否是qa(测试)环境，是为true，生产环境时为false
     */
    boolean IS_QA = true;
    boolean IS_SHOW_LOG = true ;
    /**
     * 测试
     */
    String QA_URL_PREFIX_new = "http://10.1.37.31:8080/Cxf_xzlc_app/";
    /**
     * 生产环境URL前缀
     */
    String PRO_URL_PREFIX_new = "";
    /**
     * 请求路径
     */
    String REQUEST_URL_PREFIX_new = IS_QA ? QA_URL_PREFIX_new
            : PRO_URL_PREFIX_new;
}
