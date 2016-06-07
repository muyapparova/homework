package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.Bookmark;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.BookmarkRepository;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.BookmarkService;
import ru.kpfu.itis.util.BookmarkFormValidator;


@SessionAttributes("bookmark")

@Controller
public class BookmarkController {

    private BookmarkFormValidator validator = new BookmarkFormValidator();

    @Autowired
    BookmarkService bookmarkService;

    @Autowired
    UserRepository userRepository;


    @RequestMapping("/add_bookmark/{userid}")
    public String createBookmark(@PathVariable("userid") String userid, Model model) {


        Bookmark bookmark = new Bookmark();

        model.addAttribute("bookmark", bookmark);
        model.addAttribute("userid", userid);

        return "add-bookmark";
    }

    @RequestMapping(value = "/add_bookmark", method = RequestMethod.POST)
    public String saveBookmark(@ModelAttribute("bookmark") Bookmark bookmark, String userid, BindingResult result) {
        validator.validate(bookmark, result);
       // bookmarkService.addBookmark(bookmark);
        if (result.hasErrors()) {
            return "add-bookmark";
        } else {
            Long userId = Long.parseLong(userid);
            User user = userRepository.findUserById(userId);
            user.getBookmarks().add(bookmark);
            userRepository.updateUser(user);
            bookmarkService.addBookmark(bookmark);
            return "redirect:/users/all";
        }
    }
}
