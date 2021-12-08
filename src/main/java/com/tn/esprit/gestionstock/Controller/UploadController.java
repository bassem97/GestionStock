package com.tn.esprit.gestionstock.Controller;


import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@CrossOrigin("*")
public class UploadController {

    String directory = FileSystems.getDefault()
            .getPath("../../../../Gestion-Stock-Front/src/assets/img/")
            .toAbsolutePath().toString();
            // + "../../../../Gestion-Stock-Front/src/assets/img/";
            //+ "\\src\\main\\java\\com\\tn\\esprit\\gestionstock\\Uploads\\";
    // File f = new File("../../../../Gestion-Stock-Front/src/assets/");

//    String test = "C:\\Users\\Zgon\\Desktop\\Stock\\Gestion-Stock-Front\\src\\assets\\img\\";
    String test = "C:\\Desktop\\4TWIN\\CSA\\Gestion-Stock-Front\\src\\assets\\img\\";

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public String[] uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        file.transferTo(new File(test /*+ "../../../../Gestion-Stock-Front/src/assets/img/"*/ + file.getOriginalFilename()));
        return new String[]{test /*+ "../../../../Gestion-Stock-Front/src/assets/img/"*/ + file.getOriginalFilename()};
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    /*public String[] getImageAsByteArray(HttpServletResponse response) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream(directory + "0_V3jAkzqnFrFTyE9Y.jpg");
        return new String[]{directory + "0_V3jAkzqnFrFTyE9Y.jpg"};
    }*/
    public ByteArrayResource image() {
        try {
            return new ByteArrayResource(Files.readAllBytes(Paths.get(
                    "../../../../Gestion-Stock-Front/src/assets/img/" + "0_V3jAkzqnFrFTyE9Y.jpg"
            )));
        } catch (IOException e) {
            return null;
        }
    }

}
