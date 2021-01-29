package org.primefaces.spring.starter;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Component
@ViewScoped
public class TestView {

    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;

    @PostConstruct
    public void init() {
        string = "Always bet on Prime!";
    }
}
