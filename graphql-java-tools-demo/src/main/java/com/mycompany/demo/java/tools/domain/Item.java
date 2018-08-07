package com.mycompany.demo.java.tools.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(indexes = {@Index(name = "I_Item_ItemNumber", columnList = "ItemNumber", unique = true)})
@Entity
public class Item {

    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "ItemID")
    private int itemId;

    @NotNull
    @Basic
    @Column(name = "ItemNumber")
    private int itemNumber;

    @NotNull
    @Basic
    @Column(name = "AlternateItemNumber")
    private int alternateItemNumber;

    @NotNull
    @Size(max = 50)
    @Basic
    @Column(name = "Description")
    private String description;

    @Size(max = 30)
    @Basic
    @Column(name = "Winery")
    private String winery;

    @Size(max = 4)
    @Basic
    @Column(name = "Vintage")
    private String vintage;

    @NotNull
    @Digits(integer = 2, fraction = 2)
    @Basic
    @Column(name = "Markup", precision = 2, scale = 2)
    private Double markup;

    @Digits(integer = 2, fraction = 2)
    @Basic
    @Column(name = "Weight", precision = 2, scale = 2)
    private Double weight;

    @NotNull
    @Basic
    @Column(name = "WebItem")
    private boolean webItem;

    @NotNull
    @Basic
    @Column(name = "Inactive")
    private boolean inactive;

    @NotNull
    @Basic
    @Column(name = "Taxable")
    private boolean taxable;

    @Lob
    @Column(name = "PictureFile")
    private String pictureFile;

    @Lob
    @Column(name = "Notes")
    private String notes;

    @NotNull
    @Digits(integer = 6, fraction = 2)
    @Basic
    @Column(name = "RetailCasePrice", precision = 6, scale = 2)
    private BigDecimal retailCasePrice;

    @NotNull
    @Digits(integer = 6, fraction = 2)
    @Basic
    @Column(name = "RetailPackPrice", precision = 6, scale = 2)
    private BigDecimal retailPackPrice;

    @NotNull
    @Digits(integer = 6, fraction = 2)
    @Basic
    @Column(name = "RetailUnitPrice", precision = 6, scale = 2)
    private BigDecimal retailUnitPrice;

    @NotNull
    @Basic
    @Column(name = "UnitPerCase")
    private int unitPerCase;

    @NotNull
    @Basic
    @Column(name = "UnitPerPack")
    private int unitPerPack;

    @NotNull
    @Basic
    @Column(name = "PackPerCase")
    private int packPerCase;

    @Basic
    @Column(name = "DateCreated")
    private LocalDateTime dateCreated;

    @Basic
    @Column(name = "DBTimeStamp")
    private LocalDateTime dbTimeStamp;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID", foreignKey = @ForeignKey(name = "FK_Item_Department"))
    private Department department;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "SubDepartmentID", referencedColumnName = "SubDepartmentID", foreignKey = @ForeignKey(name = "FK_Item_SubDepartment"))
    private SubDepartment subDepartment;

    @ManyToOne
    @JoinColumn(name = "SizeCodeID", referencedColumnName = "SizeCodeID", foreignKey = @ForeignKey(name = "FK_Item_SizeCodeDefinition"))
    private SizeCodeDefinition sizeCodeDefinition;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getAlternateItemNumber() {
        return alternateItemNumber;
    }

    public void setAlternateItemNumber(int alternateItemNumber) {
        this.alternateItemNumber = alternateItemNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWinery() {
        return winery;
    }

    public void setWinery(String winery) {
        this.winery = winery;
    }

    public String getVintage() {
        return vintage;
    }

    public void setVintage(String vintage) {
        this.vintage = vintage;
    }

    public Double getMarkup() {
        return markup;
    }

    public void setMarkup(Double markup) {
        this.markup = markup;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public boolean isWebItem() {
        return webItem;
    }

    public void setWebItem(boolean webItem) {
        this.webItem = webItem;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public String getPictureFile() {
        return pictureFile;
    }

    public void setPictureFile(String pictureFile) {
        this.pictureFile = pictureFile;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BigDecimal getRetailCasePrice() {
        return retailCasePrice;
    }

    public void setRetailCasePrice(BigDecimal retailCasePrice) {
        this.retailCasePrice = retailCasePrice;
    }

    public BigDecimal getRetailPackPrice() {
        return retailPackPrice;
    }

    public void setRetailPackPrice(BigDecimal retailPackPrice) {
        this.retailPackPrice = retailPackPrice;
    }

    public BigDecimal getRetailUnitPrice() {
        return retailUnitPrice;
    }

    public void setRetailUnitPrice(BigDecimal retailUnitPrice) {
        this.retailUnitPrice = retailUnitPrice;
    }

    public int getUnitPerCase() {
        return unitPerCase;
    }

    public void setUnitPerCase(int unitPerCase) {
        this.unitPerCase = unitPerCase;
    }

    public int getUnitPerPack() {
        return unitPerPack;
    }

    public void setUnitPerPack(int unitPerPack) {
        this.unitPerPack = unitPerPack;
    }

    public int getPackPerCase() {
        return packPerCase;
    }

    public void setPackPerCase(int packPerCase) {
        this.packPerCase = packPerCase;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDbTimeStamp() {
        return dbTimeStamp;
    }

    public void setDbTimeStamp(LocalDateTime dbTimeStamp) {
        this.dbTimeStamp = dbTimeStamp;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public SubDepartment getSubDepartment() {
        return subDepartment;
    }

    public void setSubDepartment(SubDepartment subDepartment) {
        this.subDepartment = subDepartment;
    }

    public SizeCodeDefinition getSizeCodeDefinition() {
        return sizeCodeDefinition;
    }

    public void setSizeCodeDefinition(SizeCodeDefinition sizeCodeDefinition) {
        this.sizeCodeDefinition = sizeCodeDefinition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (itemId != item.itemId) return false;
        if (itemNumber != item.itemNumber) return false;
        if (alternateItemNumber != item.alternateItemNumber) return false;
        if (webItem != item.webItem) return false;
        if (inactive != item.inactive) return false;
        if (taxable != item.taxable) return false;
        if (unitPerCase != item.unitPerCase) return false;
        if (unitPerPack != item.unitPerPack) return false;
        if (packPerCase != item.packPerCase) return false;
        if (!description.equals(item.description)) return false;
        if (winery != null ? !winery.equals(item.winery) : item.winery != null) return false;
        if (!vintage.equals(item.vintage)) return false;
        if (markup != null ? !markup.equals(item.markup) : item.markup != null) return false;
        if (weight != null ? !weight.equals(item.weight) : item.weight != null) return false;
        if (pictureFile != null ? !pictureFile.equals(item.pictureFile) : item.pictureFile != null) return false;
        if (notes != null ? !notes.equals(item.notes) : item.notes != null) return false;
        if (!retailCasePrice.equals(item.retailCasePrice)) return false;
        if (!retailPackPrice.equals(item.retailPackPrice)) return false;
        if (!retailUnitPrice.equals(item.retailUnitPrice)) return false;
        if (!dateCreated.equals(item.dateCreated)) return false;
        if (dbTimeStamp != null ? !dbTimeStamp.equals(item.dbTimeStamp) : item.dbTimeStamp != null) return false;
        if (!department.equals(item.department)) return false;
        if (!subDepartment.equals(item.subDepartment)) return false;
        return sizeCodeDefinition.equals(item.sizeCodeDefinition);
    }

    @Override
    public int hashCode() {
        int result = itemId;
        result = 31 * result + itemNumber;
        result = 31 * result + alternateItemNumber;
        result = 31 * result + description.hashCode();
        result = 31 * result + (winery != null ? winery.hashCode() : 0);
        result = 31 * result + vintage.hashCode();
        result = 31 * result + (markup != null ? markup.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (webItem ? 1 : 0);
        result = 31 * result + (inactive ? 1 : 0);
        result = 31 * result + (taxable ? 1 : 0);
        result = 31 * result + (pictureFile != null ? pictureFile.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + retailCasePrice.hashCode();
        result = 31 * result + retailPackPrice.hashCode();
        result = 31 * result + retailUnitPrice.hashCode();
        result = 31 * result + unitPerCase;
        result = 31 * result + unitPerPack;
        result = 31 * result + packPerCase;
        result = 31 * result + dateCreated.hashCode();
        result = 31 * result + (dbTimeStamp != null ? dbTimeStamp.hashCode() : 0);
        result = 31 * result + department.hashCode();
        result = 31 * result + subDepartment.hashCode();
        result = 31 * result + sizeCodeDefinition.hashCode();
        return result;
    }
}
