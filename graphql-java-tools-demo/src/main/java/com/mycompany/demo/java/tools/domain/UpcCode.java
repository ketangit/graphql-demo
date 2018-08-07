package com.mycompany.demo.java.tools.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Table(indexes = {@Index(name = "I_UpcCode_BarCode", columnList = "BarCode", unique = true)})
@Entity
@IdClass(UpcCodePK.class)
public class UpcCode {

    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "UPCCodeID")
    private int upcCodeId;

    @NotNull
    @Id
    @Column(name = "ItemID")
    private int itemId;

    @NotNull
    @Size(max = 20)
    @Basic
    @Column(name = "BarCode")
    private String barCode;

    @Basic
    @Column(name = "DBTimeStamp")
    private Timestamp dbTimeStamp;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ItemID", referencedColumnName = "ItemID", foreignKey = @ForeignKey(name = "FK_UpcCode_Item"), insertable = false, updatable = false)
    private Item item;

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

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Timestamp getDbTimeStamp() {
        return dbTimeStamp;
    }

    public void setDbTimeStamp(Timestamp dbTimeStamp) {
        this.dbTimeStamp = dbTimeStamp;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpcCode upcCode = (UpcCode) o;

        if (upcCodeId != upcCode.upcCodeId) return false;
        if (itemId != upcCode.itemId) return false;
        if (!barCode.equals(upcCode.barCode)) return false;
        if (dbTimeStamp != null ? !dbTimeStamp.equals(upcCode.dbTimeStamp) : upcCode.dbTimeStamp != null) return false;
        return item.equals(upcCode.item);
    }

    @Override
    public int hashCode() {
        int result = upcCodeId;
        result = 31 * result + itemId;
        result = 31 * result + barCode.hashCode();
        result = 31 * result + (dbTimeStamp != null ? dbTimeStamp.hashCode() : 0);
        result = 31 * result + item.hashCode();
        return result;
    }
}
