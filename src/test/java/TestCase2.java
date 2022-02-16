import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

@Test
public class TestCase2 {
	public void Test1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("personName", null);
		map.put("phoneNumber", "05554443322");
		JSONObject request1 = new JSONObject(map);
		given().body(request1.toJSONString()).when().put("/api/persons/").then().statusCode(404);
	}

	public void Test2() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("personName", "Isim Soyad");
		map.put("phoneNumber", null);
		JSONObject request2 = new JSONObject(map);
		given().body(request2.toJSONString()).when().put("/api/persons/").then().statusCode(404);
	}
}
