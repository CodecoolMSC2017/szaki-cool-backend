package com.codecool.web.controller;

import com.codecool.web.service.ProfileService;
import de.perschon.resultflow.Result;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class PictureController {

    @Autowired
    ProfileService profileService;


    @RequestMapping(value = "/pics/{name}", method = RequestMethod.GET)
    public void getImageAsByteArray(HttpServletResponse response, @PathVariable("name") String name) throws IOException {
        InputStream in = PictureController.class.getResourceAsStream("/pics/" + name);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

    @GetMapping(value = "/pics/profile/{id}")
    public void getProfilePicture(HttpServletResponse res, @PathVariable("id") Integer id) throws IOException {
        Result<String, String> profile = profileService.getProfilePictureName(id);

        String picturePath = profile.isErr() ? "default.png" : profile.getValue().get();

        InputStream in = PictureController.class.getResourceAsStream("/pics/" + picturePath);
        res.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, res.getOutputStream());
    }
}
