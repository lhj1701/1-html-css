package com.git.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class FileController {

    private fianl String
    BUCKET_NAME ="git2021-bucket-pt2";
    private AmazonS3 client;

    @Autowired
    public FileController(AmazonS3 client) {
        this.client = client;
    }

    @PostMapping("/files")
    public String uploadFile(@RequestPart("file") MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());

        // 1. 파일 메타 데이터 생성
        // S3에 올라가는 객체 메타데이터를 설정해줌
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize()); // 50kb

        // 2. 객체 key 생성
        // S3에서는 파일 경로 key
        // 예) 20211022/images/penguin.jpg

        String objectKey = getObjectKey(file.getOriginalFilename());

        PutObjectRequest req = new PutObjectRequest(
                BUCKET_NAME,
                objectKey,
                file.getInputStream(),
                metadata
        );

        //3.

        //4. 객체 업로드
        PutObjectResult result = client.putObject(req);
        System.out.println(result);
        return DISTRIBUTION_URL + objectKey;
    }

    @DeleteMapping("/files/{objectKey}")
    public void deleteFile(@PathVariable String objectKey, HttpServletResponse res) {
        // 버킷에 객체가 있는지 확인
        if (!client.doesObjectExist)
    }

    // OTP : secret + unique + time
    // ex: dlfk;dslkf+kdk+123434425154
    // object key 해시 생성
    private String getObjectKey(String filename) {
        String secret = "git2021";
        return
    }
}
