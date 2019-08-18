package com.len.pdms.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name="pdms_tenant")
@Data
@ToString
@EqualsAndHashCode
public class Tenant {
    //id
    @Id
    @Column
    private String id;
    //项目名称
    @Column(name="tenant_name")
    private String tenantName;
    //创建时间
    @Column(name="create_date")
    private Date creatDate;

}
