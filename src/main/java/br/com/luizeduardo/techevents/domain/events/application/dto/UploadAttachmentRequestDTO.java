package br.com.luizeduardo.techevents.domain.events.application.dto;

import org.springframework.web.multipart.MultipartFile;

public record UploadAttachmentRequestDTO(
	String fileName,
	MultipartFile file
) {

	public static UploadAttachmentRequestDTO with(
		final String fileName,
		final MultipartFile file
	) {
		return new UploadAttachmentRequestDTO(fileName, file);
	}
}
