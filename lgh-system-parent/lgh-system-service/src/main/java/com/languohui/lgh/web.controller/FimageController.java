package com.languohui.lgh.web.controller;

import com.languohui.lgh.service.IFimageService;
import com.languohui.lgh.domain.Fimage;
import com.languohui.lgh.query.FimageQuery;
import com.languohui.basic.util.AjaxResult;
import com.languohui.basic.util.PageList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fimage")
public class FimageController {
    @Autowired
    public IFimageService fimageService;

    /**
    * 保存和修改公用的
    * @param fimage  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Fimage fimage){



        try {
            if(fimage.getClass()!=null){
                fimageService.updateById(fimage);
            }else{
                fimageService.save(fimage);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            fimageService.removeById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Fimage get(@PathVariable("id")Long id)
    {
        return fimageService.getById(id);
    }


    /**
    * 查看所有信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Fimage> list(){
        return fimageService.list(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public PageList<Fimage> page(@RequestBody FimageQuery query)
    {
        Page<Fimage> page = fimageService.page(new Page<Fimage>(query.getPage(), query.getRows()));
        return new PageList<>(page.getTotal(),page.getRecords());
    }
}
