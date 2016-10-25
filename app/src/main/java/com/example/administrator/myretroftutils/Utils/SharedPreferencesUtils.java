package com.example.administrator.myretroftutils.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.administrator.myretroftutils.App;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiashuaishuai on 2015/12/8.
 */
public class SharedPreferencesUtils {
    public static final String SP_NAME = "userInfo";
    public static final String USER_ID = "userId";
    public static final String SESSION_ID = "sessionId";
    public static final String USER_NAME = "username";
    public static final String CASH = "cash";
    public static final String PHONE = "phone";
    public static final String REAL_NAME = "realName";
    public static final String ID_CARD_NO = "idCardNo";
    public static final String LAST_LOGIN_USER_ID = "lastLoginUserid";
    public static final String REGISTER_TIME = "registerTime";
    public static final String HEAD_IMAGE = "headImage";
    public static final String HEAD_IMAGE_TYPE = "headImageType";
    public static final String IS_NEWBIE = "isNewbie";

    /**
     * 银行卡
     */
    public static final String BANKS = "banks";
    public static final String BANK_CARD_NUMBER = "bankCardNumber";
    public static final String BANK_OF_DEPOSIT = "bankOfDeposit";
    public static final String BANK_CODE = "bankCode";
    public static final String BRANCH_BANK_NAME = "branchBankname";
    public static final String CITY_NAME = "cityName";
    public static final String PROVINCE_NAME = "provinceName";
    public static final String PROVINCE_CODE = "provinceCode";
    public static final String CITY_CODE = "cityCode";
    public static final String CITY_ID = "cityId";
    public static final String NEED_BRANCH_INFO = "need_branch_info";
    /**
     * 其他
     */
    public static final String GESTURE_PASSWORD = "gesturepassword";
    public static final String NOTICE_TIME = "noticeTime";
    public static final String NOTICE_STATE = "noticeState";
    public static final String VERSION_NUM = "versionNum";
    public static final String HEAD_INFO_DIC = "headInfoDic";


