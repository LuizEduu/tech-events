package br.com.luizeduardo.techevents.domain.events.application.upload;

import org.springframework.web.multipart.MultipartFile;

public interface UploadGateway {
	String upload(MultipartFile file) throws Exception;
}
