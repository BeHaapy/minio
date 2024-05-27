package org.qyf.minio;


import io.minio.MinioClient;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MinioApplicationTests {

    @Autowired
    MinioClient minioClient;

    @Test
    void contextLoads() {

        System.out.println(ClassLayout.parseInstance(minioClient).instanceSize());

    }

}
