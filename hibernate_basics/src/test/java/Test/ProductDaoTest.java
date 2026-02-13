package Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductDaoTest {

//	@BeforeEach
//	public void initEmf() {		
//	}
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();

	EntityTransaction et = em.getTransaction();

//	@Test
//	public void testAddProducts() {
//        ProductDao.addProducts(et, em);
//
//        Product p = em.find(Product.class, 1);
//
//        assertNotNull(p);
//        assertEquals("Oil", p.getName());
//        assertEquals(1000, p.getPrice());
//        assertEquals(3, p.getQuantity());
//    }

//    @Test
//    void testUpdateProducts() {
//
//        // First insert
//        ProductDao.addProducts(et, em);
//
//        // Then update
//        ProductDao.updateProducts(et, em);
//
//        Product p = em.find(Product.class, 1);
//
//        assertEquals("hero", p.getName());
//    }
//    
//    @Test
//    void testDeleteProducts() {
//
//        ProductDao.addProducts(et, em);
//
//        ProductDao.deleteProducts(et, em);
//
//        Product p = em.find(Product.class, 1);
//
//        assertNull(p);
//    }

//    @Test
//    void testFindById() {
//
//
//        Product p = em.find(Product.class, 1);
//
//        assertNotNull(p);
//        assertEquals(1, p.getId());
//    }
// 
//    @Test
//    void testFindAllProduct() {
//
//
//        long count = em.createQuery("select p from Product p", Product.class)
//                       .getResultList()
//                       .size();
//
//        assertTrue(count > 0);
//    }

}