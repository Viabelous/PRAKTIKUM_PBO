/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posttest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Viabel
 */
public class MenuSection implements MenuBase{
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);

    final String Border = "*==================================*";
    
    final void cls(){
    // Fake ClearScreen
        for(int i = 0; i < 20; i++){
            System.out.println("\n");
        }
    }
    
    final void getBorder(){
        System.out.println(Border);
    }
    
    
    final int Opsi(){
        int opsi;
        
        System.out.print(" Pilihanmu: ");
        
        try{
            opsi = Integer.parseInt(br.readLine());
        } catch (Exception e){
            opsi = -1;
        }
        
        return opsi;
    }
    
    @Override
    public int LoginMenu(){
        cls();
        System.out.println(Border);
        System.out.println("""
                               | SELAMAT DATANG
                               | --[1] Login
                               | --[2] Register
                               | --[3] Keluar""");
        System.out.println(Border);

        return Opsi();
    }
    
    @Override
    public int AdminMenu(String Active, String SAd){
        System.out.println("""
                   | Selamat Datang Admin!
                   | Silakan pilih menu yang dituju
                   | --[1] Lihat Daftar Hewan
                   | --[2] Lihat Daftar Perlengkapan
                   | --------------------------------
                   | --[3] Tambahkan Data Hewan
                   | --[4] Hapus Data Hewan
                   | --[5] Ubah Data Hewan
                   | --------------------------------
                   | --[6] Tambahkan Data Perlengkapan
                   | --[7] Hapus Data Perlengkapan
                   | --[8] Ubah Data Perlengkapan
                   | --------------------------------
                   | --[9] Lihat Informasi Akun
                   | --------------------------------
                   """
                 + ((Active.equals(SAd))?
                   """
                   | --[10] Tambah Akun Admin
                   | --[11] Lihat Daftar Akun Admin
                   | --------------------------------
                   """ : "")
                 + "| --[99] Lihat Riwayat Pembelian\n"
                 + "| --[0] Keluar dari Mode Admin" );
        getBorder();
        
        return Opsi();
    }
    
    @Override
    public int UserMenu(String Active){
        System.out.println("| Selamat Datang " + Active + "!\n" 
         + """
           | Silakan pilih menu yang dituju
           | --[1] Lihat Daftar Hewan
           | --[2] Lihat Daftar Perlengkapan
           | --[3] Keranjangku
           | --[4] Lihat Riwayat Pembelian
           | --[5] Informasi Akun
           | --[6] Ubah Password
           | --[0] Keluar""" );
        getBorder();
        
        return Opsi();
    }
    
    @Override
    public int IntersectMenu(String Active, String SAd, boolean Admin){
        cls();
        getBorder();
        if(Admin){
            return AdminMenu(Active, SAd);
        }else{
            return UserMenu(Active);
        }
    }
    
}
