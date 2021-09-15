package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayAllUsers(Model model){
        model.addAttribute("title", "All Users");
    model.addAttribute("users", UserData.getAll());
        return "user/index";
    }

    //Handler method to render the form
    @GetMapping("add")
    public String displayAddUserForm(Model model){
        model.addAttribute("users", new User());
        return "user/add";
//    public String displayAddUserForm(@ModelAttribute User users){
//        UserData.add(users);
//        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here



        if(verify.equals(user.getPassword())){
            UserData.add(user);
            model.addAttribute("username",user.getUsername());
            model.addAttribute("email",user.getEmail());
            return "redirect:";
        }
        else{
            model.addAttribute("username",user.getUsername());
            model.addAttribute("email",user.getEmail());
            model.addAttribute("errormessage","no");
            return "user/add";
        }
//        return "redirect:";
    }
    //Submit the form
//    @PostMapping("user")
//    public String createEvent(@ModelAttribute User newUser){
//        UserData.add(newUser);
//        return "redirect:"; //redirects to the homepage (/events)
//    }

}
