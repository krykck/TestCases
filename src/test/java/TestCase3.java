import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

@Test
public class TestCase3 {
	public void Test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 3);
		map.put("personName", "Isim Soyisim");
		map.put("phoneNumber", "05554443322");
		JSONObject request = new JSONObject(map);
		given().body(request.toJSONString()).when().put("/api/persons/").then().statusCode(404);
	}
}
