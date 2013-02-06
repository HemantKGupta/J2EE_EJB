package examples.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;

public class ReportProcessorBean implements javax.jms.MessageListener {
    public void onMessage(javax.jms.Message message) {
        System.out.println("Processing message: " + message.toString());
    }
}
