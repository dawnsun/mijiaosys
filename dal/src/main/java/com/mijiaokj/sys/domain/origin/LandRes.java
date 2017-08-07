package com.mijiaokj.sys.domain.origin;

import com.mijiaokj.sys.domain.ReferenceObject;

/**
 *
 * @ClassName: SysUser
 * @Description: TODO 土地资源表
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年08月07日
 * longitude            varchar(16)  comment '经度',
 * latitude             varchar(16)  comment '纬度',
 * altitude             varchar(16)  comment '海拔',
 * alias                varchar(32)  comment '土地别名',
 * address              varchar(128)  comment '土地详细地址',
 * size                 varchar(16)  comment '面积大小',
 *
 */
public class LandRes extends ReferenceObject {
    private String longitude;
    private String latitude;
    private String altitude;
    private String alias;
    private String address;
    private String siza;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSiza() {
        return siza;
    }

    public void setSiza(String siza) {
        this.siza = siza;
    }
}
