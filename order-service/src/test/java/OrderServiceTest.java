

import cn.itcast.order.OrderApplication;
import cn.itcast.order.service.OrderService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = OrderApplication.class)
public class OrderServiceTest {

    @Autowired
    OrderService orderService;


    private MockMvc mockMvc;

    @BeforeAll
    public static void  beforeAll(){
        System.out.println("begin All");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("begin Each");
    }

    @Test
    public void test1(){

        orderService.getDog(1);
        orderService.getDog(1);
        orderService.getDog(2);
        orderService.getDog(3);
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("end Each");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("end All");
    }

}
