/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posttest;

import java.io.IOException;

/**
 *
 * @author Viabel
 */
abstract public class produk {
    int ID;
    String Nama;
    
    abstract void add() throws IOException;
    abstract void edit() throws IOException, Exception;
    abstract void show();
    abstract boolean delete() throws IOException;
}
