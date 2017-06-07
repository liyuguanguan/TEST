package com.ygjt.gdn.ftisp.api.b2s2c.service;

import com.alibaba.fastjson.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Je on 2016/9/21.
 */
@Service
public class B2S2CApiClientService {
    public static final String CONTENTTYPE = "application/json";
    public static final String CHARSET = "UTF-8";
    public String post(Map<String,String> headers, Map<String,String> params, Object model, String url){
        String result = null;
        PostMethod post= null;
        try{
            post = new PostMethod(url);
            String postData = "";
            if(model instanceof List){
                postData = JSONArray.toJSONString(model);
            }else {
                postData = JSONObject.fromObject(model).toString();
            }
            StringRequestEntity entity = new StringRequestEntity(postData, CONTENTTYPE, CHARSET);
            post.setRequestEntity(entity);

            if(headers!=null) {
                for (String key : headers.keySet()) {
                    if(headers.get(key)!=null) {
                        post.addRequestHeader(key, headers.get(key));
                    }
                }
            }

            if(params!=null) {
                for (String key : params.keySet()) {
                    if(params.get(key)!=null) {
                        post.addParameter(new NameValuePair(key, params.get(key)));
                    }
                }
            }

            if(model == null){
                post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
            }else {
                post.addRequestHeader("Content-Type", "application/json");
            }
            HttpClient client = new HttpClient();
            int statusCode = client.executeMethod(post);
            //if(statusCode == HttpStatus.SC_OK){
                result = IOUtils.toString(post.getResponseBodyAsStream());
            //}
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(post != null) {
                post.abort();
            }
        }
        return result;
    }
}
