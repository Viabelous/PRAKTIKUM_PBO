/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posttest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Viabel
 */
class akun {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    
    // Properties
    private int ID;
    private String Nama;
    private String Usn;
    private String Pass;
    private String Email;
    private String Type;
    
    // Constructor
    akun(int Id, String Nama, String Username, String Password, String Email, String Tipe_Akun){
        this.ID = Id;
        this.Nama = Nama;
        this.Usn = Username;
        this.Pass = Password;
        this.Email = Email;
        this.Type = Tipe_Akun;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getUsn() {
        return Usn;
    }

    public void setUsn(String Usn) {
        this.Usn = Usn;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getEmail() {
        return Email;
    }
    
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String getType() {
        return Type;
    }
    
    public void setType(String Type) {
        this.Type = Type;
    }

    public void tambahAkun(ArrayList <akun> data) throws IOException, Exception{
        String Nama, Usn, Pass, Email;

        try{
            System.out.print(" Usn      : ");
            Usn = br.readLine();

            for (akun daftarAkun : data) {
                if (daftarAkun.getUsn() != null){
                    if(daftarAkun.getUsn().equals(Usn)){
                        System.out.println(" Username tersebut sudah ada.");
                        throw new Exception();
                    }
                }
            }
        }catch(Exception e){
            throw new Exception();
        }
        
        this.Usn = Usn;        
        
        try{
            System.out.print(" Pass     : ");
            Pass = br.readLine();
            this.Pass = Pass;
            
            System.out.print(" Nama     : ");
            Nama = br.readLine();
            this.Nama = Nama;

            System.out.print(" Email    : ");
            Email = br.readLine();
            this.Email = Email;
        } catch (Exception e){
                System.out.println(" Terjadi error saat menginput data.");
        }
    }
    
    void tambahPengguna(ArrayList <akun> data) throws IOException, Exception{
        tambahAkun(data);
        this.Type = "Pembeli";
    }
    
}

class superAdmin extends akun{
    
    public superAdmin(int Id, String Nama, String Username, String Password, String Email, String Tipe_Akun) {
        super(Id, Nama, Username, Password, Email, Tipe_Akun);
    }
    
    akun tambahAdmin(int id, ArrayList <akun> data) throws IOException, Exception{
        akun Tambah = new akun(id, null, null, null, null, "Admin"); 
        Tambah.tambahAkun(data);
        return Tambah;
    }
    
    void listAdmin(ArrayList <akun> data){
        boolean exist = false;
        
        for (akun daftarAkun : data){
            if(daftarAkun.getType().equals("Admin")){
                System.out.println(" ID: " + daftarAkun.getID()
                                 + " ---. " + daftarAkun.getNama()
                                 + " / " + daftarAkun.getUsn());
            
            exist = true;
                
            }
        }
        
        if (exist == false){
            System.out.println(" Tidak ada akun admin.");
        }
        
    }
    
}