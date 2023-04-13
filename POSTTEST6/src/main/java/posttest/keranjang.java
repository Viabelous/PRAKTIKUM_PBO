/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posttest;

/**
 *
 * @author Viabel
 */
public class keranjang{
    String USP;
    int Harga;
    int ID_Item;
    
    public keranjang(String Username_Pembeli, int Harga, int ID_Item){
        this.USP = Username_Pembeli;
        this.Harga = Harga;
        this.ID_Item = ID_Item;
    }   
}

class keranjangPerlengkapan extends keranjang{
    String Nama;
    int Banyak;
    int totalHarga;

    public keranjangPerlengkapan(String Username_Pembeli, int Harga, int ID_Item
    ,int Jumlah, String Nama){
        super(Username_Pembeli, Harga, ID_Item);
        this.Banyak = Jumlah;
        this.totalHarga = this.Banyak * Harga;
        this.Nama = Nama;
    }
    
}