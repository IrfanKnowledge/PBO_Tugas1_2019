/*
     Menjalankan pertarungan antar dua robot

 */

public class Arena {
    private Robot robot1;
    private Robot robot2;

    public Robot getRobot1(){
        return this.robot1;
    }
    public Robot getRobot2(){
        return this.robot2;
    }

    public void tambahRobot(Robot r1,Robot r2) {
        robot1 = r1;
        robot2 = r2;
    }

    public void bertanding() {
        //UI sederhana untuk pertandingan

        //loop sampai salah satu robot habis skor kesehatannya
        boolean isSelesai = false;

        //LENGKAPI dengan NIM dan NAMA
        System.out.println("Saya berjanji tdk berbuat curang dan/atau membantu orang lain berbuat curang");
        System.out.println(" Tugas 1 6 Maret 2019 ");
        System.out.printf(" %-7s    %-21s\n", "NIM", "NAMA");
        System.out.printf(" %-7s    %-21s\n", "1603719", "IRFAN MUHAMMAD FAISAL");

        System.out.print("Pertandingan dimulai =====\n");

        //player
        Robot robotAktif = robot1;
        Robot robotPasif = robot2;

        while (!isSelesai) {
            System.out.println("");
            System.out.println("Giliran robot:"+robotAktif.nama);
            System.out.println("Robot menyerang dengan senjata " + robotAktif.oSenjata.nama);
            robotAktif.serang(robotPasif);
            //print kesehatan
            robot1.printStatistik();
            robot2.printStatistik();
            //tukar peran
            Robot temp = robotAktif; //supaya tdk tertimpa
            robotAktif = robotPasif;
            robotPasif = temp;

            //stop jika salah satu robot skor kesehatanya nol
            isSelesai = (robotAktif.kesehatan<=0 || robotPasif.kesehatan<=0);
        }
        System.out.println("Pertandingan Selesai\n");

        //cek pemenang
        //lengkapi
        if(robot1.kesehatan <=0 && robot2.kesehatan <=0){
            System.out.println("Pemenang: Tidak Ada (Draw)");
        }else if(robot1.kesehatan >0){
            System.out.println("Pemenang: " + robot1.nama);
        }else if(robot2.kesehatan >0){
            System.out.println("Pemenang: " + robot2.nama);
        }
    }

    public static void main(String[] args) {
        //buat arena
        Arena oArena = new Arena();

        //siapkan robot
        Robot robot1 = new Robot("Robot pertama");
        Robot robot2 = new Robot("Robot kedua");

        //tambahkan senjata ke robot
        Senjata oSenjataPukulan1 = new SenjataPukulan();
        Senjata oSenjataKilat1 = new SenjataKilat();
        Senjata oSenjataLegenda1 = new SenjataLegenda();

        //robot1.tambahSenjata(oSenjataPukulan1);
        robot1.tambahSenjataKeInventory(oSenjataPukulan1);
        robot1.tambahSenjataKeInventory(oSenjataKilat1);
        robot1.tambahSenjataKeInventory(oSenjataLegenda1);
        robot1.gunakanSenjata(robot1.inventorySenjata.get(1));

        //tambahkan perisai ke robot
        PerisaiOlympus oPerisaiOlumpus1 = new PerisaiOlympus();
        PerisaiAtlantis oPerisaiAtlantis1 = new PerisaiAtlantis();

        robot1.tambahPerisaiKeInventory(oPerisaiOlumpus1);
        robot1.tambahPerisaiKeInventory(oPerisaiAtlantis1);
        robot1.gunakanPerisai(oPerisaiOlumpus1);

        Senjata oSenjataPukulan2 = new SenjataPukulan();
        Senjata oSenjataKilat2 = new SenjataKilat();
        Senjata oSenjataLegenda2 = new SenjataLegenda();

        //robot2.tambahSenjata(oSenjataPukulan2);
        robot2.tambahSenjataKeInventory(oSenjataPukulan2);
        robot2.tambahSenjataKeInventory(oSenjataKilat2);
        robot2.tambahSenjataKeInventory(oSenjataLegenda2);
        robot2.gunakanSenjata(robot2.inventorySenjata.get(2));

        //tambahkan perisai ke robot
        PerisaiOlympus oPerisaiOlympus2 = new PerisaiOlympus();
        PerisaiAtlantis oPerisaiAtlantis2 = new PerisaiAtlantis();
        robot2.tambahPerisaiKeInventory(oPerisaiOlympus2);
        robot2.tambahPerisaiKeInventory(oPerisaiAtlantis2);
        robot2.gunakanPerisai(robot2.inventoryPerisai.get(0));

        //tambahkan robot ke arena
        oArena.tambahRobot(robot1,robot2);

        //mainkan
        oArena.bertanding();

    }
}
