package pl.damiandziura.Entities;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.min;

public class Logic {
    private float Zb[][] = new float[7][363];
    private float Za[][] = new float[7][92];
    private float Zx[][] = new float[7][1202];
    private float Zw[][] = new float[28][92];
    private float sumCounter = 0;
    private float sumDenominator = 0;

    public Logic() {
        setZb();
        setZx();
        setZa();
    }


    public float Blurring(float angle, float distance) {
        int i = (int)(angle+181);
        int j = (int) distance;
        sumCounter = 0;
        sumDenominator = 0;

        float uL3b = Zb[2][i];
        float uL2b = Zb[3][i];
        float uSb = Zb[4][i];
        float uP2b = Zb[5][i];
        float uP3b = Zb[6][i];
        float uDLx = Zx[2][j];
        float uBLx = Zx[3][j];
        float uSRx = Zx[4][j];
        float uBPx = Zx[5][j];
        float uDPx = Zx[6][j];

        //---------------------------//
//          reguły           //
//---------------------------//

        //R1: If L3 and DL then KL2
        float h1 = min(uL3b, uDLx);

        //R2: If L2 and DL then KP1
        float h2 = min(uL2b, uDLx);

        //R3: If S and DL then KP2
        float h3 = min(uSb, uDLx);

        //R4: If P2 and DL then KP2;
        float h4 = min(uP2b, uDLx);

        //R5: If P3 and DL then KL2
        float h5 = min(uP3b, uDLx);

        //R6: If L3 and BL then KL2
        float h6 = min(uL3b, uBLx);

        //R7: If L2 and BL then KS
        float h7 = min(uL2b, uBLx);

        //R8: If S and BL then KP2
        float h8 = min(uSb, uBLx);

        //R9: If P2 and BL then KP2
        float h9 = min(uP2b, uBLx);

        //R10: If P3 and BL then KL2
        float h10 = min(uP3b, uBLx);

        //R11: If L3 and SR then KL2
        float h11 = min(uL3b, uSRx);

        //R12: If L2 and SR then Kl1
        float h12 = min(uL2b, uSRx);

        //R13: If S and SR then KS
        float h13 = min(uSb, uSRx);

        //R14: If P2 and SR then KP1
        float h14 = min(uP2b, uSRx);

        //R15: If P3 and SR then KP2
        float h15 = min(uP3b, uSRx);

        //R16: If L3 and BP then KL2
        float h16 = min(uL3b, uBPx);

        //R17: If L2 and BP then KL2
        float h17 = min(uL2b, uBPx);

        //R18: If S and BP then KL2
        float h18 = min(uSb, uBPx);

        //R19: If P2 and BP then KS
        float h19 = min(uP2b, uBPx);

        //R20: If P3 and BP then  KP2
        float h20 = min(uP3b, uBPx);

        //R21: If L3 and DP then  KL2
        float h21 = min(uL3b, uDPx);

        //R22: If L2 and DP then  KL1
        float h22 = min(uL2b, uDPx);

        //R23: If S and DP then  KL2
        float h23 = min(uSb, uDPx);

        //R24: If P2 and DP then  KL2
        float h24 = min(uP2b, uDPx);

        //R25: If P3 and DP then  KL2
        float h25 = min(uP3b, uDPx);

        for (i = 1; i < 91; i++) {
            float w = i - 46;
            Zw[1][i] = w;
            if (h1 > 0)
                Zw[2][i] = min(Za[3][i], h1);
            else
                Zw[2][i]=0;
            if (h2 > 0)
                Zw[3][i] = min(Za[4][i], h2);
            else
                Zw[3][i]=0;
            if (h3 > 0)
                Zw[4][i] = min(Za[5][i], h3);
            else
                Zw[4][i]=0;
            if (h4 > 0)
                Zw[5][i] = min(Za[6][i], h4);
            else
                Zw[5][i]=0;
            if (h5 > 0)
                Zw[6][i] = min(Za[6][i], h5);
            else
                Zw[5][i]=0;
            if (h6 > 0)
                Zw[7][i] = min(Za[4][i], h6);
            else
                Zw[7][i]=0;
            if (h7 > 0)
                Zw[8][i] = min(Za[6][i], h7);
            else
                Zw[8][i]=0;
            if (h8 > 0)
                Zw[9][i] = min(Za[6][i], h8);
            else
                Zw[9][i]=0;
            if (h9 > 0)
                Zw[9][i] = min(Za[6][i], h9);
            else
                Zw[10][i]=0;
            if (h10 > 0)
                Zw[11][i] = min(Za[2][i], h10);
            else
                Zw[11][i]=0;
            if (h11 > 0)
                Zw[12][i] = min(Za[2][i], h11);
            else
                Zw[12][i]=0;
            if (h12 > 0)
                Zw[13][i] = min(Za[3][i], h12);
            else
                Zw[13][i]=0;
            if (h13 > 0)
                Zw[14][i] = min(Za[4][i], h13);
            else
                Zw[14][i]=0;
            if (h14 > 0)
                Zw[15][i] = min(Za[5][i], h14);
            else
                Zw[15][i]=0;
            if (h15 > 0)
                Zw[16][i] = min(Za[6][i], h15);
            else
                Zw[16][i]=0;
            if (h16 > 0)
                Zw[17][i] = min(Za[2][i], h16);
            else
                Zw[17][i]=0;
            if (h17 > 0)
                Zw[18][i] = min(Za[2][i], h17);
            else
                Zw[18][i]=0;
            if (h18 > 0)
                Zw[19][i] = min(Za[2][i], h18);
            else
                Zw[19][i]=0;
            if (h19 > 0)
                Zw[20][i] = min(Za[4][i], h19);
            else
                Zw[20][i]=0;
            if (h20 > 0)
                Zw[21][i] = min(Za[6][i], h20);
            else
                Zw[21][i]=0;
            if (h21 > 0)
                Zw[22][i] = min(Za[2][i], h21);
            else
                Zw[22][i]=0;
            if (h22 > 0)
                Zw[23][i] = min(Za[3][i], h22);
            else
                Zw[23][i]=0;
            if (h23 > 0)
                Zw[24][i] = min(Za[2][i], h23);
            else
                Zw[24][i]=0;
            if (h24 > 0)
                Zw[25][i] = min(Za[2][i], h24);
            else
                Zw[25][i]=0;
            if (h25 > 0)
                Zw[26][i] = min(Za[5][i], h25);
            else
                Zw[26][i]=0;

            //agregacja
            ArrayList<Float> list = new ArrayList<Float>();
            for(int k = 2; k <=26; k++ )
            {
                list.add(Zw[k][i]);
            }

            Zw[27][i] = Collections.max(list);

            sumCounter = sumCounter + (Zw[1][i] * Zw[27][i]);
            sumDenominator = sumDenominator + Zw[27][i];
        }

        return sumCounter/sumDenominator;
    }

