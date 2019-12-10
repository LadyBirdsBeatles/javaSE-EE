package com.itoyokado.cms.entity;

/**
 * 地图信息
 */
public class B_Map {
    private String mapName;
    private String coordinate;
    private String mapColor;

    public B_Map(){

    }

    public B_Map(String mapName, String coordinate, String mapColor) {
        this.mapName = mapName;
        this.coordinate = coordinate;
        this.mapColor = mapColor;
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

    public String getMapColor() {
        return mapColor;
    }

    public void setMapColor(String mapColor) {
        this.mapColor = mapColor;
    }
}
