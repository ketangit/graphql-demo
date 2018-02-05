package com.mycompany.demo.graphql.model;

import com.mycompany.demo.graphql.utils.SchemaUtils;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

import java.util.Date;

@GraphQLName(SchemaUtils.TREE)
public class Tree {
    @GraphQLField
    private long treeid;
    @GraphQLField
    private Date plantdate;
    @GraphQLField
    private String qaddress;
    @GraphQLField
    private String qlegalstatus;
    @GraphQLField
    private String qsiteinfo;
    @GraphQLField
    private String qspecies;
    @GraphQLField
    private String planttype;
    @GraphQLField
    private long siteorder;

    public long getTreeid() {
        return treeid;
    }

    public void setTreeid(long treeid) {
        this.treeid = treeid;
    }

    public Date getPlantdate() {
        return plantdate;
    }

    public void setPlantdate(Date plantdate) {
        this.plantdate = plantdate;
    }

    public String getQaddress() {
        return qaddress;
    }

    public void setQaddress(String qaddress) {
        this.qaddress = qaddress;
    }

    public String getQlegalstatus() {
        return qlegalstatus;
    }

    public void setQlegalstatus(String qlegalstatus) {
        this.qlegalstatus = qlegalstatus;
    }

    public String getQsiteinfo() {
        return qsiteinfo;
    }

    public void setQsiteinfo(String qsiteinfo) {
        this.qsiteinfo = qsiteinfo;
    }

    public String getQspecies() {
        return qspecies;
    }

    public void setQspecies(String qspecies) {
        this.qspecies = qspecies;
    }

    public String getPlanttype() {
        return planttype;
    }

    public void setPlanttype(String planttype) {
        this.planttype = planttype;
    }

    public long getSiteorder() {
        return siteorder;
    }

    public void setSiteorder(long siteorder) {
        this.siteorder = siteorder;
    }
}
