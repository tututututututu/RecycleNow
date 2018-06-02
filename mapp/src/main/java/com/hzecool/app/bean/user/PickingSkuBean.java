package com.hzecool.app.bean.user;

/**
 *
 * @author song
 * @date 2017/11/3
 */

public class PickingSkuBean {
    private String dressId;
    private String colorId;
    private String sizeId;
    private boolean isSale;
    private String name;
    private String colorName;
    private String sizeName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getDressId() {
        return dressId;
    }

    public void setDressId(String dressId) {
        this.dressId = dressId;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getSizeId() {
        return sizeId;
    }

    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
    }

    @Override
    public String toString() {
        return "PickingSkuBean{" +
                "dressId='" + dressId + '\'' +
                ", colorId='" + colorId + '\'' +
                ", sizeId='" + sizeId + '\'' +
                ", isSale=" + isSale +
                ", name='" + name + '\'' +
                ", colorName='" + colorName + '\'' +
                ", sizeName='" + sizeName + '\'' +
                '}';
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean aReturn) {
        isSale = aReturn;
    }
}
