package com.filesize.controller;

import com.filesize.model.FileSize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by parvinder.kumar on 3/1/2017.
 */
@Controller
@RequestMapping("/getsize")
public class FileSizeController {
    FileSize fileSizes=new FileSize();

  /*  @RequestMapping(value = "/showfilesizes",method = RequestMethod.GET)
    public  String getSize(Model model){
        MultipartFile file=fileSizes.getFileSize();
        long size=file.getSize();
        System.out.print("get method");
        return "test";
    }*/

    @RequestMapping(value="/showfilesize",method = RequestMethod.POST)
    public  @ResponseBody  FileSize getSize(@RequestParam("file")MultipartFile file){
        System.out.print("TESt");
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                System.out.print(serverFile.getAbsolutePath());

                System.out.print("You successfully uploaded file=" + file.getOriginalFilename());
            } catch (Exception e) {
                System.out.print("You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage());
            }
        } else {
            System.out.print("You failed to upload " + file.getOriginalFilename()
                    + " because the file was empty.");
        }
        Long size=file.getSize();
        fileSizes.setFilesize(size);
        System.out.print(size);
           return fileSizes;
    }
}
