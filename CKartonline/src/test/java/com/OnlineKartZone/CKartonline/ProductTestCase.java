package com.OnlineKartZone.CKartonline;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;

import com.OnlineKartZone.CKartonline.Dao.ProductDao;
import com.OnlineKartZone.CKartonline.Dao.ProductDao;
import com.OnlineKartZone.CKartonline.Model.Product;
import com.OnlineKartZone.CKartonline.Model.Product;
public class ProductTestCase 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.OnlineKartZone.CKartonline");
		
		context.refresh();
		
		
		ProductDao productDao=(ProductDao)context.getBean("productDao");
		
		
		Product product=new Product();
		
		product.setProdname("Saree");
		product.setProddesc("SouthIndianSilk");
		product.setCatid(15);
		product.setSupid(1);
		product.setProdqty(3);
		product.setProdprc(2500);
		product.setImgpath("resourecs/WEB-INF/Prodimageg/1.jpg");

		productDao.insertUpdateProduct(product);		
		System.out.println("Product Inserted");
		
		
		
		/*Product product=productDao.getProduct(1);
		System.out.println("Product Name:"+product.getProdname());
		System.out.println("Product Description:"+product.getProddesc());
		System.out.println("Product Description:"+product.getCatid());
		System.out.println("Product Description:"+product.getSupid());
		System.out.println("Product Quantity:"+product.getProdqty());
		System.out.println("Product Price:"+product.getProdprc());*/
		
		//Deletion TestCase
		/*Product product=ProductDao.getProduct(2);
		productDao.deleteProduct(product);
		System.out.println("The Product Deleted");
		*/
		
		/*List<Product> list=productDao.getProductDetails();
		
		for(Product product:list)
		{
			System.out.println(product.getProdid()+":"+product.getProdname()+":"+product.getProddesc()+":"+product.getCatid()+":"+product.getSupid+":"+product.getProdqty()+":"+product.getProdprc());
		}*/
		
		/*//Update the Product
		Product product=productDao.getProduct(1);
		product.setProdname("Kashta");
		productDao.insertUpdateProduct(product);
		System.out.println("The Product Updated");
		*/
	
	}

}
