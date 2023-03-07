/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package posttest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Viabel
 */

/* [ Versi Program 01 ]
   -. Belum tersedianya "catatan / riwayat" membuat
      beberapa fitur mungkin berjalan secara tidak
      normal.

   -. Fitur yang kurang akan ditambahkan di versi
      mendatang. Fitur yang ada saat ini semata hanya
      untuk memenuhi nilai.
   
*/

public class main {

    public static void main(String[] args) throws IOException {
        
        // Inisialisasi
        int opsi, getId, index, IDHewanDibeli = 12345
                , equipBuy, Intruder = 0, Spam = 0;
        boolean admin = false, unEmpt = false;
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        ArrayList <hewan> dataHewan = new ArrayList<>();
        ArrayList <perlengkapan> dataPerlengkapan = new ArrayList<>();
        ArrayList <perlengkapan> keranjangPerlengkapan = new ArrayList<>();
        
        
        // Pengisi Kekosongan Sementara
        dataHewan.add(new hewan(0, "Narnia", "Kucing", "Sphinx", 
                "Jantan", "Pink", 1, 5000000, "kucing gweh cuy", false));
        dataPerlengkapan.add(new perlengkapan(0, "Sisir Logam", 10, "Kucing",
                             7000, " adalah sisir untuk kucing", 0));
        
        
        
        // Play
        while(true){
            index = 0;
            opsi = 0;
            getId = 0;
            
            
            if(Intruder == 5){
                throw new SecurityException("Access denied - Percobaan Pembobolan.");
            }
            if(Spam == 10){
                throw new SecurityException("Access denied - Spam Detected");
            }
            cls();
            
            System.out.println("*==================================*");
            // Mode Admin, ketik 2109106039 di pilihan menu ;)
            if(admin == true){
                System.out.println("| Selamat Datang Admin!\n"
                         + "| Silakan pilih menu yang dituju\n"
                         + "| --[1] Lihat Daftar Hewan\n"
                         + "| --[2] Lihat Daftar Perlengkapan\n"
                         + "| --[3] Tambahkan Data Hewan\n"
                         + "| --[4] Hapus Data Hewan\n"
                         + "| --[5] Ubah Data Hewan\n"
                         + "| --[6] Tambahkan Data Perlengkapan\n"
                         + "| --[7] Hapus Data Perlengkapan\n"
                         + "| --[8] Ubah Data Perlengkapan\n"
                         + "| --[0] Keluar dari Mode Admin" );
            }else{
                System.out.println("| Selamat Datang!\n"
                         + "| Silakan pilih menu yang dituju\n"
                         + "| --[1] Lihat Daftar Hewan\n"
                         + "| --[2] Lihat Daftar Perlengkapan\n"
                         + "| --[3] Keranjangku\n"
                         + "| --[0] Keluar" );
            }
            System.out.println("*==================================*");
        
            System.out.print(" Pilihanmu: ");
            
            try{
                opsi = Integer.parseInt(br.readLine());
            } catch (Exception e){
                opsi = -1;
            }
            
            if((opsi == 0 || opsi == 1 || opsi == 2 || opsi == 3) && admin == false){
                Intruder = 0;
                Spam = 0;
                if(opsi == 3 && admin == false){
                    opsi = 100;
                }
            }else if(admin == true){
                Intruder = 0;
                Spam = 0;
            }
            else{
                Intruder += 1;
            }
            
            switch(opsi){
                
                // Lihat Data Hewan
                case 1:
                    unEmpt = false;
                    
                    // Transversal(?)
                    for(int i = 0; i < dataHewan.size(); i-=-1){
                        
                        if(dataHewan.get(i).Keranjang == false){
                            
                        unEmpt = true;
                        System.out.print("\n " + dataHewan.get(i).ID + " /--/ "
                            + dataHewan.get(i).Nama + " /--/ " + dataHewan.get(i).Jenis);
                        }
                    }
                    
                    if (unEmpt == true){
                        System.out.print("\n\n Ketik 9999 untuk kembali.");
                        System.out.print("\n ID Perlengkapan dipilih: ");

                        try{
                            index = Integer.parseInt(br.readLine());
                            if(index == 9999){}
                            else{
                                index = SequentialSearch(dataHewan, index);
                            }
                            if(index == -1){
                                System.out.println(" Hewan dengan ID tersebut tidak ada.");
                                pause();
                            }else
                                if(dataHewan.get(index).Keranjang != true){
                                    cls();
                                    if(admin == false){
                                        if(dataHewan.get(index).buy() == true){
                                            IDHewanDibeli = dataHewan.get(index).ID;
                                        }
                                    }else{
                                        dataHewan.get(SequentialSearch(dataHewan, index)).show();
                                        pause();
                                    }
                                }else{
                                    System.out.println(" Hewan dengan ID tersebut tidak ada.");
                                    pause();
                                }
                        } catch(Exception e){}
                    
                    }else{
                        System.out.println(" -- Hewan Kosong - -");
                        pause();
                    }
                    break;
                    
                    
                // Lihat Daftar Perlengkapan
                case 2:
                    unEmpt = false;
                    
                    // Transversal(?)
                    for(int i = 0; i < dataPerlengkapan.size(); i-=-1){
                        if((dataPerlengkapan.get(i).Stok - dataPerlengkapan.get(i).Keranjang) != 0
                                || admin == true){
                        unEmpt = true;
                        System.out.print("\n " + dataPerlengkapan.get(i).ID + " /--/ "
                            + dataPerlengkapan.get(i).Nama + " /--/ " + dataPerlengkapan.get(i).Hewan
                            +((admin == true)? " // -- // Di Keranjang: " + dataPerlengkapan.get(i).Keranjang : ""));
                        }
                    }
                    
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
                                System.out.println(" Perlengkapan dengan ID tersebu1t tidak ada.");
                                pause();
                            }else{
                                cls();
                                if(admin == false){
                                    equipBuy = dataPerlengkapan.get(SequentialSearch(dataPerlengkapan, index)).buy();

                                    if(equipBuy != 0){
                                        keranjangPerlengkapan.add(dataPerlengkapan.get(SequentialSearch(dataPerlengkapan, index)));
                                        System.out.println(" Peralatan berhasil dimasukkan ke keranjang.");
                                    }
                                } else{
                                    dataPerlengkapan.get(SequentialSearch(dataPerlengkapan, index)).show();
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
                    if(!dataHewan.isEmpty()){
                        index = dataHewan.get(dataHewan.size() - 1).ID + 1;
                    } else{
                        index = 0;
                    }
                    dataHewan.add(new hewan(index,null,null,null,
                                       null,null,0,0,null, false));
                    index = SequentialSearch(dataHewan, index);
                    try{
                        dataHewan.get(index).add();
                    } catch (Exception e){
                        System.out.println(" Terjadi error saat menginput data.");
                        dataHewan.remove(index);
                    }
                    
                    pause();
                    break;
                    
                    
                // Hapus Data Hewan
                case 4:
                    if(admin == false){break;}
                    System.out.print(" Masukkan ID hewan yang ingin dihapus: ");
                    getId = Integer.parseInt(br.readLine());
                    index = SequentialSearch(dataHewan,getId);
                    
                    if(index != -1){
                        cls();
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
                            if(dataHewan.get(index).Keranjang == true){
                                cls();
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
                    if(!dataPerlengkapan.isEmpty()){
                        index = dataPerlengkapan.get(dataHewan.size() - 1).ID + 1;
                    } else{
                        index = 0;
                    }
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
                    System.out.print(" Masukkan ID perlengkapan yang ingin dihapus: ");
                    getId = Integer.parseInt(br.readLine());
                    index = SequentialSearch(dataPerlengkapan,getId);
                    
                    if(index != -1){
                        cls();
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
                            cls();
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
                    
                    
                    
                // Lihat Keranjang
                case 100:
                    if(Intruder != 0){
                        Intruder -= 1;
                        Spam += 1;
                        break;}
                    System.out.println(" Keranjangku\n"
                                     + "  -----------------"
                                     + " | Keranjang Hewan |"
                                     + "  -----------------");
                    if(IDHewanDibeli != 12345){
                        dataHewan.get(SequentialSearch(dataHewan, IDHewanDibeli)).show();
                    }else{
                        System.out.println(" -- Kosong --");
                    }
                    System.out.println("  --------------"
                                     + " | Keranjang Perlengkapan |"
                                     + "  -------------");
                    if(!keranjangPerlengkapan.isEmpty()){
                    for (int i = 0; i < keranjangPerlengkapan.size(); i-=-1){
                        System.out.println(" " + (i+1) + ". " + keranjangPerlengkapan.get(i).Nama);
                        }
                    }else{
                        System.out.println(" -- Kosong --\n");
                    }
                    pause();
                    break;
                    
                // Ubah Mode Admin
                case 2109106039:
                    admin = true;
                    break;
                    
               
                case 0:
                    if(admin == true){
                        admin = false;
                    }else{
                        System.exit(0);
                    }
                    break;
                    
                    
                default:
                    Intruder -= 1;
                    Spam += 1;
                    break;
            }
        
        
        }
    }
    
    static void cls(){
        // Fake ClearScreen
        for(int i = 0; i < 10; i++){
            System.out.println("\n");
        }
    }
    
    static void pause(){
        // Fake Pause
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
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
        }
        
        return -1;
    }
}
