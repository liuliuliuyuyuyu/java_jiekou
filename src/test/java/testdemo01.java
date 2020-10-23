import com.ynd.jiekou.wework.Wework;
import com.ynd.jiekou.wework.WeworkConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class testdemo01 {
    @Test
    public void testbaidu(){
        given()
                .log().all().get("https://www.baidu.com").
                then().log().all().statusCode(200);
    }

    @Test
    public void testmp3() {
        given()
                .queryParam("wd", "mp3")
                .when().get("http://www.baidu.com/s")
                .then().log().body().statusCode(200);
    }

    @Test
    public void testtoken(){
        Wework wework = new Wework();
        String token = wework.getToken();
        Assert.assertEquals("token",token);
        System.out.println("token");
        Assert.assertEquals("cookies", WeworkConfig.getInstance().cookies);
        System.out.println("cookies");
    }

}
