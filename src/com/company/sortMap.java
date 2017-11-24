package com.company;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import static java.net.URLEncoder.*;
import com.company.md5Test;

public class sortMap{
    public static String createLinkStringByGet(Map<String ,String> param)
    {
        //定义一个拼接的字符串
        String prestr="";
        String secret="SP-INNER";
        //取出parm所有的key
        List<String> keys=new ArrayList<String>(param.keySet());
        //排序
        Collections.sort(keys);

        for(int i=0;i<keys.size();i++){
            //取出key和value
            String key=keys.get(i);
            String value=param.get(key);
            //拼接字符串

                //urlencode
                //key=encode(key,"UTF-8");
                //value= encode(value,"UTF-8");
             prestr = prestr + key + value;
        }
        //两头拼接secre字段
        return secret+prestr+secret;
    }

    //设置时间戳
    public String setTimestamp() {
        Long sp = System.currentTimeMillis();
        String timestamp = sp.toString();
        return timestamp;
    }

    //设置加密参数
    public String setParam()
    {
        Map<String,String> map= new HashMap<String,String>();
        map.put("apiName", "trade.order.get");
        map.put("appKey", "SP");
        map.put("format", "json");
        map.put("id", "2110021504012865041");
        map.put("session", "SP_TEST");
        map.put("timestamp", setTimestamp());
        map.put("v", "1.0.0");
        map.put("session", "123456");
        //打印请求参数系列
        //System.out.println(createLinkStringByGet(map));
        //打印加密后的字符串
        System.out.println(sortMap.getSign(map));

        return createLinkStringByGet(map);
    }


    //MD5加密
    public static String getSign(Map<String,String> map)
    {
        System.out.println(createLinkStringByGet(map));
        return  md5Test.MD5(createLinkStringByGet(map));
    }

}

