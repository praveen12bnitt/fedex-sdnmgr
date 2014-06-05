package com.manh.fedex.sdn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.manh.fedex.sdn.domain.SDN;
import com.mongodb.gridfs.GridFSFile;

@RestController
@RequestMapping("/sdnupload")
public class SDNUploadController {

	@Autowired
	private GridFsTemplate gridFsTemplate;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(@RequestParam("name") String name, @RequestParam("customerCode") String customerCode,
			@RequestParam("productName") String productName, @RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				GridFSFile mongofile = gridFsTemplate.store(file.getInputStream(), file.getName());
				
				SDN sdn = new SDN();
				sdn.setName(name);
				
				
				
				
				
				return "You successfully uploaded " + name + " into " + name + "-uploaded !";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}
	}
}
