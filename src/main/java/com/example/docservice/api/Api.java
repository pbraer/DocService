package com.example.docservice.api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.docservice.dto.ProfileDocDto;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public interface Api {
    @GetMapping(value = ApiUrls.SINGIN) ModelAndView singin();

    @GetMapping(value = ApiUrls.PROFILE) ModelAndView profile();

    @GetMapping(value = ApiUrls.REGISTRATION) ModelAndView registration();

    @GetMapping(value = ApiUrls.SCHEDULE) ModelAndView schedule();


}
