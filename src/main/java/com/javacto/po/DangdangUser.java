package com.javacto.po;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author adam8831
 * @since 2023-02-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DangdangUser implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "Du_user_id", type = IdType.AUTO)
    private Integer duUserId;

    @TableField("DU_EMAIL")
    private String duEmail;

    @TableField("DU_USER_NAME")
    private String duUserName;

    @TableField("DU_PASSWORD")
    private String duPassword;

    @TableField("DU_SEX")
    private String duSex;

    @TableField("DU_BIRTHDAY")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date duBirthday=new Date();

    @TableField("DU_IDENTITY_CODE")
    private String duIdentityCode;

    @TableField("DU_MOBILE")
    private String duMobile;

    @TableField("DU_createtime")
    private Date duCreatetime;

    @TableField("DU_createuser")
    private Date duCreateuser;

    @TableField("DU_updatetime")
    private Date duUpdatetime;

    @TableField("DU_updateuser")
    private Date duUpdateuser;

    @TableField("DU_STATUS")
    private Integer duStatus;

    /**
     * 备用字段1
     */
    @TableField("DU_ADDRESS")
    private String duAddress;

    /**
     * 备用字段2
     */
    @TableField("DU_new2")
    private Integer duNew2;

    /**
     * 备用字段3
     */
    @TableField("DU_new3")
    private String duNew3;

    /**
     * 备用字段4
     */
    @TableField("DU_new4")
    private String duNew4;

    /**
     * 备用字段5
     */
    @TableField("DU_new5")
    private String duNew5;


}
