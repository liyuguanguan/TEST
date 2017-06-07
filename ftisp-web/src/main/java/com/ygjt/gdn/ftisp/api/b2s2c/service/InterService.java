
package com.ygjt.gdn.ftisp.api.b2s2c.service;

/**
 * 调用外部接口类
 * Created by Je on 2016/9/9.
 */
public interface InterService<S,V>   {
    V call(S req);
    V call(S req, String token);
    V handleResult(String resp);
}
