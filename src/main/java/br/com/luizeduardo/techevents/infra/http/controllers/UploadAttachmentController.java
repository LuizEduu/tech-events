package br.com.luizeduardo.techevents.infra.http.controllers;

import br.com.luizeduardo.techevents.domain.events.application.dto.UploadAttachmentRequestDTO;
import br.com.luizeduardo.techevents.domain.events.application.usecases.UploadAttachmentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadAttachmentController {

	@Autowired
	private UploadAttachmentUseCase useCase;

	@PostMapping(path = "/attachments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> handle(@RequestParam("fileName") String fileName,
																			 @RequestParam("file") MultipartFile file) throws Exception {

		final var uploadAttachmentDTO = UploadAttachmentRequestDTO.with(
			fileName,
			file
		);

		final var url = useCase.execute(uploadAttachmentDTO);

		return ResponseEntity.status(HttpStatus.CREATED).body(url);
	}

}
