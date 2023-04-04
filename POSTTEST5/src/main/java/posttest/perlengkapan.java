/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posttest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Viabel
 */
final public class perlengkapan extends produk {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    
    // Properties
    int Stok;
    String Hewan;
    int Harga;
    String Note;
    int Keranjang;
    
    // Constructor
    public perlengkapan(int ID_Barang, String Nama_Barang, int Stok_Barang, String Hewan_Pemilik_Barang,
            int Harga_Barang, String Deskripsi, int Jumlah_di_Keranjang){
        this.ID = ID_Barang;
        this.Nama = Nama_Barang;
        this.Stok = Stok_Barang;
        this.Hewan = Hewan_Pemilik_Barang;
        this.Harga = Harga_Barang;
        this.Note = Deskripsi;
        this.Keranjang = Jumlah_di_Keranjang;
    }
    
    // Add Data
    @Override
    void add() throws IOException{
        System.out.println(" ID Perlengkapan: " + ID);
        
        System.out.print(" Nama       : ");
        this.Nama = br.readLine();
        
        System.out.print(" Stok       : ");
        this.Stok = Integer.parseInt(br.readLine());
        
        System.out.print(" Untuk Hewan: ");
        this.Hewan = br.readLine();
        
        System.out.print(" Harga      : ");
        this.Harga = Integer.parseInt(br.readLine());
        
        System.out.print(" Deskripsi:\n ");
        this.Note = br.readLine();
        
    }
    
    // Show Data
    @Override
    void show(){
        System.out.println(" ID:-- " + ID);
        System.out.println(" Nama       : " + Nama);
        System.out.println(" Stok       : " + (Stok - Keranjang));
        System.out.println(" Untuk Hewan: " + Hewan);
        System.out.println(" Harga      : " + Harga);
        System.out.println(" Deskripsi  :\n " + Note);
    }
    
    // Update Data
    @Override
    void edit() throws IOException, Exception{
        System.out.print(" Ketik 999 untuk menggunakan data lama");
        System.out.println("\n ID Barang: " + ID + "( ID TIDAK DAPAT DIUBAH)");
        
        System.out.print(" Nama Lama           : " + this.Nama);
        System.out.print("\n Nama Baru           : ");
        String namaNew = br.readLine();
        
        System.out.print(" Di Keranjang        : " + this.Keranjang);
        System.out.print("\n Stok Lama           : " + this.Stok);
        System.out.print("\n Stok Baru           : ");
        int stokNew = Integer.parseInt(br.readLine());
        if(stokNew < 0 || stokNew < this.Keranjang){throw new Exception("");}
        
        System.out.print(" Hewan Pemilik Lama  : " + this.Hewan);
        System.out.print("\n Hewan Pemilik Baru  : ");
        String hewanNew = br.readLine();
        
        System.out.print(" Harga Lama          : Rp " + this.Harga);
        System.out.print("\n Harga Baru          : Rp ");
        int hargaNew = Integer.parseInt(br.readLine());
        
        System.out.print("\n Deskripsi:\n ");
        String noteNew = br.readLine();
        
        
        this.Nama = (namaNew.equals("999")) ? this.Nama : namaNew; 
        this.Stok = (hargaNew == 999) ? this.Stok : stokNew;
        this.Hewan = (namaNew.equals("999")) ? this.Hewan : hewanNew; 
        this.Harga = (hargaNew == 999) ? this.Harga : hargaNew;
        this.Note = (noteNew.equals("999")) ? this.Note : noteNew; 
    }
    
    // Delete Data
    @Override
    boolean delete() throws IOException{
        String delConf;
        
        if(this.Keranjang == 0){
            System.out.println("\n Yakin hapus data?");
            System.out.println(" (ketik 'H4pu5 DAT4' untuk mengonfirmasi)");
            delConf = br.readLine();
        } else{
            System.out.println(" Barang sedang berada di dalam Keranjang seseorang.");
            delConf = "";
        }
        
        if(delConf.equals("H4pu5 DAT4")){
            System.out.println(" Data Berhasil Dihapus");
            return true;
        }else{
            System.out.println(" Penghapusan Dibatalkan");
            return false;
        }
    }
    
    // Buy Confirmation
    final int buy() throws IOException{
        show();
        System.out.println("\n Beli " + this.Nama + " ? ");
        String buyConf = br.readLine().toUpperCase();
        if(buyConf.equals("Y") || buyConf.equals("YA")){
            try{
                System.out.println(" Masukkan banyak barang");
                int banyak = Integer.parseInt(br.readLine());
                if(banyak > 0 && banyak <= (this.Stok - this.Keranjang)){
                    this.Keranjang += banyak;
                    return banyak;
                } else{
                    System.out.println(" Jumlah dibeli Invalid.");
                }
            } catch(Exception e){}
            
            System.out.println("  Pembelian dibatalkan");
        }
        
        return 0;
    }
    
    final void buy(int jumlah){
        this.Stok -= jumlah;
        this.Keranjang -= jumlah;
    }
}
