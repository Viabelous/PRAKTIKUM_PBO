/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package posttest;

/**
 *
 * @author Viabel
 */
public class catatanPembelian {
    private int ID;
    private int IDP;
    private String Isi;
    
    public catatanPembelian(int ID_Catatan, int ID_Pembeli, String Isi_Catatan){
        this.ID = ID_Catatan;
        this.IDP = ID_Pembeli;
        this.Isi = Isi_Catatan;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the IDP
     */
    public int getIDP() {
        return IDP;
    }

    /**
     * @param IDP the IDP to set
     */
    public void setIDP(int IDP) {
        this.IDP = IDP;
    }

    /**
     * @return the Isi
     */
    public String getIsi() {
        return Isi;
    }

    /**
     * @param Isi the Isi to set
     */
    public void setIsi(String Isi) {
        this.Isi = Isi;
    }
}
