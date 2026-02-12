package Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.practice.Product;
import com.practice.ProductDao;

public class ProductDaoTest {

	@Test
	public void insertProduct() {

		ProductDao dao = new ProductDao();

		Product product = new Product();
		product.setId(202);
		product.setName("Pencil");
		product.setPrice(250.0);
		product.setQuantity(25410);

		dao.insertData(product);
	}

	@Test
	public void insertDuplicateProductTest() {

		ProductDao dao = new ProductDao();

		// First insert (should succeed)
		Product product1 = new Product();
		product1.setId(500);
		product1.setName("Book");
		product1.setPrice(200.0);
		product1.setQuantity(5);

		dao.insertData(product1);

		// Second insert with SAME ID (should fail)
		Product product2 = new Product();
		product2.setId(500); // duplicate ID
		product2.setName("DuplicateBook");
		product2.setPrice(300.0);
		product2.setQuantity(10);

		assertThrows(Exception.class, () -> {
			dao.insertData(product2);
		});
	}

	@Test
	public void findByIdTest() {

		ProductDao dao = new ProductDao();

		Product p = dao.findById(202);

		assertNotNull(p);
	}
}
