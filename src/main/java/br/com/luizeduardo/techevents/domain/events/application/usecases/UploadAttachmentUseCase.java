package br.com.luizeduardo.techevents.domain.events.application.usecases;

import br.com.luizeduardo.techevents.domain.events.application.dto.UploadAttachmentRequestDTO;
import br.com.luizeduardo.techevents.domain.events.application.upload.UploadGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadAttachmentUseCase {

	@Autowired
	private UploadGateway uploadGateway;

	public String execute(UploadAttachmentRequestDTO dto) throws Exception {
		try {
			return this.uploadGateway.upload(
				dto.file()
			);
		} catch (Exception e) {
			throw  new Exception(e.getMessage());
		}
	}
}
