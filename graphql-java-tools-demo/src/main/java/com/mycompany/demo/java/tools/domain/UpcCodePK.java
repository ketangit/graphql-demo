package com.mycompany.demo.java.tools.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UpcCodePK implements Serializable {

    @NotNull
    @Id
    @Column(name = "UPCCodeID")
    private int upcCodeId;

    @NotNull
    @Id
    @Column(name = "ItemID")
    private int itemId;

    public int getUpcCodeId() {
        return upcCodeId;
    }

    public void setUpcCodeId(int upcCodeId) {
        this.upcCodeId = upcCodeId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpcCodePK upcCodePK = (UpcCodePK) o;

        if (upcCodeId != upcCodePK.upcCodeId) return false;
        return itemId == upcCodePK.itemId;
    }

    @Override
    public int hashCode() {
        int result = upcCodeId;
        result = 31 * result + itemId;
        return result;
    }
}
