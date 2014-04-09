package libro.ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 01-abr-2014
 */
public class censura {

    public void aplicaCensura(String fentrada, String fcensura, String fsalida) {
        try {
            File fe = new File(fentrada);
            FileReader fr = new FileReader(fe);
            BufferedReader br = new BufferedReader(fr);

            File fs = new File(fsalida);
            FileWriter fw = new FileWriter(fs);

            String s;
            while ((s = br.readLine()) != null) {
                File fc = new File(fcensura);
                FileReader frc = new FileReader(fc);
                BufferedReader brc = new BufferedReader(fr);

                String scen;
                while ((scen = brc.readLine()) != null) {
                    StringTokenizer str = new StringTokenizer(scen);
                    s = s.replace(str.nextToken(), str.nextToken());
                }
                System.out.println(s);
                fw.write(s);
                fw.write("\r\n");

                if (frc != null) {
                    frc.close();
                }
            }
            if (fw != null) {
                fw.close();
            }
            if (fr != null) {
                fr.close();
            }
        } catch (FileNotFoundException fnf) {
            System.err.println("Fichero no encontrado");
        } catch (IOException e) {
            System.err.println("Se ha producido una IOException: ");
            e.printStackTrace();
        } catch (Throwable e) {
            System.err.println("Error del programa: " + e);
            e.printStackTrace();
        }  
    }
    public static void main(String[] args) {
        censura c= new censura();
        c.aplicaCensura("datos.txt", "censura.txt", "salida.txt");
    }
}
