package BookBasket.utils;

import BookBasket.Repo.AdminRepo;
import BookBasket.Repo.AdminRepoManager;
import BookBasket.Repo.BookRepo;
import BookBasket.Repo.BookRepoManager;
import BookBasket.Repo.OrderRepo;
import BookBasket.Repo.OrderRepoManager;
import BookBasket.Repo.UserRepo;
import BookBasket.Repo.UserRepoManager;

public class RepoFactory {
		public static BookRepo getBookRepo() {
			return new BookRepoManager();
		}
		
		public static UserRepo getUserRepo() {
			return new UserRepoManager();
		}
		
		public static AdminRepo getAdminRepo() {
			return new AdminRepoManager();
		}
		public static OrderRepo getOrderRepo() {
			return new OrderRepoManager();
		}
}
