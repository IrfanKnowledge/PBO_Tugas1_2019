import java.util.Scanner;

public class ArenaInteraktif extends Arena {
    private Robot robot1;
    private Robot robot2;

    @Override
    //harus di Override, jika menggunakan method Super class hanya akan menunjuk variable robot1 robot2 di Super-class atau Parent-Class
    public void tambahRobot(Robot r1,Robot r2) {
        robot1 = r1;
        robot2 = r2;
    }

    @Override
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
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        while (!isSelesai) {
            System.out.println("");
            System.out.println("Giliran robot:"+robotAktif.nama);

            boolean isPilihan1 = false; //untuk pengulangan menu memilih menyerang atau ganti senjata atau ganti perisai
            while(!isPilihan1){
                System.out.println("Pilihan: 1. Serang 2. Ganti Senjata 3. Ganti Perisai");
                System.out.print("Pilih Aksi: ");

                switch(input.nextInt()){
                    case 1:
                        isPilihan1 = true;
                        break;
                    case 2: //menu ganti senjata
                        System.out.printf("%-5s    %-25s    %-3s\n", "NO", "NAMA", "KEKUATAN");
                        System.out.println("==============================================");
                        int i = 0;
                        for(Senjata s : robotAktif.inventorySenjata){
                            System.out.printf("%-5d    %-25s    %-3d\n", i+1, s.nama, s.kekuatan);
                            i++;
                        }
                        System.out.println();

                        if(i != 0){   //jika senjata tidak kosong maka aksi pemilihan dilakukan

                            boolean isPilihan2 = false; //untuk Pengulangan memilih senjata selama user salah memberi input
                            int pilihSenjata;           //untuk menampung input user yg akan digunakan sbagai indeks memilih senjata ( input user - 1 )
                            while(!isPilihan2){

                                System.out.print("Pilih Senjata: ");
                                pilihSenjata = input2.nextInt();
                                if(pilihSenjata >i || pilihSenjata <1 ){ //kondisi SALAH jika user menginput DILUAR nilai minimal dan maksimal jumlah senjata yang tersedia
                                    System.out.println("Maaf, pilihan tidak tersedia.");
                                }else{
                                    robotAktif.gunakanSenjata(robotAktif.inventorySenjata.get(pilihSenjata-1)); //mengganti senjata yg sedang digunakan menjadi pilihan user
                                    System.out.println("Senjata yang digunakan: "+
                                            robotAktif.inventorySenjata.get(pilihSenjata-1).nama +
                                            " Kekuatan " +
                                            robotAktif.inventorySenjata.get(pilihSenjata-1).kekuatan);

                                    isPilihan2 = true; //untuk keluar menu memilih senjata
                                }
                            }
                        }else{
                            System.out.println("               Senjata Kosong                 \n");
                            System.out.println("==============================================\n");
                        }
                        break;
                    case 3:
                        System.out.printf("%-5s    %-25s    %-3s\n", "NO", "NAMA", "KEKUATAN");
                        System.out.println("==============================================");
                        int j = 0;
                        for(Perisai s : robotAktif.inventoryPerisai){
                            System.out.printf("%-5d    %-25s    %-3d\n", j+1, s.nama, s.kekuatan);
                            j++;
                        }
                        System.out.println();

                        if(j != 0){   //jika Perisai tidak kosong maka aksi pemilihan dilakukan

                            boolean isPilihan2 = false; //untuk Pengulangan memilih Perisai selama user salah memberi input
                            int pilihPerisai;           //untuk menampung input user yg akan digunakan sbagai indeks memilih Perisai ( input user - 1 )
                            while(!isPilihan2){

                                System.out.print("Pilih Perisai: ");
                                pilihPerisai = input2.nextInt();
                                if(pilihPerisai >j || pilihPerisai <1 ){ //kondisi SALAH jika user menginput DILUAR nilai minimal dan maksimal jumlah Perisai yang tersedia
                                    System.out.println("Maaf, pilihan tidak tersedia.");
                                }else{
                                    robotAktif.gunakanPerisai(robotAktif.inventoryPerisai.get(pilihPerisai-1)); //mengganti Perisai yg sedang digunakan menjadi pilihan user
                                    System.out.println("Perisai yang digunakan: "+
                                            robotAktif.inventoryPerisai.get(pilihPerisai-1).nama +
                                            " Kekuatan " +
                                            robotAktif.inventoryPerisai.get(pilihPerisai-1).kekuatan);

                                    isPilihan2 = true; //untuk keluar menu memilih perisai
                                }
                            }
                        }else{
                            System.out.println("               Perisai Kosong                 \n");
                            System.out.println("==============================================\n");
                        }
                        break;
                    default:
                        System.out.println("Maaf, pilihan tidak tersedia.");
                        break;
                }
            }

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

    public static void main(String[] args){
        //buat arena
        ArenaInteraktif oArena = new ArenaInteraktif();

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
