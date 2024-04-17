package com.tsys.tsep.controller;

import com.tsys.tsep.manifest.ManifestProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManifestController {

    @Autowired
    private ManifestProcessor manifestProcessor;


    @GetMapping("/getManifest")
    public String getManifestString() throws Exception {
        return manifestProcessor.generateFinalManifest();
    }
}
