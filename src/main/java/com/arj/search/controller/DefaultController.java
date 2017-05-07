package com.arj.search.controller;

import com.arj.search.dao.UserDAO;
import javax.ws.rs.FormParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class DefaultController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, @RequestParam(name = "searchparam",defaultValue = "") String searchParam) {
        try {
            if (!searchParam.equals("")) {
                model.addAttribute("users", userDAO.search(searchParam));
            } else {
                model.addAttribute("users", userDAO.getAll());
            }
        } catch (Exception e) {

        }
        return "index";
    }

//    @RequestMapping(value = "/search",method = RequestMethod.GET)
//    public String search(Model model, @FormParam(value = "searchparam") String searchParam) {
//        try {
//            model.addAttribute("searchedUser", userDAO.search(searchParam));
//        } catch (Exception e) {
//
//        }
//        return "index";
//    }
}
