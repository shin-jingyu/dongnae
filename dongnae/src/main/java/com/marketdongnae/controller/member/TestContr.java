package com.marketdongnae.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TestContr {

    @GetMapping("/test")
    public String testMethod(@ModelAttribute("test") TestItem test, Model model) {
        String msg = "model test";
      
        // 이렇게 set이 아니라 통째로 넣으려고 하면 안됨 
//        test = new TestItem( "hi", "hh");
        
        // 이렇게 set으로 해줘야지만 위의 testItem 객체에 반영이 됨 
        test.setName("hi");
        test.setPrice("hh");
        
        return "member/tes";
    }
}
