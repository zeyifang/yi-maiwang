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
public class DangdangComment implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "DU_ID", type = IdType.AUTO)
    private Integer duId;

    @TableField("DP_ID")
    private Integer dpId;

    @TableField("DU_comment_NAME")
    private String duCommentName;

    @TableField("DU_CONTENT")
    private String duContent;

    @TableField("DU_answer_content")
    private String duAnswerContent;

    @TableField("DU_CREATE_TIME")
    private Date duCreateTime=new Date();

    @TableField("DU_reply_TIME")
    private Date duReplyTime;


}
