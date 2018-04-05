package ZPO.Lab04.Task1;

import java.util.Arrays;
import java.text.Collator;
import java.util.Locale;

public class Task1 {
    public static void main(String[] args) {

        String[] names = {"Łukasz", "Ścibor", "Stefania", "Bolek", "Agnieszka",
                "Zyta", "Órszula"};

        Locale.setDefault(new Locale("pl","PL"));

        Collator plCollator = Collator.getInstance(Locale.getDefault());

        long start, stop;



        System.out.println("---- sortStrings() for 100 000 sorts ----");
        start = System.nanoTime();
        for(int i=0; i<100000; i++){
            sortStrings(plCollator, names);
        }

        //System.out.println();
        //sortStrings(plCollator, names);

        stop = System.nanoTime() - start;

        System.out.println(stop + " nsec");
        System.out.println();



        System.out.println("---- fastSortStrings() for 100 000 sorts ----");

        start = System.nanoTime();
        for(int i=0; i<100000; i++){
            fastSortStrings(plCollator, names);
        }

        //System.out.println();
        //fastSortStrings(plCollator, names);

        stop = System.nanoTime() - start;

        System.out.println(stop + " nsec");
        System.out.println();



        System.out.println("---- fastSortStrings2() for 100 000 sorts ----");

        start = System.nanoTime();
        for(int i=0; i<100000; i++){
            fastSortStrings2(plCollator, names);
        }

        //System.out.println();
        //fastSortStrings2(plCollator, names);

        stop = System.nanoTime() - start;

        System.out.println(stop + " nsec");
        System.out.println();

    }

    public static void sortStrings(Collator collator, String[] words){
        String temp;

        for(int i=0; i < words.length; i++){
            for(int j=i+1; j < words.length; j++) {
                if(collator.compare(words[i],words[j]) > 0){
                    temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
/*
        System.out.println("---- sortStrings() ----");
        for (String n : words){
            System.out.println(n);
        }
*/
    }

    public static void fastSortStrings(Collator collator, String[] words){
        Arrays.sort(words, collator);
/*
        System.out.println("---- fastSortStrings() ----");
        for (String n : words){
            System.out.println(n);
        }
        */

    }

    public static void fastSortStrings2(Collator collator, String[] words){

        Arrays.sort(words,
                (a, b) -> collator.compare(a, b));
/*
        System.out.println("---- fastSortStrings2() ----");
        for (String n : words){
            System.out.println(n);
        }
        */

    }



}
