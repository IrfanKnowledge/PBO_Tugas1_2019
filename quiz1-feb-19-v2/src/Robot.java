import java.util.ArrayList;

/*
     Robot yang akan bertarung. Robot punya senjata, perisai dan skor kesehatan.
 */
public class Robot {
    Senjata oSenjata;
    int kesehatan;
    String nama = "";

    Perisai oPerisai;
    ArrayList<Senjata> inventorySenjata = new ArrayList<>(); //tempat menyimpan senjata
    ArrayList<Perisai> inventoryPerisai = new ArrayList<>(); //tempat menyimpan perisai

    //isi senjata milik robot
    /*
    public void  tambahSenjata(Senjata s) {
        oSenjata = s;
    }
    */

    //senjata yang sedang digunakan
    public void  gunakanSenjata(Senjata s) {
        oSenjata = s;
    }
    //menambah senjata ke inventory
    public void tambahSenjataKeInventory(Senjata s){
        this.inventorySenjata.add(s);
    }
    //perisai yang sedang digunakan
    public void  gunakanPerisai(Perisai p) {
        oPerisai = p;
    }
    //perisai yang sedang digunakan
    public void  tambahPerisaiKeInventory(Perisai p) {
        this.inventoryPerisai.add(p);
    }
    //print kesehatan dsb
    public void printStatistik() {
        System.out.println("Nama Robot: "+nama);
        System.out.println("Kesehatan:"+kesehatan);
    }

    //constructor
    public Robot(String vNama) {
        nama = vNama;
        kesehatan = 100; //default
    }

    /* menyerang robot lain, skor kesehatan robot lain akan berkurang
    */
    public void serang(Robot rLawan) {
       //skor kesehatan robot lawan akan dikurangi
        if(rLawan.oPerisai.kekuatan - oSenjata.kekuatan < 0){
            rLawan.kesehatan -= (oSenjata.kekuatan - rLawan.oPerisai.kekuatan);
        }
        if(rLawan.kesehatan <0){
            rLawan.kesehatan = 0;
        }
    }
}
