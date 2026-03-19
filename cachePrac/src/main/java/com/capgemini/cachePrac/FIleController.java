package com.capgemini.cachePrac;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("files")
public class FIleController {
	private FileRepository repository;

	public FIleController(FileRepository repository) {
		this.repository = repository;
	}

	@PostMapping("/upload")
	public FileData upload(@RequestParam("file") MultipartFile file) throws IOException {
		FileData data = new FileData();
		data.setFilename(file.getOriginalFilename());
		data.setFiletype(file.getContentType());
		data.setData(file.getBytes());
		FileData saved = repository.save(data);
		return saved;
	}

	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable Integer id) {

		FileData fileData = repository.findById(id).orElseThrow(() -> new RuntimeException("File Not Found"));

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileData.getFilename() + "\"")
				.contentType(MediaType.parseMediaType(fileData.getFiletype())).body(fileData.getData());
	}
}
