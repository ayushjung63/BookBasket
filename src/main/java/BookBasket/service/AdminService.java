package BookBasket.service;

import BookBasket.model.Admin;

public interface AdminService {
	Boolean addAdmin(Admin admin);
	
	Boolean loginAdmin(String username);
}
