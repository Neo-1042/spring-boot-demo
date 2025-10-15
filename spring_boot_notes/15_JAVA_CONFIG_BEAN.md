# Java Config Bean

1. Create @Configuration class.
2. Define @Bean method to configure the bean.
3. Inject bean into our controller.

File: config/SportConfig.java
```java
package com.neo_1042.springcoredemo.config;

import com.neo_1042.springcoredemo.common.Coach;
import com.neo_1042.springcoredemo.common.SwimCoach;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SportConfig {
    
    @Bean
    public Coach swimCoach() {
        return new swimCoach();
    }
}
```

File: rest/DemoController.java
```java
package com.neo_1042.springcoredemo.rest;

import com.neo_1042.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    // Inject the bean using the bean id "swimCoach"
    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());

        myCoach = theCoach;
    }
}
```

- Using the "new" keyword, is that it?
- Why not just annotate the class with @Component?

## Main use case scenario for @Bean

To make an existing third-party class available to the
Spring framework. You may not have access to the source
code of a third-party class, only a *.jar file.

### Real World Project Example (AWS S3)

A project used AWS to stored documents.

**Amazon Simple Storage Service (Amazon S3)**

The team wanted to use the AWS S3 client as a Spring bean
in their application.However, the AWS S3 client code is 
part of AWS SDK, thus, they could
not just write ```@Component``` to that code. Instead,
they had to use ```@Bean```.

File: config/DocumentsConfig.java
```java
package com.luv2code.amazondemo.config;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

public class DocumentsConfig {

    @Bean
    public S3Client remoteClient() {

        // Create an S3 Client to connect to AWS S3
        ProfileCredentialsProvider credentialsProvider =
            ProfileCredentialsProvier.create();
        Region region = Region.US_EAST_1;
        S3Client s3Client = S3Client.builder()
            .region(region)
            .credentialsProvider(credentialsProvider)
            .build();

        return s3Client;
    }
}
```

### Inject the S3Client as a bean and store a document in S3

File: service/DocumentsService
```java
package com.luv2code.amazondemo.services;

import software.amazon.awssdk.services.s3.S3Client;

@Component
public class DocumentsService {

    private S3Client s3Client;

    @Autowired
    public DocumentsService(S3Client theS3Client) {
        s3Client = theS3Client;
    }

    public void processDocument(Document theDocument) {

        // Get the document input stream and file size

        // Store document in AWS S3
        // Create a PUT request for the object
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
            .bucket(bucketName)
            .key(subDirectory + "/" + fileName)
            .acl(ObjectCannedACL.BUCKET_OWNER_FULL_CONTROL)
            .build();

        // Perform the putObject operation to AWS S3
        // using the autowired bean
        s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(fileInputStream, contentLength));
    }
}
```