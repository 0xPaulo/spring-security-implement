package com.security.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {

  public static boolean fazerUploading(MultipartFile imagem) {
    boolean sucessoUpload = false;
    if (!imagem.isEmpty()) {
      String nomeDoArquivo = imagem.getOriginalFilename();
      try {
        String pastaUploadImagem = "C:\\Users\\Paulo\\vs\\java\\spring-security\\security\\src\\main\\resources\\static\\images\\img-uploads";
        File dir = new File(pastaUploadImagem);
        if (!dir.exists()) {
          dir.mkdir();
        }
        File serverFile = new File(dir.getAbsolutePath() + File.separator + nomeDoArquivo);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
        stream.write(imagem.getBytes());
        stream.close();

        System.out.println(serverFile.getAbsolutePath());
        System.out.println("Vc fez o uploading do arquivo " + nomeDoArquivo + " com sucesso");
        sucessoUpload = true;
      } catch (Exception e) {
        System.out.println("vc falhou em carregar o arquivo " + nomeDoArquivo + " =>" + e.getMessage());
      }
    } else {
      System.out.println("vc falhou em carrega o arquivo pq ele esta vazio!!");
    }
    return sucessoUpload;
  }
}
