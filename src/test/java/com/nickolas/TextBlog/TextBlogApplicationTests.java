package com.nickolas.TextBlog;

import com.nickolas.TextBlog.Controllers.RibbonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TextBlogApplicationTests {

	@Autowired
	private RibbonController ribbonController;

	@Test
	void contextLoads() throws Exception {
		assertThat(ribbonController).isNotNull();
	}




}
