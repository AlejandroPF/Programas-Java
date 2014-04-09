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
public class cuenta {

    public int cuentaPalabras(String fichero) {
        int contador = 0;
        try {
            File fe = new File(fichero);
            FileReader fr = new FileReader(fe);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                StringTokenizer str;
                str = new StringTokenizer(s);
                contador += str.countTokens();
            }
            if (fr != null) {
                fr.close();
            }
        } catch (FileNotFoundException fnf) {
            System.err.println("Fichero no encontrado: " + fichero);
        } catch (IOException e) {
            System.err.println("Se ha producido una IOException: ");
            e.printStackTrace();
        } catch (Throwable e) {
            System.err.println("Error del programa: " + e);
            e.printStackTrace();
        }
        return contador;
    }

    public void ordenar(String fichero) {
        try {
            File fe = new File(fichero);
            FileReader fr = new FileReader(fe);
            BufferedReader br = new BufferedReader(fr);

            String numeros = new String();
            String s;
            while ((s = br.readLine()) != null) {
                numeros += s + " ";
            }
            System.out.println(numeros);
            if (fr != null) {
                fr.close();
            }
            StringTokenizer str;
            boolean ordenado = false;
            while (!ordenado) {
                ordenado = true;
                String anterior, posterior = "";
                str = new StringTokenizer(numeros);
                anterior = str.nextToken();
                numeros = "";
                while (str.hasMoreTokens()) {
                    posterior = str.nextToken();
                    if (Integer.parseInt(anterior) > Integer.parseInt(posterior)) {
                        String aux = anterior;
                        anterior = posterior;
                        posterior = aux;
                        ordenado = false;
                    }
                    numeros += anterior + " ";
                    anterior = posterior;
                }
                numeros += posterior;
                System.out.println(numeros);
            }
            File fs = new File(fichero);
            FileWriter fw = new FileWriter(fs);

            str = new StringTokenizer(numeros);
            while (str.hasMoreTokens()) {
                fw.write(str.nextToken());
                fw.write("\r\n");
            }
            if (fw != null) {
                fw.close();
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
        cuenta c = new cuenta();
        c.ordenar("numeros.txt");
    }
}
