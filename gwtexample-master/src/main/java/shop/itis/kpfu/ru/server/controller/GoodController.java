package shop.itis.kpfu.ru.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import shop.itis.kpfu.ru.client.service.GoodService;
import shop.itis.kpfu.ru.shared.model.Good;

import java.util.List;

/**
 * Created by eljah32 on 4/15/2016.
 */
@Controller(value = "/goods")
public class GoodController {
    @Autowired
    GoodService goodService;
    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getIndexPage(Model model)

    {
        List<Good> goods=goodService.getAllGoods();
        model.addAttribute("goods",goods);
        //return "redirect:/goods";
        return "hello.jsp";
    }

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public String buyAGood(@RequestParam(value = "id", required = false) long id,Model model)
    {
        goodService.buyGood(id);
        return "redirect:/goods/all.jsp";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getIndexPage1(Model model)
    {
        return "redirect:/resources.html/HelloGWT.html";
    }


}
