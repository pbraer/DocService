package com.example.docservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

public interface Api {
    @GetMapping(value = ApiUrls.SIGN) ModelAndView sign();

    @GetMapping(value = ApiUrls.PROFILE) ModelAndView profile(@PathVariable(value = "id") String id);

    @GetMapping(value = ApiUrls.REGISTRATION) ModelAndView registration(@PathVariable(value = "id") String id);

    @GetMapping(value = ApiUrls.SCHEDULE) ModelAndView schedule(@PathVariable(value = "id") String id);

    @GetMapping(value = ApiUrls.DOCUMENTS) ModelAndView documents(@PathVariable(value = "id") String id);

    @GetMapping(value = ApiUrls.PATIENTS) ModelAndView patients(@PathVariable(value = "id") String id);

}
