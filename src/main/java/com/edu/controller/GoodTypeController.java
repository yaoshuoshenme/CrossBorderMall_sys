package com.edu.controller;

import com.edu.commons.JsonModel;
import com.edu.pojo.GoodType;
import com.edu.pojo.Goods;
import com.edu.service.GoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GoodTypeController {

    @Autowired
    private GoodTypeService gs;

    /**
     * 查询一级类目
     * @param gtlevel 类目层级
     * @return
     */
    @GetMapping("selectAll.do")
    @ResponseBody
    public JsonModel selectAll(Integer gtlevel){
        List<GoodType> list = gs.selectAll(gtlevel);

        JsonModel js = new JsonModel();
        js.setCode(null != list ? 0 : 1);
        js.setMsg(null != list ? "success":"error");
        js.setData(list);

        return js;
    }

    /**
     * 添加商品分类
     * @param type
     * @return
     */
    @PostMapping("addgoodtype.do")
    public String addGoodType(GoodType type){

       boolean b = gs.insertType(type);
       if(b){
           return "redirect:showGoodsType.html";
       }else{

           return "redirect:addGoodsType.html";
       }
    }

    //验证是否已存在类名
    @PostMapping("checktype.do")
    @ResponseBody
    public JsonModel checktype(String gtname){

       boolean b = gs.checkType(gtname);
       if(b){
           return JsonModel.error();
       }else{
           return JsonModel.ok();
       }
    }

    //查询goodtypeList
    @PostMapping("getgoodtypelist.do")
    @ResponseBody
    public JsonModel getgoodtypelist(String gtlevel, String gtname){
        if(gtlevel.isEmpty())
            gtlevel = null;
        if(gtname.isEmpty())
            gtname = null;
        JsonModel js = new JsonModel();
        List<GoodType> list = gs.selectActive(gtlevel, gtname);
        if(null != list && list.size() > 0){
            js.setData(list);
            js.setCode(0);
            js.setMsg("success");
            return js;
        }else{
            return JsonModel.error();
        }
    }

    //根据gtid查询
    @PostMapping("selectbygtid.do")
    @ResponseBody
    public JsonModel selectbygtid(String gtid){
        JsonModel js = new JsonModel();

        GoodType gt = gs.selectbykey(gtid);
        js.setCode(null != gt ? 0 : 1);
        js.setData(gt);
        return js;
    }
    //更新修改
    @PostMapping("modifygoodtype.do")
    public String modifygoodtype(GoodType goodType){
        boolean b = gs.updateType(goodType);
            return "redirect:showGoodsType.html";
    }
}
