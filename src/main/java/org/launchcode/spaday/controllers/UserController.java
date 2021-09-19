package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayAllUsers(Model model) {
        model.addAttribute("title", "All Users");
        model.addAttribute("users", UserData.getAll());
        return "user/index";
    }

    //Handler method to render the form
    @GetMapping("add")
//    public String displayAddUserForm(Model model, @ModelAttribute User user) {
        public String displayAddUserForm(Model model) {
//        model.addAttribute("users", new User());
//        model.addAttribute("users", user);
        model.addAttribute(new User());
        return "user/add";
//    public String displayAddUserForm(@ModelAttribute User users){
//        UserData.add(users);
//        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors,Model model, String verify) {
        if (! verify.equals(user.getPassword())) {
            model.addAttribute("errormessage", "no");
//            model.addAttribute("page", "Viv Day Spa :: Create Your Account");
            return "user/add";
        } else if (errors.hasErrors()) {
//            model.addAttribute("page", "Viv Day Spa :: Create Your Account");
            return "user/add";
        } else {
            UserData.add(user);
            model.addAttribute("user",user);
            model.addAttribute("users", UserData.getAll());
//            model.addAttribute("page", "Viv Day Spa :: Welcome");
            return "redirect:";
        }

        }


        //Submit the form
//    @PostMapping("user")
//    public String createEvent(@ModelAttribute User newUser){
//        UserData.add(newUser);
//        return "redirect:"; //redirects to the homepage (/events)
//    }


}
