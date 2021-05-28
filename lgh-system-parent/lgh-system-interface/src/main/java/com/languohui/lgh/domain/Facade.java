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
@TableName("lsd_app_facade")
public class Facade extends Model<Facade> {

    private static final long serialVersionUID=1L;

    /**
     * 门店表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 门店的code
     */
    private String code;

    /**
     * 精度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 门店名称
     */
    private String fname;

    /**
     * 名店详细地址
     */
    private String adress;

    /**
     * 门店联系电话
     */
    private String phone;

    /**
     * 门店主图
     */
    private String fimgCode;

    /**
     * 是否删除
     */
    private Integer isdelete;

    /**
     * 门店的介绍
     */
    private String fcontent;

    /**
     * 门店运营官的code
     */
    private String opcode;

    /**
     * 是否直营门店（1.是的  0.不是）
     */
    private Integer fnum;

    /**
     * 门店所属战队
     */
    private String teamcode;

    /**
     * 商户号
     */
    private String merchantno;

    /**
     * 终端号
     */
    private String terminal;

    /**
     * token
     */
    private String token;

    /**
     * 蓝丝带
     */
    private Integer lsddb;

    /**
     * 雅培
     */
    private Integer ypdb;

    /**
     * 蓝色奇肌
     */
    private Integer lsqjdb;

    /**
     * 京都坊
     */
    private Integer jdfdb;

    /**
     * 九点美学
     */
    private Integer jdmxdb;

    /**
     * 蓝芬凰
     */
    private Integer lfhdb;

    /**
     * 蓝美美
     */
    private Integer lmmdb;

    /**
     * 静心养颜spa会所
     */
    private Integer jxyydb;

    /**
     * 是不是主城的店（0.不是 1.是）
     */
    private Integer iscity;

    /**
     * 临时分组
     */
    private Integer tempteam;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
