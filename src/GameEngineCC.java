import UDPClient.*;
import UDPServer.*;
import UI.MainWindow;

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
        
      
    }
    
}
