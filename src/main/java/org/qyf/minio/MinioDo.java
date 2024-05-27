package org.qyf.minio;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@Component
public class MinioDo {

    @Autowired
    MinioClient minioClient;
    
    String bucketName = "test";



//    @PostConstruct
    public void fileUpload()
            throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            System.out.println("==== start ====");
            // Make 'test' bucket if not exist.
            createBucketIfNotExist();

            // Upload 'D:\test.txt' as object name "test_target.txt" to bucket test
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket(bucketName)
                            .object("test_target02.txt")
                            .filename("D:\\test.txt")
                            .build());
            System.out.println("==== success ====");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        }
        System.out.println("==== end ====");
    }

    private void createBucketIfNotExist() throws ErrorResponseException, InsufficientDataException, InternalException, InvalidKeyException, InvalidResponseException, IOException, NoSuchAlgorithmException, ServerException, XmlParserException {
        boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!found) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        } else {
            System.out.println("Bucket already exists.");
        }
    }
}
