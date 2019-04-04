package com.stone.stonemusic.data;

/*歌词界面状态常量*/
public interface LrcStateContants {
    public static final int READ_LOC_FAIL=0;    //本地查找不到歌词或者查询异常
    public static final int READ_LOC_OK=1;
    public static final int QUERY_ONLINE=2; //正在联网查找
    public static final int QUERY_ONLINE_OK=3;
    public static final int QUERY_ONLINE_NULL=4;    //网络无歌词
    public static final int QUERY_ONLINE_FAIL=5; //联网查找失败
}
