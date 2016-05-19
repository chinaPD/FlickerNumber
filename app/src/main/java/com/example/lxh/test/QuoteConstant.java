package com.example.lxh.test;

import java.text.DecimalFormat;

/**
 * 行情常量类
 */
public final class QuoteConstant {


    //  正式生产环境测试：
      public static  String TRADE_IP = " http://119.29.45.195:7300/kesb_req";
    //  行情正式环境 带中台
    //  public static  String TRADE_IP ="http://115.159.161.158:8989/kesb_req";
    //  公司环境 外网测试环境
//        public static  String TRADE_IP = "http://218.17.71.90:8922/kesb_req";
    //  热点组合测试环境
    public static  String HOT_COMBINATION = "http://119.29.223.178/hot";
    //巨潮资讯测试环境
    public  static String INFORMATION__MORE_URL ="http://119.29.23.115:8080";
//    正式生产环境测试：
//    http://119.29.45.195:7300/kesb_req
//    三个指数生产环境，过渡使用
//    http://115.159.161.158:8988/kesb_req  不走中台
//    http://115.159.161.158:8989/kesb_req  走中台。



    //热点组合点击更多传递的常量
    public static final String HOT_MORE_URL = "hot_more_url";
    public static final String DATA_MSG_COMMON = "MSG_COMMON";// 通用数据
    // 股票代码
    public final static String SECU_CODE = "secu_code";
    // 股票名称
    public final static String SECU_NAME = "secu_name";
    // 市场
    public final static String SECU_MARKET = "secu_market";
    // 股票类型
    public final static String SECU_TYPE = "secu_type";
    // 新闻，公告记录id,正文id
    public final static String DOCUMENT_ID = "doucment_id";
    public final static String TEXT_ID = "text_id";
    public final static String InforMation_TYPE = "information_type";

    /**
     * 资讯请求码
     */
    public final static int INFORMATION_REQUEST_CODE = 0;
    public final static String INNSTOCKCODE_TEST = "260044611";
    public final static String TAB_KLINE_TYPE = "tabKLineType";
    public final static String INN_STOCK_CODE = "innStockCode";
    public final static String CHARTS_ENTITY = "chartsEntity";
    public final static String STOCK_NAME = "stockName";
    public final static String INDEX_ID = "indexId";
    public final static String LSH = "LSH";
    public final static int TAB_KLINE_MENU_MIN = 1;
    public final static int TAB_KLINE_MENU_DAY = 2;
    public final static int TAB_KLINE_MENU_5D = 3;
    public static final int HQCHART_RUP_GDOWN = 0;// 红涨绿跌
    public static final int HQCHART_GUP_RDOWN = 1;// 绿涨红跌


    public static final int SECU_TYPE_STOCK_INDEX = 1; //指数
    // 用户设置刷新类型
    public final static int RESFRESH_TIMTE_NONE = 0;
    public final static int RESFRESH_TIMTE_5S = 5000;
    public final static int RESFRESH_TIMTE_10S = 10000;
    public final static int RESFRESH_TIMTE_30S = 30000;
    public final static int RESFRESH_TIMTE_1M = 60000;


    // KLine 分时图类型
    public final static int KLINE_CHARTS_TYPE_NORMAL = 0;
    public final static int KLINE_CHARTS_TYPE_SMALL = 1;
    public final static int KLINE_CHARTS_TYPE_TAPE = 2;
    // 数据域定义
    public static final String DATA_ERRCODE = "errcode"; // 返回标识：0-成功，其他错误
    public static final String DATA_ERRMSG = "errmsg";
    public static final String RETCODE_OK = "0"; // 返回标识：0-成功，其他错误
    public static final String RETCODE_ERR = "1";
    // =============================================================================
    public static final DecimalFormat stockCodeFormat = new DecimalFormat("000000");
    public static final DecimalFormat priceFormat = new DecimalFormat("#0.00");
    public static final DecimalFormat precentFormat = new DecimalFormat("#0.00%");
    public static final DecimalFormat mountFormat = new DecimalFormat("###0");
    public static final DecimalFormat changeFormat = new DecimalFormat("+#0.0#;-#0.0#");
    public static final DecimalFormat changePercentFormat = new DecimalFormat("+#0.00%;-#0.00%");
    public static final DecimalFormat volumeFormat = new DecimalFormat("#0");
    public static final DecimalFormat timeFormat = new DecimalFormat("000000");
    public static final DecimalFormat dateFormat = new DecimalFormat("00000000");
    // 价格带正，负号
    public static final DecimalFormat priceFormatWithSymbol = new DecimalFormat("+#0.00;-#0.00");
    public static final DecimalFormat reserves2Format = new DecimalFormat("#.00");
    public static final String FUNC_MARKET_DETAIL_HQ_DATA = "funcMarketDetailHq";


    //-----------------------------------------数据字典---------------------------------------------
    //近序方向 DIRECTOR
    public static final String DIRECTOR_ASC = "0"; // 正序
    public static final String DIRECTOR_DESC = "1"; // 近序

