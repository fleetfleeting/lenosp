package com.len.pdms.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.hibernate.validator.constraints.CodePointLength;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name="pdms_tenant_user")//映射数据库
@Data
@ToString
@EqualsAndHashCode
public class TenantUser {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="tenant_id")
    private String tenantId;
    @Column(name="user_id")
    private String userId;
    @Column(name="is_admin")
    private int isAdmin;
    @Column(name="create_date")
    private Date createDate;
}
