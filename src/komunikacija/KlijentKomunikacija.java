/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;

/**
 *
 * @author Marko
 */
public class KlijentKomunikacija {

    private Socket socket;
    private static KlijentKomunikacija instance;

    private KlijentKomunikacija() throws IOException {
        socket = new Socket("127.0.0.1", 9000);
    }

    public static KlijentKomunikacija getInstance() {
        if (instance == null) {
            try {
                instance = new KlijentKomunikacija();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Server nije pokrenut, pokušajte kasnije!", "Greška!", JOptionPane.WARNING_MESSAGE);
            }
        }
        return instance;
    }

    public void posaljiZahtev(TransferObjekatZahtev toZahtev) {
        ObjectOutputStream outSocket = null;
        try {
            outSocket = new ObjectOutputStream(socket.getOutputStream());
            outSocket.writeObject(toZahtev);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Server nije pokrenut, pokušajte kasnije!", "Greška!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public TransferObjekatOdgovor primiOdgovor() throws IOException, ClassNotFoundException {
        ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
        return (TransferObjekatOdgovor) inSocket.readObject();
    }
}