    //行情类型 HQ_TYPE
    public static final String HQ_TYPE_HMT_1 = "HMT1"; // 正序
    public static final String HQ_TYPE_HMT_2 = "HMT2"; // 近序
    public static final String HQ_TYPE_SBA_1 = "SBA1"; // 近序

    //当天或历史 DATE_TYPE
    public static final String DATE_TYPE_ALL = "0"; // 当天及历史
    public static final String DATE_TYPE_CUR = "1"; // 当天
    public static final String DATE_TYPE_HIS = "2"; // 历史

    //周期 PERIOD_ID
    public static final String PERIOD_ID_DAY = "D"; //
    public static final String PERIOD_ID_WEEK = "W"; // 正序
    public static final String PERIOD_ID_MONTH = "m"; // 正序

    //指数代码
    public final static String MARKET_STOCK_CODE_SH = "000001";//上证指数
    public final static String MARKET_STOCK_CODE_SZ = "399001";//深圳成指
    public final static String MARKET_STOCK_CODE_CY = "399006";//创业板指

    // 市场行情类别(MARKET)
    public static final String MARKET_SH_A = "1"; // 沪A
    public static final String MARKET_SZ_A = "2"; // 深A
    public static final String MARKET_SH_B = "3"; // 沪B
    public static final String MARKET_SZ_B = "4"; // 深B
    public static final String MARKET_SZ_FUND = "6"; // 深基金
    public static final String MARKET_SH_FUND = "5"; // 沪基金
    public static final String MARKET_BLOCK = "21"; // 板块

    //停牌标志 SUSP_FLAG
    public final static String SUSP_FLAG_NORMAL = "0";  //正常
    public final static String SUSP_FLAG_SUSPENDED = "66"; //停牌

    //股票类型(SECU_TYPE)
    public final static int SECU_TYPE_TRADE_STOCK_INDEX = 1;   //交易所指数
    public final static int SECU_TYPE_OTHER_STOCK_INDEX = 15;  //其他指数
    public final static int SECU_TYPE_STOCK_A = 16;  //A股
    public final static int SECU_TYPE_STOCK_ZXB = 17;  //中小板股
    public final static int SECU_TYPE_STOCK_CYB = 18;  //创业板股
    public final static int SECU_TYPE_STOCK_BLOCK = 21;  //板块
    public final static int SECU_TYPE_STOCK_B = 22;  //B股
    public final static int SECU_TYPE_STOCK_H = 23;  //H股
    public final static int SECU_TYPE_STOCK_OTHER = 31;  //其他股票

    //板块 BLOCK_ID
    public final static int BLOCK_ID_A = 60;  //沪深A
    public final static int BLOCK_ID_SH_A = 61;  //沪A
    public final static int BLOCK_ID_SZ_A = 63;  //深A
    public final static int BLOCK_ID_SZ_CYB = 631;  //创业板

    //排序字段(SORT_FIELD)
    public final static int SORT_FIELD_SECU_CODE = 1; //证券代码
    public final static int SORT_FIELD_SECU_NAME = 2; //证券名称
    public final static int SORT_FIELD_LAST_PRICE = 3; //最新价
    public final static int SORT_FIELD_RISE_LMT = 4; //涨幅
    public final static int SORT_FIELD_CHANGE = 5; //涨跌
    public final static int SORT_FIELD_RISE_SP = 6; //涨速
    public final static int SORT_FIELD_APL_BID_PRC = 7; //买价
    public final static int SORT_FIELD_APL_SELL_PRC = 8; //卖价
    public final static int SORT_FIELD_BGN_TOT_NUM = 9; //成交总量
    public final static int SORT_FIELD_NEWVOL = 10; //现手
    public final static int SORT_FIELD_TURNOVER_RATE = 11; //换手率
    public final static int SORT_FIELD_VOLUME_RATIO = 12; //量比
    public final static int SORT_FIELD_PE_RATIO = 13; //市盈(动)
    public final static int SORT_FIELD_AMPLITUDE = 14; //振幅
    public final static int SORT_FIELD_ZRSP = 15; //昨日收盘价
    public final static int SORT_FIELD_JRKP = 16; //今日开盘价
    public final static int SORT_FIELD_MAXP = 17; //最高价
    public final static int SORT_FIELD_MINP = 18; //最低价
    public final static int SORT_FIELD_CJJE = 19; //成交总金额
    public final static int SORT_FIELD_INVOL = 20; //内盘
    public final static int SORT_FIELD_OUTVOL = 21; //外盘
    public final static int SORT_FIELD_TOT_MARET_VALUE = 22; //总市值
    public final static int SORT_FIELD_CUR_MARET_VALUE = 23; //流通市值

    public final static String KWL_KEY = "RSAKEY";

    // 近序方向(DIRECTOR)
    public static final String DIRECTOR_ = "1"; // 沪A

    public static final String FOLDER_NAME = "quotation";
    public static final String CACHE_APP = "cache";

    private QuoteConstant() {
    }
}
