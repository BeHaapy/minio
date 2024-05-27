package org.qyf.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {


    @Value("${minio.url}")
    String minioUrl;

    @Value("${minio.accessKey}")
    String accessKey;

    @Value("${minio.secretKey}")
    String secretKey;

    @Bean
    public MinioClient bucket1MinioClient() {
        System.out.println(minioUrl);
        System.out.println(accessKey);
        System.out.println(secretKey);
        return MinioClient.builder()
                .endpoint(minioUrl)
                .credentials(accessKey, secretKey)
                .build();
    }
}
