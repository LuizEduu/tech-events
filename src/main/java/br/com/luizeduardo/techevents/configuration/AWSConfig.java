package br.com.luizeduardo.techevents.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {

	@Value("${aws.region}")
	private String awsRegion;

	@Value("${aws.accessKey}")
	private String awsAccessKey;

	@Value("${aws.secretKey}")
	private String awsSecretKey;

	@Bean
	public AmazonS3 createS3Istance() {
		final var credentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
		return AmazonS3ClientBuilder
			.standard()
			.withCredentials(new AWSStaticCredentialsProvider(credentials))
			.withRegion(awsRegion)
			.build();
	}
}
