package ZPO.Lab01.Task3;

import java.math.BigInteger;

public class Task3 {
    public static void main(String[] args) {

        String number = "05249010440000420076001089";
        char temp, c0 = 'x', c1 = 'x';
        char[] c_arr = new char[30];

        number = number + "2521";

        System.out.println(number);


        for (int i = 0; i < 32; i++) {
            if(i == 0) {
                c0 = number.charAt(0);
            }else if (i == 1) {
                c1 = number.charAt(1);
            }else if (i == 30) {
                c_arr[28] = c0;
            }else if (i == 31) {
                c_arr[29] = c1;
            }else{
                    temp = number.charAt(i);
                    c_arr[i-2] = temp;
                }
            }

        for (int i = 0; i < number.length(); i++) {
            System.out.print(c_arr[i]);
        }

        System.out.println();

        number = new String(c_arr);

        BigInteger bi = new BigInteger(number);
        BigInteger modulo = new BigInteger("97");

        System.out.println(bi.mod(modulo));


    }
}
