package com.javacto.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

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
public class DangdangShopping implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "DOD_ID", type = IdType.AUTO)
    private Integer dodId;

    @TableField("DO_USER_ID")
    private Integer doUserId;

    @TableField("DP_ID")
    private Integer dpId;

    @TableField("DOD_QUANTITY")
    private Integer dodQuantity;

    @TableField("DOD_COST")
    private Double dodCost;

    @TableField("DO_STATE")
    private Integer doState;

    private DangdangProduct Product;


}
