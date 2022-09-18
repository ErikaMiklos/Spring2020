package sample.simple.domain.store;

import org.springframework.beans.factory.annotation.Autowired;
import sample.simple.domain.bank.IBank;
import sample.simple.domain.provider.IProvider;
import org.springframework.stereotype.Component;

@Component
public class Store implements IJustHaveALook, ILane, IFastLane{
    @Autowired
    IBank bank;
    @Autowired
    IProvider provider;

    @Override
    public void getProductInfo(String string) {
        System.err.println(string);
        this.bank.getMoney();
    }
}
