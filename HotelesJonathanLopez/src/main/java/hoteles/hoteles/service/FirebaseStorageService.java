
package hoteles.hoteles.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author Jonathan
 */
@Service
public interface FirebaseStorageService {
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "techshop-14c36.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "C:\\Projectos\\PortafolioJonathanLopezGarcia";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "C:\\Projectos\\PortafolioJonathanLopezGarcia\\Tienda_JonathanLopezGarcia\\src\\main\\resources\\firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-14c36-firebase-adminsdk-akgjy-7df468243c.json";
}//final de la interfaz
