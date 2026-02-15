package service;

import java.util.List;
import javax.persistence.EntityManager;
import dao.OrderDAO;
import dao.PaymentDAO;
import dao.UserDAO;
import entity.Payment;
import entity.PurchaseOrder;
import entity.User;

public class ECommerceService {
	private UserDAO userDAO;
	private OrderDAO orderDAO;
	private PaymentDAO paymentDAO;
	public ECommerceService(EntityManager em) {
		this.userDAO = new UserDAO(em);
		this.orderDAO = new OrderDAO(em);
		this.paymentDAO = new PaymentDAO(em);
	}
	public void registerUser(User user) {
		userDAO.saveUser(user);
	}
	public void addOrdersToUser(User user, List<PurchaseOrder> orders) {
		user.setOrders(orders);
		userDAO.updateUser(user);
	}
	public void addPaymentToOrder(Payment payment) {
		paymentDAO.savePayment(payment);
	}
	public User fetchUser(Long id) {
		return userDAO.findUser(id);
	}
	public void deleteUser(Long id) {
		userDAO.deleteUser(id);
	}
}