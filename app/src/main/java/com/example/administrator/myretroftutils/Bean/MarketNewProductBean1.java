package com.example.administrator.myretroftutils.Bean;


import com.example.administrator.myretroftutils.NetworkRequest.BaseBean;

import java.util.List;

/**
 * Created by 贾帅帅 on 2016/6/17.
 */
public class MarketNewProductBean1 extends BaseBean {



    public String listAd;
    public Data data;


    public class Data {
        public List<LoanBean> groups;
        public List<LoanBean> loans1;
        public List<LoanBean> loans2;
        public List<LoanBean> loans3;
        public List<LoanBean> loans4;
        public List<LoanBean> loans5;
        public List<LoanBean> loans6;
        public List<LoanBean> loans7;
        public List<LoanBean> loans8;
        public List<LoanBean> loans9;
        public List<LoanBean> loans10;


        public class LoanBean {
            public String groupAd;
            public String groupId;
            public String groupName;
            public String annualInterestRate;
            public String loanItemType;
            public String bgInfo;
            public String bgInfo1;
            public String createTime;
            public String eachMostValue;
            public String id;
            public String increasevalue;
            public String interestRate;
            public String isRecommend;
            public String projectInfo;
            public String projectInfo1;
            public String protocolTemplate;
            public String rate;
            public String rateType;
            public String regularRateId;
            public String safeInfo;
            public String safeInfo1;
            public String startvalue;
            public String valid;
            public String validDate;
            public String amount;
            public String annualStringerestRate;
            public String biddingAmount;
            public String calInterestMode;
            public String description;
            public String egoldType;
            public String egoldvalue;
            public String hike;
            public String leastrate;
            public String loanAD1;
            public String loanAD2;
            public String loanId;
            public String loanInfoMsgUrl;
            public String loanPromotionInfo1;
            public String loanPromotionInfo2;
            public String loanPromotionInfo3;
            public String loanPromotionInfo4;
            public String loanType;
            public String minAmount;
            public String mostrate;
            public String openEndTime;
            public String openTime;
            public String productId;
            public String realEgoldValue;
            public String recommendWeight;
            public String status;
            public String tag;
            public String termCount;
            public String termUnit;
            public String title;
            public String titleAd;
            public String type;

            @Override
            public String toString() {
                return "LoanBean{" +
                        "groupAd='" + groupAd + '\'' +
                        ", groupId='" + groupId + '\'' +
                        ", groupName='" + groupName + '\'' +
                        ", annualInterestRate='" + annualInterestRate + '\'' +
                        ", loanItemType='" + loanItemType + '\'' +
                        ", bgInfo='" + bgInfo + '\'' +
                        ", bgInfo1='" + bgInfo1 + '\'' +
                        ", createTime='" + createTime + '\'' +
                        ", eachMostValue='" + eachMostValue + '\'' +
                        ", id='" + id + '\'' +
                        ", increasevalue='" + increasevalue + '\'' +
                        ", interestRate='" + interestRate + '\'' +
                        ", isRecommend='" + isRecommend + '\'' +
                        ", projectInfo='" + projectInfo + '\'' +
                        ", projectInfo1='" + projectInfo1 + '\'' +
                        ", protocolTemplate='" + protocolTemplate + '\'' +
                        ", rate='" + rate + '\'' +
                        ", rateType='" + rateType + '\'' +
                        ", regularRateId='" + regularRateId + '\'' +
                        ", safeInfo='" + safeInfo + '\'' +
                        ", safeInfo1='" + safeInfo1 + '\'' +
                        ", startvalue='" + startvalue + '\'' +
                        ", valid='" + valid + '\'' +
                        ", validDate='" + validDate + '\'' +
                        ", amount='" + amount + '\'' +
                        ", annualStringerestRate='" + annualStringerestRate + '\'' +
                        ", biddingAmount='" + biddingAmount + '\'' +
                        ", calInterestMode='" + calInterestMode + '\'' +
                        ", description='" + description + '\'' +
                        ", egoldType='" + egoldType + '\'' +
                        ", egoldvalue='" + egoldvalue + '\'' +
                        ", hike='" + hike + '\'' +
                        ", leastrate='" + leastrate + '\'' +
                        ", loanAD1='" + loanAD1 + '\'' +
                        ", loanAD2='" + loanAD2 + '\'' +
                        ", loanId='" + loanId + '\'' +
                        ", loanInfoMsgUrl='" + loanInfoMsgUrl + '\'' +
                        ", loanPromotionInfo1='" + loanPromotionInfo1 + '\'' +
                        ", loanPromotionInfo2='" + loanPromotionInfo2 + '\'' +
                        ", loanPromotionInfo3='" + loanPromotionInfo3 + '\'' +
                        ", loanPromotionInfo4='" + loanPromotionInfo4 + '\'' +
                        ", loanType='" + loanType + '\'' +
                        ", minAmount='" + minAmount + '\'' +
                        ", mostrate='" + mostrate + '\'' +
                        ", openEndTime='" + openEndTime + '\'' +
                        ", openTime='" + openTime + '\'' +
                        ", productId='" + productId + '\'' +
                        ", realEgoldValue='" + realEgoldValue + '\'' +
                        ", recommendWeight='" + recommendWeight + '\'' +
                        ", status='" + status + '\'' +
                        ", tag='" + tag + '\'' +
                        ", termCount='" + termCount + '\'' +
                        ", termUnit='" + termUnit + '\'' +
                        ", title='" + title + '\'' +
                        ", titleAd='" + titleAd + '\'' +
                        ", type='" + type + '\'' +
                        '}';
            }
        }


    }
}
