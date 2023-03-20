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
public class DangdangProduct implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "DP_ID", type = IdType.AUTO)
    private Integer dpId;

    @TableField("DP_NAME")
    private String dpName;

    @TableField("DP_DESCRIPTION")
    private String dpDescription;

    @TableField("DP_PRICE")
    private Double dpPrice;

    @TableField("DP_STOCK")
    private Integer dpStock;

    @TableField("DPC_CHILD_ID")
    private Integer dpcChildId;

    @TableField("DP_FILE_NAME")
    private String dpFileName;


}
