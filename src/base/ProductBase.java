package base;


import org.hibernate.Session;
import org.hibernate.Transaction;

import base.*;

public class ProductBase {
	
	
	public  int saveProduct(Product product) {
		int SuccessCheck=1;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(product);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				SuccessCheck = 0;
				transaction.rollback();
			}
			SuccessCheck = 0;
			e.printStackTrace();		
		}
		return SuccessCheck;
	}
}