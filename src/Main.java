import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        fileReader();


    }




    private static void ipGen(String ip_string) {



        String[] ips = ip_string.split("/");

        String[] ipB = ips[0].split("\\.");

        long result = 0;

        int shift = 24;

        int value2 = ((Integer.parseInt(ipB[0]) & 0xFF) << 24) |
                ((Integer.parseInt(ipB[1]) & 0xFF) << 16) |
                ((Integer.parseInt(ipB[2]) & 0xFF) << 8)  |
                ((Integer.parseInt(ipB[3]) & 0xFF));

        System.out.println("value2 ="+value2);

        for (String ipBt : ipB){



            long curInt = (long) (Integer.parseInt(ipBt) & 0xFF) <<shift;

            result |=curInt;

            shift-=8;





        }


        long max = result | 0xFF;
        long min = max ^ 0xFF;
//

        for(int i=0;i<=max-min;i++){

            System.out.println(longToIp(min+i));


        }





    }

    private static void fileReader() throws FileNotFoundException {


        File file = new File("/home/mohammad/ips");

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){


            ipGen(scanner.nextLine());





        }

    }


    static String longToIp(long longIp){

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=3;i>=0;i--){

            stringBuilder.append((longIp & (0xFF<<i*8))>>i*8);
            if(i!=0)
                stringBuilder.append(".");



        }


        return stringBuilder.toString();
    }




}