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
final public class hewan extends produk{
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    
    // Properties
    String Jenis;
    String Ras;
    String Gender;
    String Warna;
    int Umur; 
    int Harga;
    String Note;
    boolean Keranjang;
    
    // Constructor
    public hewan(int ID_Hewan, String Nama_Sementara,
                 String Jenis_Hewan, String Ras_Hewan, String Gender,
                 String Warna_Dominan, int Umur_Hewan_Tahun, int Harga_Hewan,
                 String Deskripsi, boolean di_keranjang){
        this.ID = ID_Hewan;
        this.Nama = Nama_Sementara;
        this.Jenis = Jenis_Hewan;
        this.Ras = Ras_Hewan;
        this.Gender = Gender;
        this.Warna = Warna_Dominan;
        this.Umur = Umur_Hewan_Tahun;
        this.Harga = Harga_Hewan;
        this.Note = Deskripsi;
        this.Keranjang = di_keranjang;
    }
    
    // Add Data
    @Override
    void add() throws IOException{
        System.out.println(" ID Hewan: " + ID);
        
        
        System.out.print(" Nama    : ");
        this.Nama = br.readLine();
        
        System.out.print(" Jenis   : ");
        this.Jenis = br.readLine();
        
        System.out.print(" Ras     : ");
        this.Ras = br.readLine();
        
        System.out.print(" Gender  : ");
        this.Gender = br.readLine();
        
        System.out.print(" Warna   : ");
        this.Warna = br.readLine();
        
        System.out.print(" Umur    : ");
        this.Umur = Integer.parseInt(br.readLine());
        
        System.out.print(" Harga   : Rp ");
        this.Harga = Integer.parseInt(br.readLine());
        
        System.out.print(" Deskripsi:\n ");
        this.Note = br.readLine();
        
    }
    
    // Show Data
    @Override
    void show(){
        System.out.println(" ID:-- " + ID);
        System.out.println(" Nama    : " + Nama);
        System.out.println(" Jenis   : " + Jenis);
        System.out.println(" Ras     : " + Ras);
        System.out.println(" Gender  : " + Gender);
        System.out.println(" Warna   : " + Warna);
        System.out.println(" Umur    : " + Umur);
        System.out.println(" Harga   : Rp " + Harga);
        System.out.println(" Deskripsi:\n " + Note);
    }
    
    // Update Data
    @Override
    void edit() throws IOException, Exception{
        System.out.print(" Ketik 999 untuk menggunakan data lama");
        System.out.println("\n ID Hewan: " + ID + "( ID TIDAK DAPAT DIUBAH)");
        
        System.out.print(" Nama Lama    : " + this.Nama);
        System.out.print("\n Nama Baru    : ");
        String namaNew = br.readLine();
        
        System.out.print(" Jenis Lama   : " + this.Jenis);
        System.out.print("\n Jenis Baru   : ");
        String jenisNew = br.readLine();
        
        System.out.print(" Ras Lama     : " + this.Ras);
        System.out.print("\n Ras Baru     : ");
        String rasNew = br.readLine();
        
        System.out.print(" Gender Lama  : " + this.Gender);
        System.out.print("\n Gender Baru  : ");
        String genderNew = br.readLine();
        
        System.out.print(" Warna Lama   : " + this.Warna);
        System.out.print("\n Warna Baru   : ");
        String warnaNew = br.readLine();
        
        System.out.print(" Umur Lama    : " + this.Umur);
        System.out.print("\n Umur Baru    : ");
        int umurNew = Integer.parseInt(br.readLine());
        if(umurNew < 0){throw new Exception("");}
        
        System.out.print(" Harga Lama   : Rp " + this.Harga);
        System.out.print("\n Harga Baru   : Rp ");
        int hargaNew = Integer.parseInt(br.readLine());
        
        System.out.print("\n Deskripsi:\n ");
        String noteNew = br.readLine();
        
        
        this.Nama = (namaNew.equals("999")) ? this.Nama : namaNew; 
        this.Jenis = (jenisNew.equals("999")) ? this.Jenis : jenisNew; 
        this.Ras = (rasNew.equals("999")) ? this.Ras : rasNew; 
        this.Gender = (genderNew.equals("999")) ? this.Gender : genderNew; 
        this.Warna = (warnaNew.equals("999")) ? this.Warna : warnaNew; 
        this.Umur = (umurNew == 999) ? this.Umur : umurNew;
        this.Harga = (hargaNew == 999) ? this.Harga : hargaNew;
        this.Note = (noteNew.equals("999")) ? this.Note : noteNew; 
        
        System.out.println(" Data hewan berhasil diubah.");
    }
    
    // Delete Data
    @Override
    boolean delete() throws IOException{
        System.out.println("\n Yakin hapus data?");
        System.out.println(" (ketik 'H4pu5 DAT4' untuk mengonfirmasi)");
        String delConf = br.readLine();
        if(delConf.equals("H4pu5 DAT4")){
            System.out.println(" Data Berhasil Dihapus");
            return true;
        }else{
            System.out.println(" Penghapusan Dibatalkan");
            return false;
        }
    }
    
    // Buy Confirmation
    final boolean buy() throws IOException{
        show();
        System.out.println("\n Beli " + this.Nama + "? (Ya atau Y untuk konfirmasi)");
        System.out.print(" >> ");
        String buyConf = br.readLine().toUpperCase();
        if(buyConf.equals("Y") || buyConf.equals("YA")){
            this.Keranjang = true;
            System.out.println(" Berhasil dimasukkan ke keranjang.");
            return true;
        }
        return false;
    }
}
