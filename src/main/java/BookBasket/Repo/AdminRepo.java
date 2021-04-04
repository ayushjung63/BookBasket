package BookBasket.Repo;

import BookBasket.model.Admin;

public interface AdminRepo {
	Boolean add(Admin admin);
	Boolean findAdmin(String username);
	Boolean approveBook(int id);
}
