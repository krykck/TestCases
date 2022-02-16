import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class TestCase1 {
	@Test
	public void Test1() {

		int size = given().header("Accept", "application/json").when().get("/api/persons/").then().extract().jsonPath()
				.getList("$").size();

		assertEquals(size, 0);

	}

}
