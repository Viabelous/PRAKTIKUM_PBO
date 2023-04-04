/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package posttest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
///import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;

/**
 *
 * @author Viabel
 */

/* [ Versi Program 03 ]
   -. CRUD Keranjang belum tersedia.

   -. CRUD Pembelian belum tersedia.

   -. Belum tersedia property tanggal di catatan pembelian.

   -. Fitur yang kurang akan ditambahkan di versi
      mendatang. Fitur yang ada saat ini semata hanya
      untuk memenuhi nilai.
   
*/

public class main {
    
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);
    
    static MenuSection Mn = new MenuSection();
    static ArrayList <hewan> dataHewan = new ArrayList<>();
    static ArrayList <perlengkapan> dataPerlengkapan = new ArrayList<>();
    static ArrayList <keranjangPerlengkapan> keranjangP = new ArrayList<>();
    static ArrayList <keranjang> keranjangH = new ArrayList<>();
    static ArrayList <catatanPembelian> historyP = new ArrayList<>();
    static ArrayList <akun> dataAkun = new ArrayList<>();
    static superAdmin SuperAdm = new superAdmin(0, "Yafi", "Viabel", "Viabel",
            "StressPosttest@gmail.com", "Jln. Bayam 16, Bengkuring, No. 654", "admin");
        
    public static void main(String[] args) throws IOException {
        
        // Inisialisasi
        int opsi, getId, index, equipBuy, priceH, priceP, IDUser;
        int maxIDAkun = 0, maxIDPerlengkapan = 0, maxIDHewan = 0;
        boolean admin = false, unEmpt, stats1 = true, stats2 = true;
        String Username, Password, activeUser = "", Catat;
        //LocalDate Date;
        
        
        // Pengisi Kekosongan Sementara
        dataHewan.add(new hewan(0, "Narnia", "Kucing", "Sphinx", 
                "Jantan", "Pink", 1, 5000000, "kucing gweh cuy", false));
        dataPerlengkapan.add(new perlengkapan(0, "Sisir Logam", 10, "Kucing",
                             7000, " adalah sisir untuk kucing", 0));
        
        maxIDHewan++;
        maxIDPerlengkapan++;
        
        
        
        // Play
        while(stats1){
            index = 0;
            opsi = 0;
            getId = 0;
            
            while(stats2){
                
                switch(Mn.LoginMenu()){
                    
                    // Login
                    case 1:
                        
                        Mn.cls();
                        System.out.print(" Username:  ");
                        Username = br.readLine();
                        
                        System.out.print(" Password:  ");
                        Password = br.readLine();
                        
                        if(!Username.equals(SuperAdm.getUsn())){
                            index = SequentiallyUsername(dataAkun, Username);
                            if(index != -1){
                                if((dataAkun.get(index).getPass()).equals(Password)){
                                    activeUser = dataAkun.get(index).getUsn();
                                    if(dataAkun.get(index).getType().equals("Admin")){
                                        admin = true;
                                    }
                                }else{
                                    System.out.println(" Username atau Password Salah!");
                                    pause();
                                    break;
                                }
                            }else{
                                System.out.println(" Username atau Password Salah!");
                                pause();
                                break;
                            }
                        }else{
                            if(Password.equals(SuperAdm.getPass())){
                                activeUser = SuperAdm.getUsn();
                                admin = true;
                            }
                            else{
                                System.out.println(" Username atau Password Salah!");
                                pause();
                                break;
                            }
                        }
                        stats2 = false;
                        Mn.cls();
                        break;
                        
                        
                    // Register
                    case 2:
                        
                        index = maxIDAkun;
                        
                        // Tambah AKun
                        dataAkun.add(new akun(index, null, null, null, null, null,null));
                        try{
                            dataAkun.get(index).tambahPengguna(dataAkun);
                            maxIDAkun++;
                            System.out.println(" Akun Berhasil Dibuat");
                        } catch (Exception e){
                            dataAkun.remove(index);
                        }

                        pause();
                        break;
                        
                    // Keluar
                    case 3:
                        System.exit(0);
                        break;
                        
                    default:
                        break;
                }
                
            }


            opsi = Mn.MainMenu(activeUser, SuperAdm.getUsn(), admin);
            
            if(admin == false){
                switch(opsi) {
                    case 99, 100, 101, 102 -> opsi = 9999;
                    case 3 -> opsi = 100;
                    case 4 -> opsi = 99;
                    case 5 -> opsi = 9;
                    case 6 -> opsi = 102;
                    default -> {}
                }
            }
            
            switch(opsi){
                
                // Lihat Data Hewan
                case 1:
                    unEmpt = showAll(dataHewan, admin);
                    
                    if (unEmpt == true){
                        System.out.print("\n\n Ketik 9999 untuk kembali.");
                        System.out.print("\n ID Hewan dipilih: ");

                        try{
                            index = Integer.parseInt(br.readLine());
                            if(index == 9999){break;}
                            else{
                                index = SequentialSearch(dataHewan, index);
                            }
                            if(index == -1){
                                System.out.println(" Hewan dengan ID tersebut tidak ada.");
                                pause();
                            }else{
                                if(dataHewan.get(index).Keranjang != true){
                                    Mn.cls();
                                    if(admin == false){
                                       for (int i = 0; i < keranjangH.size(); i-=-1){
                                            if(keranjangH.get(i).USP.equals(activeUser)){
                                                dataHewan.get(index).show();
                                                System.out.println("\n Sedang ada hewan di dalam keranjang,"
                                                                 + " tidak dapat membeli.");
                                                pause();
                                                throw new Exception();
                                            }
                                        }
                                        if(dataHewan.get(index).buy() == true){
                                            keranjangH.add(new keranjang(activeUser, 
                                                    dataHewan.get(index).Harga,
                                                    dataHewan.get(index).ID));
                                        }
                                    }else{
                                        dataHewan.get(index).show();
                                        pause();
                                    }
                                }else{
                                    System.out.println(" Hewan dengan ID tersebut tidak ada.");
                                    pause();
                                }
                            }
                        } catch(Exception e){}
                    
                    }else{
                        System.out.println(" -- Hewan Kosong - -");
                        pause();
                    }
                    break;
                    
                    
                // Lihat Daftar Perlengkapan
                case 2:
                    unEmpt = showAll(dataPerlengkapan, admin);
                    
                    if(unEmpt == true){
                        System.out.print("\n\n Ketik 9999 untuk kembali.");
                        System.out.print("\n ID Perlengkapan dipilih: ");

                        try{
                            index = Integer.parseInt(br.readLine());
                            if(index == 9999){}
                            else{
                                index = SequentialSearch(dataPerlengkapan, index);
                            }
                            if(index == -1){
                                System.out.println(" Perlengkapan dengan ID tersebut tidak ada.");
                                pause();
                            }else{
                                Mn.cls();
                                index = SequentialSearch(dataPerlengkapan, index);
                                
                                if(admin == false){
                                    equipBuy = dataPerlengkapan.get(index).buy();
                                    
                                    if(equipBuy != 0){
                                        keranjangP.add(new keranjangPerlengkapan(activeUser,
                                                dataPerlengkapan.get(index).Harga,
                                                dataPerlengkapan.get(index).ID,
                                                equipBuy, 
                                                dataPerlengkapan.get(index).Nama));
                                        System.out.println(" Peralatan berhasil dimasukkan ke keranjang.");
                                    }
                                } else{
                                    dataPerlengkapan.get(index).show();
                                }
                                pause();
                            }
                        } catch(Exception e){}
                        
                    }else{
                        System.out.println(" -- Peralatan Kosong - -");
                        pause();
                    }
                    break;
                
                    
                // Tambah Data Hewan
                case 3:
                    if(admin == false){break;}
                    
                    index = maxIDHewan;
                    
                    dataHewan.add(new hewan(index,null,null,null,
                                       null,null,0,0,null, false));
                    index = SequentialSearch(dataHewan, index);
                    try{
                        dataHewan.get(index).add();
                        maxIDHewan++;
                    } catch (Exception e){
                        System.out.println(" Terjadi error saat menginput data.");
                        dataHewan.remove(index);
                    }
                    
                    pause();
                    break;
                    
                    
                // Hapus Data Hewan
                case 4:
                    if(admin == false){break;}
                    try{
                        System.out.print(" Masukkan ID hewan yang ingin dihapus: ");
                        getId = Integer.parseInt(br.readLine());
                        index = SequentialSearch(dataHewan,getId);
                    } catch (Exception e){
                        break;
                    }
                    
                    if(index != -1){
                        Mn.cls();
                        dataHewan.get(index).show();
                        if(dataHewan.get(index).Keranjang == true){
                            System.out.println(" Kesalahan: Hewan berada di suatu keranjang.");
                            pause();
                            break;
                        }else if(dataHewan.get(index).delete() == true){
                            dataHewan.remove(index);
                        }
                        
                    } else{
                        System.out.println(" Tidak ada data hewan dengan ID " + getId);
                    }
                    pause();
                    break;
                    
                    
                // Ubah Data Hewan
                case 5:
                    if(admin == false){break;}
                    System.out.print(" Masukkan ID hewan yang ingin diedit: ");
                    try{
                        getId = Integer.parseInt(br.readLine());
                        index = SequentialSearch(dataHewan,getId);
                        if(index != -1){
                            if(dataHewan.get(index).Keranjang == false){
                                Mn.cls();
                                try{
                                    dataHewan.get(index).edit();
                                } catch (Exception e){
                                    System.out.println(" Terjadi error saat menginput data.");
                                }
                            }else{
                                System.out.println(" Hewan sedang berada di keranjang.");
                            }
                        } else{
                            System.out.println(" Tidak ada data hewan dengan ID " + getId);
                        }
                        pause();
                    }catch(Exception e){}
                    break;
                    
                    
                // Tambah Data Perlengkapan
                case 6:
                    if(admin == false){break;}
                    
                    index = maxIDPerlengkapan;
                    
                    dataPerlengkapan.add(new perlengkapan(index, null, 0, null,
                             0, null, 0));
                    index = SequentialSearch(dataPerlengkapan, index);
                    
                    try{
                        dataPerlengkapan.get(index).add();
                    } catch (Exception e){
                        System.out.println(" Terjadi error saat menginput data.");
                        dataPerlengkapan.remove(index);
                    }
                    
                    pause();
                    break;
                    
                    
                // Hapus Data Perlengkapan
                case 7:
                    if(admin == false){break;}
                    try{
                        System.out.print(" Masukkan ID perlengkapan yang ingin dihapus: ");
                        getId = Integer.parseInt(br.readLine());
                        index = SequentialSearch(dataPerlengkapan,getId);
                    }catch(Exception e){
                        break;
                    }
                    
                    
                    if(index != -1){
                        Mn.cls();
                        dataPerlengkapan.get(index).show();
                        if(dataPerlengkapan.get(index).Keranjang > 0){
                            System.out.println(" Kesalahan: Perlengkapan berada di suatu keranjang.");
                            pause();
                            break;
                        }else if(dataPerlengkapan.get(index).delete() == true){
                            dataPerlengkapan.remove(index);
                        }
                        
                    } else{
                        System.out.println(" Tidak ada data perlengkapan dengan ID " + getId);
                    }
                    pause();
                    break;
                    
                    
                // Ubah Data Perlengkapan
                case 8:
                    if(admin == false){break;}
                    System.out.print(" Masukkan ID perlengkapan yang ingin diedit: ");
                    try{
                        getId = Integer.parseInt(br.readLine());
                        index = SequentialSearch(dataPerlengkapan,getId);
                        if(index != -1){
                            Mn.cls();
                            try{
                                dataPerlengkapan.get(index).edit();
                            } catch (Exception e){
                                System.out.println(" Terjadi error saat menginput data.");
                            }
                        } else{
                            System.out.println(" Tidak ada data perlengkapan dengan ID " + getId);
                        }
                        pause();
                    }catch(Exception e){}
                    break;
                    
                // Lihat Informasi Akun
                case 9:
                    Mn.cls();
                    try{
                        dataAkun.get(SequentiallyUsername(dataAkun, activeUser)).informasiAkun();
                    }catch(Exception e){
                        SuperAdm.informasiAkun();
                    }
                    
                    pause();
                    break;
                    
                    
                
                // Tambah Akun Admin    
                case 10:
                    if(!activeUser.equals(SuperAdm.getUsn())){
                        break;
                    }
                    try{
                        dataAkun.add(SuperAdm.tambahAdmin(maxIDAkun, dataAkun));
                        maxIDAkun++;
                        System.out.println(" Akun Berhasil Ditambahkan");
                    } catch (Exception e){
                        dataAkun.remove(index);
                    }
                    pause();
                    break;
                    
                    
                // Lihat Daftar Akun Admin
                case 11:
                    if(!activeUser.equals(SuperAdm.getUsn())){
                        break;
                    }
                    
                    SuperAdm.listAdmin(dataAkun);
                    
                    pause();
                    break;
                    
                    
                  
                // Lihat Riwayat Pembelian
                case 99:
                    IDUser = 0;
                    try{
                        IDUser = dataAkun.get(SequentiallyUsername(dataAkun, activeUser)).getID();
                    }catch(Exception e){
                        IDUser = 99999;
                    }finally{
                        try{
                            for(catatanPembelian ctn : historyP){
                                ctn.lihatCatatan(admin, IDUser);
                            }

                            System.out.print("\n Masukkan ID Catatan Pembelian: ");
                            index = Integer.parseInt(br.readLine());

                            try{
                                index = SequentialSearch(historyP, index);
                            } catch(Exception e){
                                index = 9999;
                            } finally{
                                if (admin == true){
                                    IDUser = 99999;
                                }
                                historyP.get(index).lihatCatatan(IDUser);
                                pause();
                            }

                        }catch(Exception e){}
                    }
                    break;
                    
                   
                    
                // Lihat Keranjang
                case 100:
                    Mn.cls();
                    priceH = 0;
                    priceP = 0;
                    System.out.println(" Keranjangku\n"
                                     + "  -----------------"
                                     + " | Keranjang Hewan |"
                                     + "  -----------------");
                    getId = -1;
                    try{
                        for (int i = 0; i < keranjangH.size(); i-=-1){
                            getId += 1;
                            if(keranjangH.get(i).USP.equals(activeUser)){
                                dataHewan.get(SequentialSearch(dataHewan, keranjangH.get(i).ID_Item)).show();
                                priceH += dataHewan.get(SequentialSearch(dataHewan, keranjangH.get(i).ID_Item)).Harga;
                            }
                        }
                    }catch(Exception e){
                    }finally{
                        if(priceH == 0){
                            System.out.println(" -- Keranjang Kosong --\n");
                        }
                    }
                    
                    System.out.println("\n  --------------"
                                     + " | Keranjang Perlengkapan |"
                                     + "  -------------");
                    
                    
                    Catat = "";
                    try{
                        for (int i = 0; i < keranjangP.size(); i-=-1){
                            if(keranjangP.get(i).USP.equals(activeUser)){
                                Catat += " " + (i+1) + ". " + keranjangP.get(i).Nama
                                                   + "\t" + keranjangP.get(i).Banyak + " Buah, Seharga"
                                                   + " Rp " + keranjangP.get(i).totalHarga;
                                priceP += keranjangP.get(i).totalHarga;
                            }
                            System.out.println(Catat);
                        }
                    }catch(Exception e){
                    }finally{
                        if(priceP == 0){
                            System.out.println(" -- Keranjang Kosong --");
                        }
                    }
                    
                    if(priceH != 0 || priceP != 0){
                        System.out.println("\n\n Total Harga: Rp " + (priceH + priceP) + "\n");
                    
                        System.out.println(" Lakukan pembelian? (Ketik Y atau Ya untuk mengonfirmasi.)");
                        String konf = br.readLine().toUpperCase();
                        if(konf.equals("Y") || konf.equals("YA")){
                            index = 0;
                            for(catatanPembelian historyPSlot : historyP){
                                index += 1;
                            }
                            
                            if (priceH != 0){
                                int IndeksKH = getId;
                                getId = dataHewan.get(SequentialSearch(dataHewan, keranjangH.get(getId).ID_Item)).ID;
                                keranjangH.remove(IndeksKH);
                            }
                            
                            historyP.add(new catatanPembelian(index,
                                                              dataAkun.get(SequentiallyUsername(dataAkun, activeUser)).getID(),
                                                               " Hewan dibeli: "
                                                               + ((priceH == 0)? " |--" : 
                                                               dataHewan.get(getId).Nama)
                                                               + "-- Harga: " + priceH
                                                               + "\n\n Perlengkapan dibeli:\n"
                                                               + Catat
                                                               + "\n Total Harga: "
                                                               + (priceH + priceP)
                                                              ));
                            
                            if (priceH != 0){
                                dataHewan.remove(getId);
                            }
                            
                            for (int i = 0; i < keranjangP.size(); i-=-1){
                                if(keranjangP.get(i).USP.equals(activeUser)){
                                    getId = keranjangP.get(i).ID_Item;
                                    index = SequentialSearch(dataPerlengkapan, getId);
                                    equipBuy = keranjangP.get(i).Banyak;
                                    dataPerlengkapan.get(index).buy(equipBuy);
                                    keranjangP.remove(i);
                                }
                            }
                            
                            
                            Mn.cls();
                            historyP.get(index).lihatCatatan(dataAkun.get(SequentiallyUsername(dataAkun, activeUser)).getID());
                        }
                    }
                    
                    pause();
                    break;
                    
                // Ubah Password
                case 102:
                    index = SequentiallyUsername(dataAkun, activeUser);
                    System.out.print(" Password Lama: ");
                    Password = br.readLine();
                    if(Password.equals(dataAkun.get(index).getPass())){
                        System.out.print("\n Password Baru: ");
                        dataAkun.get(index).setPass(br.readLine());
                    }
                    break;
                    
               
                case 0:
                    if(admin == true){
                        admin = false;
                    }
                    stats2 = true;
                    break;
                    
                    
                default:
                    break;
            }
        
        
        }
    }
    
    static void pause(){
        // Fake Pause
        
        System.out.println(" Ketik apapun untuk melanjutkan. . .");
        try{
        br.readLine();
        }catch(Exception e){}
    }
    
    static int SequentialSearch(ArrayList data, int Ident){
        
        if(data.get(0).getClass() == hewan.class){
            for(int i = 0; i < data.size(); i++){
                if(((hewan)data.get(i)).ID == Ident){
                    return i;
                }
            }
        }else if(data.get(0).getClass() == perlengkapan.class){
            for(int i = 0; i < data.size(); i++){
                if(((perlengkapan)data.get(i)).ID == Ident){
                    return i;
                }
            }
        }else if(data.get(0).getClass() == akun.class){
            for(int i = 0; i < data.size(); i++){
                if(((akun)data.get(i)).getID() == Ident){
                    return i;
                }
            }
        }else if(data.get(0).getClass() == catatanPembelian.class){
            for(int i = 0; i < data.size(); i++){
                if(((catatanPembelian)data.get(i)).getID() == Ident){
                    return i;
                }
            }
        }
        
        return -1;
    }
    
    static int SequentiallyUsername(ArrayList <akun> Akun, String Username){
        for(int i = 0; i < Akun.size(); i++){
            if(Akun.get(i).getUsn().equals(Username)){
                return i;
            }
        }
        return -1;
    }
    
    static boolean showAll(ArrayList data, boolean Adm){
        boolean UnEmpty = false;
        try{
            if(data.get(0).getClass() == hewan.class){
                for(int i = 0; i < dataHewan.size(); i-=-1){

                    if(dataHewan.get(i).Keranjang == false){

                        System.out.print("\n " + dataHewan.get(i).ID + " /--/ "
                            + dataHewan.get(i).Nama + " /--/ " + dataHewan.get(i).Jenis);

                        UnEmpty = true;
                    }
            }
            
            }else if(data.get(0).getClass() == perlengkapan.class){
                for(int i = 0; i < dataPerlengkapan.size(); i-=-1){
                    if((dataPerlengkapan.get(i).Stok - dataPerlengkapan.get(i).Keranjang) != 0
                            || Adm == true){

                        System.out.print("\n " + dataPerlengkapan.get(i).ID + " /--/ "
                            + dataPerlengkapan.get(i).Nama + " /--/ " + dataPerlengkapan.get(i).Hewan
                            +((Adm == true)? " // -- // Di Keranjang: " + dataPerlengkapan.get(i).Keranjang : ""));
                            UnEmpty = true;
                    }
                }
            }

        } catch (Exception e){
        } finally{
            return UnEmpty;
        }
    }
}