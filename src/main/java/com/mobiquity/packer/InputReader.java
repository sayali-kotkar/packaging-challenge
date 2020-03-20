package com.mobiquity.packer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class InputReader {

	public static String SPACE_PATTERN = " ";
	public static String WEIGHT_COST_SEPAPATOR_PATTERN = "^\\D+(\\d+),(\\d+.\\d+),€(\\d+).*";

	public static Map<String, List<Item>> getFileContents(String filePath) throws IOException {
		Map<String, List<Item>> filecontents = new HashMap<>();

		Stream<String> lines = Files.lines(Paths.get(filePath));

		lines.forEach(line -> {
			List<Item> itemList = new ArrayList<>();
			String[] splits = line.split("\\:");

			Stream<String> values = Pattern.compile(SPACE_PATTERN).splitAsStream(splits[1]);
			values.forEach(value -> {
				Matcher m = Pattern.compile(WEIGHT_COST_SEPAPATOR_PATTERN).matcher(value);
				if (m.find()) {
					Item item = new Item(m.group(1), Float.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
					itemList.add(item);

				}
			});

			filecontents.put(splits[0].trim(), itemList);
		});
		return filecontents;
	}
}
