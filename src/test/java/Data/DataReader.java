package Data;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

		// Read file content as String using FileUtils
		//File file = new File("src/test/java/Data/PurchaseOrder.json");

		String jsonContent = FileUtils.readFileToString(new File (filePath), StandardCharsets.UTF_8);

		// Convert JSON String to HashMap using Jackson

		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> dataList = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return dataList;

	}
}