    private static SharedPreferencesUtils sharedPreferencesUtils;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    private SharedPreferencesUtils() {
        this.context = App.getApplication();
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SharedPreferencesUtils getSharedPreferencesUtils() {
        sharedPreferencesUtils = new SharedPreferencesUtils();
        return sharedPreferencesUtils;
    }

    private SharedPreferencesUtils(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SharedPreferencesUtils getSharedPreferencesUtils(Context context) {
        sharedPreferencesUtils = new SharedPreferencesUtils(context);
        return sharedPreferencesUtils;
    }


    public SharedPreferences getSharedPreferences() {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    public String getUserId() {
        return getStringSp(USER_ID);
    }

    public String getSessionId() {
        return getStringSp(SESSION_ID);
    }

    public String getEncryptUserid() throws Exception {
        String userid = getUserId();
        if (TextUtils.isEmpty(userid))
            return "";
        return userid;
    }

    /**
     * 这里解密，根据个人项目而定
     *
     * @return
     * @throws Exception
     */
    public String getEncryptSessionid() throws Exception {
        String sessionid = getSessionId();
        if (TextUtils.isEmpty(sessionid))
            return "";
        return sessionid;
    }

    public String getUserName() {
        return getStringSp(USER_NAME);
    }

    public String getPhone() {
        return getStringSp(PHONE);
    }

//    public String getDecryptPhone() {
//        String phone = getPhone();
//        if (TextUtils.isEmpty(phone))
//            return null;
//        return EnDeCrypt.decrypt(phone, "qwertyuio");
//    }

    public String getRealName() {
        return getStringSp(REAL_NAME);
    }

//    public String getDecryptRealName() {
//        String username = getRealName();
//        if (TextUtils.isEmpty(username)) {
//            return "";
//        }
//        return EnDeCrypt.decrypt(username, "qwertyuio");
//    }
//
//    public String getIdCardNo() {
//        return getStringSp(ID_CARD_NO);
//    }
//
//    public String getDecryptIdCardNo() {
//        String idCardNo = getIdCardNo();
//        if (TextUtils.isEmpty(idCardNo))
//            return "";
//        return EnDeCrypt.decrypt(idCardNo, "qwertyuio");
//    }

    public String getIsNewbie() {
        return getStringSp(IS_NEWBIE);
    }

    public SharedPreferencesUtils setHeadImageType(String headImageType) {

        return setStringSP(HEAD_IMAGE_TYPE, headImageType);

    }

    public String getHeadImageType() {
        return getStringSp(HEAD_IMAGE_TYPE);
    }

    public SharedPreferencesUtils setHeadImage(String headImage) {
        return setStringSP(HEAD_IMAGE, headImage);
    }

    public String getHeadImage() {
        return getStringSp(HEAD_IMAGE);
    }

    public String getStringSp(String key) {

        return sharedPreferences.getString(key, "");

    }

    public SharedPreferences.Editor getEditor() {

        if (null == editor) {
            editor = sharedPreferences.edit();
        }
        return editor;
    }


    public SharedPreferencesUtils setStringSP(String key, String values) {
        editor.putString(key, values);
        editor.commit();
        return sharedPreferencesUtils;
    }
//    public SharedPreferencesUtils setEnDeCryptStringSP(String key, String values) {
//        editor.putString(key,  EnDeCrypt.encrypt(values, "qwertyuio"));
//        editor.commit();
//        return sharedPreferencesUtils;
//    }


    public SharedPreferencesUtils setBooleanSp(String key, boolean values) {
        editor.putBoolean(key, values);
        editor.commit();
        return sharedPreferencesUtils;
    }

    public boolean getBooleanSp(String key) {

        return sharedPreferences.getBoolean(key, false);
    }

    public int getIntergetSp(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public SharedPreferencesUtils setIntergetSp(String key, int value) {

        editor.putInt(key, value);
        editor.commit();
        return sharedPreferencesUtils;
    }


    public int getBanks() {
        /**
         * 返回银行卡个数
         */
        return getIntergetSp(BANKS);
    }

    /**
     * 银行卡get
     *
     * @return
     */


    public String getBankCardNumber(String bankCardIndex) {
        return getStringSp(BANK_CARD_NUMBER + bankCardIndex);
    }

    public String getBankOfDeposit(String bankCardIndex) {
        return getStringSp(BANK_OF_DEPOSIT + bankCardIndex);
    }

    public String getBankCode(String bankCardIndex) {
        return getStringSp(BANK_CODE + bankCardIndex);
    }

    public String getBranchBankname(String bankCardIndex) {
        return getStringSp(BRANCH_BANK_NAME + bankCardIndex);
    }

    public String getCityName(String bankCardIndex) {
        return getStringSp(CITY_NAME + bankCardIndex);
    }

    public String getProvinceName(String bankCardIndex) {
        return getStringSp(PROVINCE_NAME + bankCardIndex);
    }

    public String getProvinceCode(String bankCardIndex) {
        return getStringSp(PROVINCE_CODE + bankCardIndex);
    }

    public String getCityCode(String bankCardIndex) {
        return getStringSp(CITY_CODE + bankCardIndex);
    }

    public String getCityId(String bankCardIndex) {
        return getStringSp(CITY_ID + bankCardIndex);
    }

    public String getNeedBranchInfo() {
        //    参数暂缺    String bankCardIndex,//以防万一写错，因为暂时只支持一张张银行卡，当时没有加下表
        return getStringSp(NEED_BRANCH_INFO);
    }


    /**
     * 银行卡set
     *
     * @param bankCardIndex
     */

    public SharedPreferencesUtils setBankCardNumber(String bankCardIndex, String bankCardNumber) {
        return setStringSP(BANK_CARD_NUMBER + bankCardIndex, bankCardNumber);
    }

    public SharedPreferencesUtils setBankOfDeposit(String bankCardIndex, String bankOfDeposit) {
        return setStringSP(BANK_OF_DEPOSIT + bankCardIndex, bankOfDeposit);
    }

    public SharedPreferencesUtils setBankCode(String bankCardIndex, String bankCode) {
        return setStringSP(BANK_CODE + bankCardIndex, bankCode);
    }

    public SharedPreferencesUtils setBranchBankname(String bankCardIndex, String branchBankname) {
        return setStringSP(BRANCH_BANK_NAME + bankCardIndex, branchBankname);
    }

    public SharedPreferencesUtils setCityName(String bankCardIndex, String cityName) {
        return setStringSP(CITY_NAME + bankCardIndex, cityName);
    }

    public SharedPreferencesUtils setProvinceName(String bankCardIndex, String provinceName) {
        return setStringSP(PROVINCE_NAME + bankCardIndex, provinceName);
    }

    public SharedPreferencesUtils setProvinceCode(String bankCardIndex, String provinceCode) {
        return setStringSP(PROVINCE_CODE + bankCardIndex, provinceCode);
    }

    public SharedPreferencesUtils setCityCode(String bankCardIndex, String cityCode) {
        return setStringSP(CITY_CODE + bankCardIndex, cityCode);
    }

    public SharedPreferencesUtils setCityId(String bankCardIndex, String cityId) {
        return setStringSP(CITY_ID + bankCardIndex, cityId);
    }

    public SharedPreferencesUtils setNeedBranchInfo(String needBranchInfo) {
//    参数暂缺    String bankCardIndex,//以防万一写错，因为暂时只支持一张张银行卡，当时没有加下表
        return setStringSP(NEED_BRANCH_INFO, needBranchInfo);
    }


    /**
     * 获取本地userid sessionId网络请求参数
     *
     * @return
     */
    public Map<String, String> getRequestParams() {


        Map<String, String> params = new HashMap<>();
        try {
            params.put("userId", getEncryptUserid());
            params.put("sessionId", getEncryptSessionid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (params != null || params.size() > 0)
            return params;
        Logger.e("sharedPreferencesUtils", "params is null");
        return null;
    }

}
