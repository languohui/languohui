package com.languohui.lgh.web.controller;

import com.languohui.lgh.service.IFacadeService;
import com.languohui.lgh.domain.Facade;
import com.languohui.lgh.query.FacadeQuery;
import com.languohui.basic.util.AjaxResult;
import com.languohui.basic.util.PageList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facade")
public class FacadeController {
    @Autowired
    public IFacadeService facadeService;

    /**
    * 保存和修改公用的
    * @param facade  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Facade facade){
        try {
            if(facade.getClass()!=null){
                facadeService.updateById(facade);
            }else{
                facadeService.save(facade);
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
            facadeService.removeById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Facade get(@PathVariable("id")Long id)
    {
        return facadeService.getById(id);
    }


    /**
    * 查看所有信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Facade> list(){

        return facadeService.list(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public PageList<Facade> page(@RequestBody FacadeQuery query)
    {
        Page<Facade> page = facadeService.page(new Page<Facade>(query.getPage(), query.getRows()));
        return new PageList<>(page.getTotal(),page.getRecords());
    }
}
