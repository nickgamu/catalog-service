package zw.co.pabuwe.polarbookshop.catalogservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.pabuwe.polarbookshop.catalogservice.config.PolarProperties;

@RestController
//@RequiredArgsConstructor
public class HomeController {

    private final PolarProperties polarProperties;

    public HomeController(PolarProperties polarProperties) {
        this.polarProperties = polarProperties;
    }

    @GetMapping("/")
    public String getGreeting() {
        return polarProperties.getGreeting();
    }
}
