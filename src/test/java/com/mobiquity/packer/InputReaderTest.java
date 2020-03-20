package com.mobiquity.packer;

import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class InputReaderTest {

	@Test
	public void shouldReadFileContentsCorrectly() throws IOException {

		Map<String, List<Item>> fileContents = InputReader.getFileContents(
				"C:/Users/Sayali/eclipse-workspace/implementation/target/test-classes/ccorrect_input.txt");
		assertThat(fileContents.size(), Matchers.is(4));

		List<Item> items = fileContents.get("81");
		Optional<Item> item = items.stream().filter(i -> i.getItemId().equals("2")).findAny();
		assertThat(item.isPresent(), Matchers.is(true));
		assertThat(item.get().getCost(), is(98));
		assertThat(item.get().getWeight(), is(88.62F));
		assertThat(items.size(), Matchers.is(6));
	}
}
