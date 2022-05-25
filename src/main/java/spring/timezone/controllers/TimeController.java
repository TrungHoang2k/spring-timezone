package spring.timezone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.timezone.service.Impl.TimezoneServiceImpl;
import spring.timezone.service.TimezoneService;

import java.util.Date;

@Controller
public class TimeController {

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("view/index.jsp");
        return modelAndView;
    }

    @PostMapping("/worldclock")
    public ModelAndView getTimeByTimezone(@RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        ModelAndView modelAndView = new ModelAndView("view/index.jsp");
        TimezoneService timezoneService = new TimezoneServiceImpl();
        Date date = timezoneService.getTimeByTimezone(city);
        modelAndView.addObject("city", city);
        modelAndView.addObject("date", date);
        return modelAndView;
    }
}

