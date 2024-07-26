package br.com.luizeduardo.techevents.infra.storage;

import br.com.luizeduardo.techevents.domain.events.application.upload.UploadGateway;
import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
public class S3Storage implements UploadGateway {

	@Autowired
	private AmazonS3 s3;

	@Value("${aws.events-img-bucket-name}")
	private String bucketName;


	@Override
	public String upload(MultipartFile multipartFile) throws Exception {
			File file = this.convertMultipartToFile(multipartFile);

			final var name = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

			this.s3.putObject(bucketName, name, file);
			file.delete();

			return s3.getUrl(bucketName, name).toString();

	}

	private File convertMultipartToFile(MultipartFile file) throws IOException, NullPointerException {
		final var originalFileName = Objects.requireNonNull(file.getOriginalFilename());

		File convertedFile = new File(originalFileName);
		FileOutputStream fos = new FileOutputStream(convertedFile);
		fos.write(file.getBytes());
		fos.close();

		return convertedFile;
	}
}
