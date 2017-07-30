package com.OnlineKartZone.CKartonline;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;

import com.OnlineKartZone.CKartonline.Dao.UserDao;
import com.OnlineKartZone.CKartonline.Dao.UserDao;
import com.OnlineKartZone.CKartonline.Model.User;
import com.OnlineKartZone.CKartonline.Model.User;
public class UserTestCase 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.OnlineKartZone.CKartonline");
		
		context.refresh();
		
		
		UserDao userDao=(UserDao)context.getBean("userDao");
		
		
		User user=new User();
		
		user.setUname("AnujaM");
		
		user.setUaddr("Aalandi");
		
		user.setCname("Anuja Mane");
		
		user.setUpass("anum");
		
		user.setUemail("Anuja@gmail.com");
		user.setUmobile("9785641233");
		
		user.setUrole("User");
		
		user.setEnabled(true);
		
		userDao.insertUpdateUser(user);		
		System.out.println("User Inserted");
		
		
		
		/*User user=userDao.getUser("AnujaM");
		System.out.println("User Name:"+user.getUname());
		System.out.println("User address:"+user.getUaddr());
		System.out.println("User Name:"+user.getCname());
		System.out.println("User Name:"+user.getUpass());
		System.out.println("User Name:"+user.getUemail());
		System.out.println("User Name:"+user.getUmobile());
		System.out.println("User Name:"+user.isEnabled());*/
		
		
		
		//Deletion TestCase
		/*User user=UserDao.getUser('AnujaM');
		userDao.deleteUser(user);
		System.out.println("The User Deleted");*/
		
		
		/*List<User> list=userDao.getUserDetails();
		
		for(User user:list)
		{
			System.out.println("user.getUname()+":"+user.getUaddr()+":"+user.getCname()+":"+user.getUpass()+":"+user.getUemail()+":"+user.getUmobile()+":"+user.isEnabled());
		}*/
		
		/*//Update the User
		User user=userDao.getUser(2);
		user.setUname("anum");
		userDao.insertUpdateUser(user);
		System.out.println("The User Updated");
		*/
	
	}

}
