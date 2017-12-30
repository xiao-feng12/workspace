package com.wangmiao.demo.controller;

import com.wangmiao.demo.dao.UserMapper;
import com.wangmiao.demo.entity.User;
import com.wangmiao.demo.repository.UserRepository;
import com.wangmiao.demo.pagemodel.req.UserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @Value("${userName}")
    private String userName;

    @Value("${bookTitle}")
    private String bookTitle;

    @Autowired
    private UserRepository userRepository;
    //在运行的过程他会自动生成实例
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("name", userName);
        map.addAttribute("bookTitle", bookTitle);
        // return模板文件的名称，对应src/main/resources/templates/welcome.html
        User user = userRepository.findOne(1L);//
        User user1 = userRepository.getOne(1L);
        map.addAttribute("name",user1.getName());
        UserRes userRes = userMapper.selectByUserId(1L);
        map.addAttribute("mapperName",userRes.getName());
        map.addAttribute("userId",user.getId());
        map.addAttribute("userName",user.getName());
        return "welcome";
    }

}
