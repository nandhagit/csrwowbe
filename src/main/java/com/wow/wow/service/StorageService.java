package com.wow.wow.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	void store(MultipartFile file) throws Exception;

}
