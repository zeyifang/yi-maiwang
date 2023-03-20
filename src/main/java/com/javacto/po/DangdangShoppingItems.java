package com.javacto.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Auther: zj
 * @Date: 2023-02-13 - 02 - 13 - 13:25
 * @Description: com.javacto.po
 * @version: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DangdangShoppingItems {
    private DangdangProduct dangdangProduct;
}
