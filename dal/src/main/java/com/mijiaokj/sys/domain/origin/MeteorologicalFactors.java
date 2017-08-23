package com.mijiaokj.sys.domain.origin;

import com.mijiaokj.sys.domain.ReferenceObject;

/**
 *
 * @ClassName: MeteorologicalFactors
 * @Description: TODO 气象要素表
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年08月08日
 * 气象要素记录
 * land_id     bigint(20) unsigned not null comment '土地id',
 * temperature     varchar(64)  not null comment '温度',
 * illumination_time    varchar(64)  not null comment '光照时间',
 * relative_humidity    varchar(64)  not null  comment '相对湿度',
 * wind_speed      varchar(64)  not null comment '风速',
 * photosynthetic_intensity     varchar(64)   comment '光合强度',
 * respiration_intensity   varchar(64) comment '呼吸强度',
 * precipitation     varchar(1024)  comment '降水量',
 * */
public class MeteorologicalFactors extends ReferenceObject {
    private Long landId;
    private String temperature;
    private String illuminationTime;
    private String relativeHumidity;
    private String windSpeed;
    private String photosyntheticIntensity;
    private String respirationIntensity;
    private String precipitation;

    public Long getLandId() {
        return landId;
    }

    public void setLandId(Long landId) {
        this.landId = landId;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getIlluminationTime() {
        return illuminationTime;
    }

    public void setIlluminationTime(String illuminationTime) {
        this.illuminationTime = illuminationTime;
    }

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(String relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getPhotosyntheticIntensity() {
        return photosyntheticIntensity;
    }

    public void setPhotosyntheticIntensity(String photosyntheticIntensity) {
        this.photosyntheticIntensity = photosyntheticIntensity;
    }

    public String getRespirationIntensity() {
        return respirationIntensity;
    }

    public void setRespirationIntensity(String respirationIntensity) {
        this.respirationIntensity = respirationIntensity;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }
}
