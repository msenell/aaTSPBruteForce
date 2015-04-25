package com.org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mustafa on 26.03.2015.
 */
public class readToFile
{
        static ArrayList<float[]> coor = new ArrayList<float[]>();
        static int[][] distMatrix;
        static boolean mode;

        public void ReadToTxt()  //Dosyadan okuma yapan method.
        {
            coor.clear();
            cSelectFile cs = new cSelectFile();
            String filePath = cs.SelectATextFile();
            String read = "";

            if (filePath != null) {
                int i = 0;
                try {
                    BufferedReader fr = new BufferedReader(new FileReader(filePath));
                    String rLine = "";
                    if(mode)
                    {
                        rLine = fr.readLine();
                        distMatrix = new int[rLine.split(" ").length][rLine.split(" ").length];
                        splitLine(rLine, i);
                        i++;
                    }
                    while ((rLine = fr.readLine()) != null)
                    {

                        splitLine(rLine, i);
                        i++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
/*
            for(int i = 0; i<distMatrix.length; i++) {
                for (int j = 0; j < distMatrix.length; j++)
                    System.out.print(distMatrix[i][j]);
                System.out.println();
            }*/
            //printArray();
        }

        private void splitLine(String read, int ln) {
            String[] sRead = read.split(" ");
            if(mode)
            {
                for(int i = 0; i<distMatrix.length; i++)
                {
                    distMatrix[ln][i] = Integer.parseInt(sRead[i]);
                }
            }
            else
            {
                float[] c = {Float.parseFloat(sRead[1]), Float.parseFloat(sRead[2])};
                coor.add(c);
            }
        }

        private void printArray() {
            int i = 0;
            for (float[] ci : coor) {
                i++;
                System.out.print(ci[0] + " " + ci[1]);
                System.out.println();
            }
        }

}
