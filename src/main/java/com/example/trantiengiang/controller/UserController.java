package com.example.trantiengiang.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Đánh dấu lớp này là một Controller trong Spring MVC.
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
////
//    @GetMapping("/login")
//    public String login() {
//        return "users/login";
//    }
//
//    @GetMapping("/register")
//    public String register(@NotNull Model model) {
//        model.addAttribute("user", new User()); // Thêm một đối tượng User mới vào model
//        return "users/register";
//    }
//
////    @PostMapping("/register")
////    public String register(@Valid @ModelAttribute("user") User user, // Validate đối tượng User
////                           @NotNull BindingResult bindingResult, // Kết quả của quá trình validate
//                           Model model) {
//        if (bindingResult.hasErrors()) { // Kiểm tra nếu có lỗi validate
//            var errors = bindingResult.getAllErrors()
//                    .stream()
//                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                    .toArray(String[]::new);
//            model.addAttribute("errors", errors);
//            return "users/register"; // Trả về lại view "register" nếu có lỗi
//        }
////        userService.save(user); // Lưu người dùng vào cơ sở dữ liệu
////        userService.setDefaultRole(user.getUsername()); // Gán vai trò mặc định cho người dùng
////        return "redirect:/login"; // Chuyển hướng người dùng tới trang "login"
//    }
}