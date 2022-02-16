import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

@Test
public class TestCase4 {
	public void Test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("personName", "Isim Soyisim");
		map.put("phoneNumber", "05554443322");
		JSONObject request = new JSONObject(map);
		String name = given().body(request.toJSONString()).when().put("/api/persons/").then().assertThat()
				.statusCode(200).extract().path("personName");
		String number = given().body(request.toJSONString()).when().put("/api/persons/").then().assertThat()
				.statusCode(200).extract().path("phoneNumber");

		assertEquals("Isim Soyisim", name);
		assertEquals("05554443322", number);

	}
}
