package com.edu.controller;


import com.edu.commons.JsonModel;
import com.edu.pojo.Backuser;
import com.edu.pojo.Goods;
import com.edu.service.GoodService;
import com.edu.util.DateUtil;
import com.edu.util.MyFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
public class GoodController {

    @Autowired
    private GoodService gs;

    /**
     * 添加商品
     * @param goods
     * @param MultipartFile
     * @param session
     * @param request
     * @return
     */
    @PostMapping("/addGoods.do")
    public String addGoods(Goods goods, @RequestParam(value = "gpicture",required = false)CommonsMultipartFile MultipartFile, HttpSession session, HttpServletRequest request){


        //获取bid
        Backuser user = (Backuser) session.getAttribute("user");
        goods.setBid(user.getBid() + "");


        //获取gpic
        if(null != MultipartFile){
            //文件夹
            File dir = new File(new File(request.getServletContext().getRealPath("/")).getParent(), "17fmpics");
            if(!dir.exists()){
                dir.mkdirs();
            }
            //需要存储的文件对象
            File tarFile = new File(dir, MyFileUtil.getFileName(MultipartFile.getOriginalFilename()));
            //存储到服务器指定路径
            try {
                MultipartFile.transferTo(tarFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            goods.setGpic(tarFile.getName());
        }

        return gs.addGoods(goods) ? "redirect:showGoods.html":"redirect:addGoods.html";
    }


    /**
     * 获取商品列表
     * @param gname
     * @param gcreatedate
     * @return
     */
    @GetMapping("getGoodList.do")
    @ResponseBody
    public JsonModel getGoodList(@RequestParam(value = "gname", required = false) String gname, @RequestParam(value = "gcreatedate", required = false)String gcreatedate){


        List<Goods> list = null;
        try {
            list = gs.getGoodList(gname, gcreatedate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JsonModel js = new JsonModel();


            js.setCode(null != list && list.size() != 0 ? 0 : 1);
            js.setMsg(null != list && list.size() != 0 ? "成功" : "失败");
            js.setData(list);

        return js;
    }


}
