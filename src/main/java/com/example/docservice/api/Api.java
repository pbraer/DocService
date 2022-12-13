package com.example.docservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public interface Api {
    @GetMapping(value = ApiUrls.SIGN) ModelAndView sign();

    @GetMapping(value = ApiUrls.PROFILE) ModelAndView profile();

    @GetMapping(value = ApiUrls.REGISTRATION) ModelAndView registration();

    @GetMapping(value = ApiUrls.SCHEDULE) ModelAndView schedule();


}
