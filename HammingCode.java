package hammingcode;

import java.util.Scanner;

public class HammingCode {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("This Program is to detect error using Haming Code ");
        System.out.println("*****************************************************");
        System.out.println();
        System.out.print("Enter Word stored :");
        int k = 4;//

        int[] checkbit1 = new int[k];
        int[] checkbit2 = new int[k];
        int[] error = new int[k];
        int[] dataBits = new int[8];
        int[] wordFetched = new int[8];
        int[] tare = new int[4];

        for (int i = 7; i >= 0; i--) {
            dataBits[i] = input.nextInt();
        }
        System.out.print("Data Bits    :");
        for (int i = 7; i >= 0; i--) {
            System.out.print(dataBits[i]);
        }
        System.out.println();
        System.out.print("Enter Word fetched:");
        for (int i = 7; i >= 0; i--) {
            wordFetched[i] = input.nextInt();
        }
        System.out.print("Word fetched :");
        for (int i = 7; i >= 0; i--) {
            System.out.print(wordFetched[i]);
        }
//        int tare;
// Check bit 1
        tare[0] = (dataBits[0] + dataBits[1]) % 2;
        tare[1] = (tare[0] + dataBits[3]) % 2;
        tare[2] = (tare[1] + dataBits[4]) % 2;
        checkbit1[0] = (tare[2] + dataBits[6]) % 2;

// Check bit 2
        tare[0] = (dataBits[0] + dataBits[2]) % 2;
        tare[1] = (tare[0] + dataBits[3]) % 2;
        tare[2] = (tare[1] + dataBits[5]) % 2;
        checkbit1[1] = (tare[2] + dataBits[6]) % 2;

// Check bit 3
        tare[0] = (dataBits[1] + dataBits[2]) % 2;
        tare[1] = (tare[0] + dataBits[3]) % 2;
        checkbit1[2] = (tare[1] + dataBits[7]) % 2;

// Check bit 4
        tare[0] = (dataBits[4] + dataBits[5]) % 2;
        tare[1] = (tare[0] + dataBits[6]) % 2;
        checkbit1[3] = (tare[1] + dataBits[7]) % 2;

// Check bit 1
        tare[0] = (wordFetched[0] + wordFetched[1]) % 2;
        tare[1] = (tare[0] + wordFetched[3]) % 2;
        tare[2] = (tare[1] + wordFetched[4]) % 2;
        checkbit2[0] = (tare[2] + wordFetched[6]) % 2;

// Check bit 2
        tare[0] = (wordFetched[0] + wordFetched[2]) % 2;
        tare[1] = (tare[0] + wordFetched[3]) % 2;
        tare[2] = (tare[1] + wordFetched[5]) % 2;
        checkbit2[1] = (tare[2] + wordFetched[6]) % 2;

// Check bit 3
        tare[0] = (wordFetched[1] + wordFetched[2]) % 2;
        tare[1] = (tare[0] + wordFetched[3]) % 2;
        checkbit2[2] = (tare[1] + wordFetched[7]) % 2;

// Check bit 4
        tare[0] = (wordFetched[4] + wordFetched[5]) % 2;
        tare[1] = (tare[0] + wordFetched[6]) % 2;
        checkbit2[3] = (tare[1] + wordFetched[7]) % 2;

        System.out.println("");
        System.out.println("Check Bits 1   :");
        for (int i = 3; i >= 0; i--) {
            System.out.print(" " + checkbit1[i]);
        }
        System.out.println("");
        System.out.println("Check Bits 2   :");
        for (int i = 3; i >= 0; i--) {
            System.out.print(" " + checkbit2[i]);
        }
        System.out.println("");

        //nok check error bit
        if (checkbit1[0] + checkbit2[0] == 1) {
            error[0] = 1;
        } else {
            error[0] = 0;

        }
        if (checkbit1[1] + checkbit2[1] == 1) {
            error[1] = 1;
        } else {
            error[1] = 0;

        }
        if (checkbit1[2] + checkbit2[2] == 1) {
            error[2] = 1;
        } else {
            error[2] = 0;

        }
        if (checkbit1[3] + checkbit2[3] == 1) {
            error[3] = 1;
        } else {
            error[3] = 0;
        }
        System.out.println("Error Bits    :");
        for (int i = 3; i >= 0; i--) {
            System.out.print(" " + error[i]);
        }
        System.out.println("");

        //bit position
        int position;
        if (error[0] == 1) {
            position = 1;
        } else {
            position = 0;
        }
        if (error[1] == 1) {
            position = position + 2;
        }
        if (error[2] == 1) {
            position = position + 4;
        }
        if (error[3] == 1) {
            position = position + 8;
        }

        System.out.println("So the error position is at : " + position);
        System.out.println("Thank you using our program <3");
    }

}
