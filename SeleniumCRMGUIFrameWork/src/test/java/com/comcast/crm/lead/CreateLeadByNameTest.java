package com.comcast.crm.lead;

import org.testng.annotations.Test;

import com.comcast.crm.generic.objectRepository.HomePage;
import com.comcast.crm.generic.objectRepository.LeadsPage;

import BaseClassUtility.BaseClass;

public class CreateLeadByNameTest extends  BaseClass{


	@Test
	public void createLeadWithNameTest()
	{
		LeadsPage leadp= new LeadsPage(driver);
		HomePage hp=new HomePage(driver);
		hp.clickonlead();
		leadp.clickoncreatelead();

	}
	
	
	
	
	

}
