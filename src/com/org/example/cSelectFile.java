package com.org.example;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Created by Mustafa on 21.03.2015.
 */
public class cSelectFile
{
    private void setLookAndFeel() //Dosya seçiçi görünümünü Windows'a uyarlar.
    {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch ( Exception e ) {
            System.err.println( "Could not use Look and Feel:" + e );
        }
    }

    public String SelectATextFile()  //TxT Dosyası Seçmemizi Sağlayan Method.
    {
        String workingDir = System.getProperty("user.dir");
        if(readToFile.mode)
        {
            workingDir += "\\" + "\\Files\\distanceMatrix";
        }
        else
        {
            workingDir += "\\" + "\\Files\\coorList";
        }
        setLookAndFeel();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Only TxT Files", "txt");

        JFileChooser tc = new JFileChooser(workingDir);
        tc.setFileFilter(filter);
        int result = tc.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION) //Secim onaylandı ise
        {
            return tc.getSelectedFile().toString(); //Seçilen Dosyanın Yolunu Döndürür.
        }
        else if(result == JFileChooser.CANCEL_OPTION) //İptal edildi ise
        {
            System.out.println("Islem iptal edildi!");
        }
        else
        {
            System.out.println("Bir hata oluştu!");
        }

        return null;
    }
}
