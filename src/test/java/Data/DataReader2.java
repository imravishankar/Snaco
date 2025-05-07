package Data;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataReader2 {

	@Test
	
	public void getJsonDataToMap() throws IOException {
		
		try {
			
			// Read file content as String using FileUtils
			File file = new File("src/test/java/Data/PurchaseOrder.json");
			
			String jsonContent = FileUtils.readFileToString(file,StandardCharsets.UTF_8);
			
			// Convert JSON String to HashMap using Jackson
			
			ObjectMapper mapper = new ObjectMapper();
			
			List<HashMap<String, String>> dataList = 
					mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});


			//			HashMap<String, String> dataMap = mapper.readValue(jsonContent, HashMap.class);
			// Use the data
//            System.out.println("Username: " + dataMap.get("username"));
//            System.out.println("Password: " + dataMap.get("password"));
//            System.out.println("URL: " + dataMap.get("url"));
			
			//Map<String, Object> jsonMap = mapper.readValue(jsonContent, new TypeReference<>() {});
			// Print the entire map (or handle it as needed)
//            System.out.println("Parsed JSON Map:");
//            printMap(jsonMap, 0);
			
			for (HashMap<String, String> data : dataList) {
                System.out.println("Email: " + data.get("email"));
                System.out.println("Password: " + data.get("password"));
                System.out.println("Product: " + data.get("product"));
                System.out.println("--------------");
            }
		}
		catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}


////Recursive method to print nested map
//private static void printMap(Map<String, Object> map, int indent) {
//    String indentStr = "  ".repeat(indent);
//    for (Map.Entry<String, Object> entry : map.entrySet()) {
//        System.out.print(indentStr + entry.getKey() + ": ");
//        if (entry.getValue() instanceof Map) {
//            System.out.println();
//            printMap((Map<String, Object>) entry.getValue(), indent + 1);
//        } else if (entry.getValue() instanceof Iterable) {
//            System.out.println();
//            for (Object item : (Iterable<?>) entry.getValue()) {
//                if (item instanceof Map) {
//                    printMap((Map<String, Object>) item, indent + 1);
//                } else {
//                    System.out.println(indentStr + "  - " + item);
//                }
//            }
//        } else {
//            System.out.println(entry.getValue());
//        }
//    }
//}
//}// Recursive method to print nested map
//private static void printMap(Map<String, Object> map, int indent) {
//    String indentStr = "  ".repeat(indent);
//    for (Map.Entry<String, Object> entry : map.entrySet()) {
//        System.out.print(indentStr + entry.getKey() + ": ");
//        if (entry.getValue() instanceof Map) {
//            System.out.println();
//            printMap((Map<String, Object>) entry.getValue(), indent + 1);
//        } else if (entry.getValue() instanceof Iterable) {
//            System.out.println();
//            for (Object item : (Iterable<?>) entry.getValue()) {
//                if (item instanceof Map) {
//                    printMap((Map<String, Object>) item, indent + 1);
//                } else {
//                    System.out.println(indentStr + "  - " + item);
//                }
//            }
//        } else {
//            System.out.println(entry.getValue());
//        }
//    }
//}
//}