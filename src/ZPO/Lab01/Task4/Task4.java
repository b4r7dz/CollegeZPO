package ZPO.Lab01.Task4;

import javax.swing.*;
import java.util.HashMap;

public class Task4 {
    public static void main(String[] args) throws WrongIntegerInputedException {

        String[] setki = {"sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześćset",
                "siedemset", "osiemset", "dziewięćset"};

        String[] dziesiatki = {" dziesięć", " dwadzieścia", " trzydzieści", " czterdzieści", " pięćdziesiąt",
                " sześćdziesiąt", " siedemdziesiąt", " osiemdziesiąt", " dziewięćdzisiąt"};

        String[] nastki = {" jedenaście", " dwanaście", " trzynaście", " czternaście", " piętnaście",
                " szesnaście", " siedemnaście", " osiemnaście", " dziewiętnaście"};

        String[] jednostki = {" jeden", " dwa", " trzy", " cztery", " pięć", " sześć", " siedem", " osiem", " dziewięć"};


        int s , d, j;

        HashMap<Integer, String> intToNumber = new HashMap();

        for(int i= 100; i< 1000; i++){

            s = i%1000 / 100;
            d = i%100 / 10;
            j = i%10;

            if(d== 1 && j!= 0){
                intToNumber.put(i,setki[s-1] + nastki[j-1]);
            }else if(d!= 0 && j== 0) {
                intToNumber.put(i,setki[s-1] + dziesiatki[d-1]);
            }else if(d== 0 && j== 0) {
                intToNumber.put(i,setki[s-1]);
            }else if(d== 0 && j!= 0) {
                intToNumber.put(i,setki[s-1] + jednostki[j-1]);
            }else{
                intToNumber.put(i,setki[s-1] + dziesiatki[d-1] + jednostki[j-1]);
            }
        }

        int number;
        int getNext = 0;



        while(getNext != 1){

            number = Integer.parseInt(JOptionPane.showInputDialog("number > 99 && number < 1000"));

            if(getNumber(number) != 0){

                JOptionPane.showMessageDialog(null, intToNumber.get(number), "Your number:", JOptionPane.INFORMATION_MESSAGE);

                getNext = JOptionPane.showConfirmDialog(null, "Continue ?", "Wanna input next number ?", JOptionPane.YES_NO_OPTION);
            }else{

                JOptionPane.showMessageDialog(null, "Do you even can read ?", "God no!", JOptionPane.INFORMATION_MESSAGE);

                getNext = JOptionPane.showConfirmDialog(null, "Continue ?", "Wanna input next number ?", JOptionPane.YES_NO_OPTION);

            }

        }

    }

    public static int getNumber(int number)throws WrongIntegerInputedException{

        if(number > 99 && number < 1000){
            return number;
        }else{
            try{
                throw new WrongIntegerInputedException("Wrong imput number");
            }catch(WrongIntegerInputedException e){
                e.printStackTrace(System.err);
            }
            return 0;
        }

    }
}
