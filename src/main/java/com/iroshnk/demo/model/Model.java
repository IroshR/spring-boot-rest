package com.iroshnk.demo.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Model {

    public static final int SCALE = 20;
    public static final int PRECISION = 5;
    public static final String VALUE_TYPE = "DECIMAL(20, 5)";

    @Column(name = "merchantId", updatable = false, nullable = false, columnDefinition = "SMALLINT(5) UNSIGNED default '0'")
    protected int merchantId;
    @Column(name = "branchId", updatable = false, nullable = false, columnDefinition = "SMALLINT(5) UNSIGNED default '0'")
    protected int branchId;
    @Column(name = "status", nullable = false, columnDefinition = "TINYINT(2) UNSIGNED default '0'")
    protected short status;

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}
