package com.languohui.lgh.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2021-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("lsd_app_fimage")
public class Fimage extends Model<Fimage> {

    private static final long serialVersionUID=1L;

    /**
     * 门店的图片表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图片的code
     */
    private String imgcode;

    /**
     * 门店的code
     */
    private String faccode;

    /**
     * 编号
     */
    private String code;

    /**
     * 图片的排序
     */
    private Integer sort;

    /**
     * 是否删除
     */
    private Integer isdelete;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
