package com.javacto.po;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class DangdangProductCategory implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "DPC_ID", type = IdType.AUTO)
    private Integer dpcId;

    @TableField("DPC_NAME")
    private String dpcName;

    @TableField("DPC_PARENT_ID")
    private Integer dpcParentId;


}
