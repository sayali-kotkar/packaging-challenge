package com.mobiquity.packer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.mobiquity.exception.APIException;

public class Packer {

	private Packer() {
	}

	public static Map<String, List<Item>> pack(String filePath) throws APIException, IOException {

		return InputReader.getFileContents(filePath);

	}

}
