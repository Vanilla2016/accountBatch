package pages;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class OTPPage extends BasePage {
    @Override
    public void drive() {

    }
}
