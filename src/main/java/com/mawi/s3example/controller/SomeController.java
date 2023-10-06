package com.mawi.s3example.controller;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.mawi.s3example.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SomeController {
    private final S3Service s3Service;

    @GetMapping("/api/someController")
    public String someOk() {
        return "ok";
    }

    @GetMapping("/buckets/list")
    public List<Bucket> listBuckets() {
        return s3Service.listBuckets();
    }

    @GetMapping("/buckets/list/files/{bucketName}")
    public List<S3ObjectSummary> listBucketDir(@PathVariable String bucketName) {
        return s3Service.listObjects(bucketName);
    }

    @PostMapping(value = "/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            s3Service.putFile("my-bucket", file.getOriginalFilename(), file.getInputStream());
        } catch (Exception e) {

            e.printStackTrace();

            return "Failure";
        }

        return "Success";
    }
}
