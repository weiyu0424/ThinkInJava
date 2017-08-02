package com.weiyu.offer.proxy;

/**
 * Created by Wei Yu on 2017/7/31.
 */
public class DBQueryProxy implements IDBQuery {
    private DBQuery query = null;

    @Override
    public String request() {
        System.out.println("Proxy begins");
        if(null == query)
            query = new DBQuery();
        String result = query.request();
        System.out.println("Proxy End");
        return result;
    }

    @Override
    public void query() {

    }

}
