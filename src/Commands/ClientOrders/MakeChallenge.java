package Commands.ClientOrders;

import Commands.ClientOrder;
import Commands.PDU;
import Core.ClientBusinessLayer;

public class MakeChallenge implements ClientOrder {
    
    private ClientBusinessLayer business;
    private PDU message;
    
    public MakeChallenge(PDU message) {
        this.business = ClientBusinessLayer.getInstance();
        this.message = message;
    }

    @Override
    public void execute() {
        business.make_challenge(null);
    }
    
}
