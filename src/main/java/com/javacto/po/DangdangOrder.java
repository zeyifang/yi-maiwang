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
public class DangdangOrder implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "DO_ID", type = IdType.AUTO)
    private Integer doId;

    @TableField("DO_Number")
    private String doNumber;

    @TableField("DO_USER_ID")
    private String doUserId;

    @TableField("DO_USER_NAME")
    private String doUserName;

    @TableField("DO_USER_TEL")
    private String doUserTel;

    @TableField("DO_USER_ADDRESS")
    private String doUserAddress;

    @TableField("DO_COST")
    private Double doCost;

    @TableField("DO_CREATE_TIME")
    private Date doCreateTime= new Date();

    @TableField("DO_STATUS")
    private Integer doStatus;

    @TableField("DO_TYPE")
    private Integer doType;


}
