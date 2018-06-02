package com.hzecool.app.bean.event;

import java.math.BigDecimal;

/**
 * Created by wangzhiguo on 2017/6/23
 */
public class UpdateSkuEvent extends BaseEvent {

    private String id;

    private boolean isSaleReturn;

    public boolean isSaleReturn() {
        return isSaleReturn;
    }

    public void setSaleReturn(boolean saleReturn) {
        isSaleReturn = saleReturn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String colorId;
    private String sizeId;

    private BigDecimal count;
    private BigDecimal orignalPrice;
    private BigDecimal discount;
    private String     remark;

    private BigDecimal saleReturnCount;
    private String     saleReturnRemark;
    private BigDecimal saleReturnDiscount;
    private BigDecimal saleReturnPrice;
    private String priceType;

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getOrignalPrice() {
        return orignalPrice;
    }

    public void setOrignalPrice(BigDecimal orignalPrice) {
        this.orignalPrice = orignalPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getSaleReturnCount() {
        return saleReturnCount;
    }

    public void setSaleReturnCount(BigDecimal saleReturnCount) {
        this.saleReturnCount = saleReturnCount;
    }

    public String getSaleReturnRemark() {
        return saleReturnRemark;
    }

    public void setSaleReturnRemark(String saleReturnRemark) {
        this.saleReturnRemark = saleReturnRemark;
    }

    public BigDecimal getSaleReturnDiscount() {
        return saleReturnDiscount;
    }

    public void setSaleReturnDiscount(BigDecimal saleReturnDiscount) {
        this.saleReturnDiscount = saleReturnDiscount;
    }

    public BigDecimal getSaleReturnPrice() {
        return saleReturnPrice;
    }

    public void setSaleReturnPrice(BigDecimal saleReturnPrice) {
        this.saleReturnPrice = saleReturnPrice;
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
}
