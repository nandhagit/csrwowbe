package com.wow.wow.serviceimpl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wow.wow.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService {

	private final Path rootLocation = Paths.get("G:\\CSR PROJECT\\images");

	@Override
	public void store(MultipartFile file) throws Exception {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if (file.isEmpty()) {
				throw new Exception("Failed to store empty file " + filename);
			}
			if (filename.contains("..")) {
				// This is a security check
				throw new Exception("Cannot store file with relative path outside current directory " + filename);
			}
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException e) {
			throw new Exception("Failed to store file " + filename, e);
		}
	}

}