    private void setZx() {
        for(int i = 1; i < 1201; i++) {
            float x = i;
            Zx[1][i] = x;

            //DL Daleko Lewo
            float uDL = 0;
            if (x <= 300) uDL = 1;
            else if (x > 300 && x <= 400) uDL = (400 - x) / (400 - 300);
            Zx[2][i] = uDL;

            //BL Blisko Lewo
            float uBL = 0;
            if (x > 300 && x <= 450) uBL = (x - (300)) / (450 - 300);
            else if (x >= 450 && x <= 600) uBL = (600 - x) / (600 - 450);
            Zx[3][i] = uBL;

            //SR Środek
            float uSR = 0;
            if (x > 500 && x <= 600) uSR = (x - 500) / (600 - 500);
            else if (x > 600 && x <= 700) uSR = (700 - x) / (700 - 600);
            Zx[4][i] = uSR;

            //BP Blisko Prawo
            float uBP = 0;
            if (x > 600 && x <= 750) uBP = (x - 600) / (750 - 600);
            else if (x >= 750 && x <= 900) uBP = (900 - x) / (900 - 750);
            Zx[5][i] = uBP;

            //DP Daleko prawo
            float uDP = 0;
            if (x > 800 && x <= 900) uDP = (x - 800) / (900 - 800);
            else if (x >= 900) uDP = 1;
            Zx[6][i] = uDP;
        }

    }

    private void setZb() {
        for(int i = 1; i < 361; i++) {
            float b = i -181;
            Zb[1][i] = b;

            //L3 Ustawienie mocno w lewo
            float uL3 = 0;
            if (b <= -90) uL3 = 1;
            else if (b > -90 && b <= -30) uL3 = (-30 - b) / (-30 + 90);
            Zb[2][i] = uL3;

            //L2 ustawienie w lewo
            float uL2 = 0;
            if (b > -90 && b <= -45) uL2 = (b - (-90)) / (-45 - (-90));
            else if (b >= -45 && b <= 0) uL2 = (0 - b) / (0 - (-45));
            Zb[3][i] = uL2;

            //S Ustawienie prosto
            float uS = 0;
            if (b > -30 && b <= 0) uS = (b - (-30)) / (0 - (-30));
            else if (b > 0 && b <= 30) uS = (30 - b) / (30 - 0);
            Zb[4][i] = uS;

            //P2 Ustawienie w prawo
            float uP2 = 0;
            if (b > 0 && b <= 45) uP2 = (b - 0) / (45 - 0);
            else if (b >= 45 && b <= 90) uP2 = (90 - b) / (90 - 45);
            Zb[5][i] = uP2;

            //P3 Ustawienie mocno w prawo
            float uP3 = 0;
            if (b > 30 && b <= 90) uP3 = (b - 30) / (90 - 30);
            else if (b >= 90) uP3 = 1;
            Zb[6][i] = uP3;
        }
    }

    private void setZa()
    {
        for(int i = 1; i < 91; i++) {
            float a = i -46; //a=i-46.0f;
            Za[1][i] = a;

            //KL2 Kierownica mocno w lewo
            float uKL2 = 0;
            if (a <= -45) uKL2 = 1;
            else if (a > -45 && a <= -20) uKL2 = (-20 - a) / (-20 - (-45));
            Za[2][i] = uKL2;

            //KL1 Kierownica w lewo
            float uKL = 0;
            if (a > -30 && a <= -15) uKL = (a + 30) / (-15 + 30);
            else if (a > -15 && a <= 0) uKL = (0 - a) / (0 + 15);
            Za[3][i] = uKL;

            //KS Kierownica (prawie) prosto
            float uKS = 0;
            if (a > -10 && a <= 0) uKS = (a - (-10)) / (0 - (-10));
            else if (a > 0 && a <= 10) uKS = (10 - a) / (10 - 0);
            Za[4][i] = uKS;

            //KP1 Kierownica w prawo
            float uKP1 = 0;
            if (a > 0 && a <= 15) uKP1 = (a - 0) / (15 - 0);
            else if (a >= 15 && a <= 30) uKP1 = (30 - a) / (30 - 15);
            Za[5][i] = uKP1; //UWAGA!!! było Za[5][1] = uKP1; - przez to nie działało

            //KP2 Kierownica mocno w prawo
            float uKP2 = 0;
            if (a >= 20 && a <= 45) uKP2 = (a - 20) / (45 - 20);
            else if (a >= 45) uKP2 = 1;
            Za[6][i] = uKP2;
        }
    }
}
