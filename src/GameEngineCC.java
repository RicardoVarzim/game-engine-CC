


import BusinessEntities.UserBE;
import Commands.*;
import Core.*;
import UDPClient.*;
import UDPServer.*;
import UI.MainWindow;
import static java.lang.Thread.sleep;

public class GameEngineCC {

    static UDPClient udpClient;
    static UDPServer udpServer;
    //static Util util;
    
    public static void main(String[] args) throws InterruptedException {
        
        
        //Initialize Server
        udpServer = new UDPServer(9875);
        new Thread(udpServer).start();
        
        //<editor-fold defaultstate="collapsed" desc="Swing settings">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               MainWindow.getInstance().setVisible(true);
            }
        });
        
        //TODO INICIALIZAR GUI{
        
            ClientCommandFactory clientFactory = new ClientCommandFactory();        
            UserBE admin = new UserBE("admin","12345");
            //Initialize Client
            udpClient = new UDPClient(clientFactory.Hello());
            new Thread(udpClient).start();
            
            sleep(10000);
            //Initialize Client
            udpClient = new UDPClient(clientFactory.Register(admin));
            new Thread(udpClient).start();
            
            sleep(10000);
            //Initialize Client
            udpClient = new UDPClient(clientFactory.Register(admin));
            new Thread(udpClient).start();
            
        //}
        
        
        
        

        
        
        //EXEMPLO COMMAND BROKER
//            Hello buyStockOrder = new Hello(business);
//            Register sellStockOrder = new Register(business);
//
//            CommandBroker broker = new CommandBroker();
//            broker.takeOrder(buyStockOrder);
//            broker.takeOrder(sellStockOrder);
//
//            broker.placeOrders();
      
        //System.out.println("Stopping Server");
        //TODO: server.stop();
    }
    
}
