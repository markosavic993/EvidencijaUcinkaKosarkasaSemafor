/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import forme.FrmIzborUtakmice;
import komunikacija.KlijentKomunikacija;

/**
 *
 * @author Marko
 */
public class Start {
    public static void main(String[] args) {
        FrmIzborUtakmice forma = new FrmIzborUtakmice(null, true);
        forma.setVisible(true);
    }
}
