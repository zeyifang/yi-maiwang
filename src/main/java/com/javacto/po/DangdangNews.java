package com.javacto.po;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class DangdangNews implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "DN_ID", type = IdType.AUTO)
    private Integer dnId;

    @TableField("DN_TITLE")
    private String dnTitle;

    @TableField("DN_CONTENT")
    private String dnContent;

    @TableField("DN_CREATE_TIME")
    private Date dnCreateTime=new Date();


}
