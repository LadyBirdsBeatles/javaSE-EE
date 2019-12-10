package com.itoyokado.cms.entity;

/**
 * 地图信息
 */
public class T_Map {
    //主键id
    private Integer id;
    //区域名称
    private String mapName;
    //地图坐标
    private String coordinate;
    //颜色值
    private String colorValue;

    public T_Map() {
    }
    public T_Map(Integer id, String mapName, String coordinate, String colorValue) {
        this.id = id;
        this.mapName = mapName;
        this.coordinate = coordinate;
        this.colorValue = colorValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getColorValue() {
        return colorValue;
    }

    public void setColorValue(String colorValue) {
        this.colorValue = colorValue;
    }

}
