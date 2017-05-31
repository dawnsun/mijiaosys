package com.mijiaokj.sys.common.util;

/**
 * Created by sunchenguang on 2017/5/31.
 */

import com.mijiaokj.sys.common.constants.MiJiaoException;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 */
public class BeanCopyUtil {
    public static void copy(Object source, Object target) {
        try{
            BeanUtils.copyProperties(source, target);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Object populateBean(Map map, Object object) throws MiJiaoException {
        try {
            org.apache.commons.beanutils.BeanUtils.populate(object, map);
        } catch (Exception e) {
            throw new MiJiaoException("Bean convert from map to object error");
        }
        return object;
    }

    /*public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        Object object = new Object();
        kv kv1 = new kv();
        try {
            BeanCopyUtil.populateBean(map, object);
        } catch (MiJiaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(object.getClass().getMethods());
    }*/

}

class kv implements Serializable{
    private String k1;
    private String k2;
    public String getK1() {
        return k1;
    }
    public void setK1(String k1) {
        this.k1 = k1;
    }
    public String getK2() {
        return k2;
    }
    public void setK2(String k2) {
        this.k2 = k2;
    }

}
