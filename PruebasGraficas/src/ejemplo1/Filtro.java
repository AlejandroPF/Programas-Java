
package ejemplo1;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 03-abr-2014
 */
class Filtro extends FileFilter {

    @Override
    public boolean accept(File f) {
        if(f.isDirectory()){
            return true;
        }
        String extension = f.getName();
        // podemos agregar mas extensiones
        if(extension.endsWith(".txt")){
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        //es la descripcion que vemos
        return "Archivos de texto (.txt)";
    }
    
}
