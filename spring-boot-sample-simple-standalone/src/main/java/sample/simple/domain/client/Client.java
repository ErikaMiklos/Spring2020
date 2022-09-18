package sample.simple.domain.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.simple.domain.store.IFastLane;
import sample.simple.domain.store.IJustHaveALook;
import sample.simple.domain.store.ILane;

@Component
public class Client implements IRun {

    @Autowired
    IFastLane fastLane;
    @Autowired
    ILane lane;
    @Autowired
    IJustHaveALook haveALook;

    @Override
    public void run() {
        System.out.println("c'est parti !");

        haveALook.getProductInfo("toto");
    }
}
