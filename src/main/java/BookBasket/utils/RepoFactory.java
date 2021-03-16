package BookBasket.utils;

import BookBasket.Repo.BookRepo;
import BookBasket.Repo.BookRepoManager;
import BookBasket.Repo.UserRepo;
import BookBasket.Repo.UserRepoManager;

public class RepoFactory {
		public static BookRepo getBookRepo() {
			return new BookRepoManager();
		}
		
		public static UserRepo getUserRepo() {
			return new UserRepoManager();
		}
}
