package sample.simple.domain.bank;

import org.springframework.stereotype.Component;

@Component
public class Bank implements IBank {
    @Override
    public void getMoney() {
        System.err.println("tititi");
    }
}
