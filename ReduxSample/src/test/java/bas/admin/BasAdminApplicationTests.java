package bas.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import rhy.sample.RhySampleApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RhySampleApplication.class)
@WebAppConfiguration
public class BasAdminApplicationTests {

	@Test
	public void contextLoads() {
	}

}
