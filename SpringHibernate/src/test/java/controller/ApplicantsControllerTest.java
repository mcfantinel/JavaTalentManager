package controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import config.TestBeanConfig;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
public class ApplicantsControllerTest {

	@Autowired
	private ApplicantsController applicantsController;
	
	@Test
	public void applicantsList_Test() {
		String result =  applicantsController.listApplicants(null);
		assertNotNull(result);
	}
	
}
