package BookBasket.Repo;

import java.util.List;
import javax.persistence.EntityManager;

import BookBasket.model.Book;
import BookBasket.model.Book.Status;
import BookBasket.model.User;
import BookBasket.utils.SessionFactory;

public class BookRepoManager implements BookRepo {
	
	private static org.hibernate.SessionFactory sessionFactory;
	private EntityManager session;

	public BookRepoManager() {
		sessionFactory = SessionFactory.getInstance();
	}
	
	@Override
	public List<Book> getByKeyword(String keyword) {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<Book> result=session.createNamedQuery("findByKeyword",Book.class).setParameter("keyword","%"+keyword+"%").getResultList();
		System.out.println(result);
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		return result;
	}


	@Override
	public Boolean add(Book b) {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		session.persist(b);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return true;
	}

	@Override
	public Boolean edit(int id,Book b) {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		Book b1=session.find(Book.class, id);
		System.out.println(b1);

		b1.setTitle(b.getTitle());
		b1.setAuthor(b.getAuthor());
		b1.setCategory(b.getCategory());
		b1.setDescription(b.getDescription());
		b1.setPrice(b.getPrice());	
		b1.setType(b.getType());
		b1.setDelivery(b.getDelivery());

		session.getTransaction().commit();
		return true;
	}

	@Override
	public Book findById(int id) {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		Book book = session.find(Book.class, id);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return book;
	}

	@Override
	public List<Book> allBooks() {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<Book> result = session.createQuery("from Book", Book.class).getResultList();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		System.out.println(result.size());
		return result;
	}

	@Override
	public List<Book> getByType(String type) {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<Book> result=session.createNamedQuery("findBytype",Book.class).setParameter("type",type).getResultList();
		System.out.println(result);
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		return result;
	}


	@Override
	public Boolean delete(int id) {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		Book book = session.find(Book.class, id);
		session.remove(book);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return true;
	}

	@Override
	public List<Book> getByCategory(String category) {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<Book> result=session.createNamedQuery("findByCategory",Book.class)
				.setParameter("category",category).getResultList();
		return result;
	}

	@Override
	public List<Book> getByAuthor(String author) {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<Book> result=session.createNamedQuery("findByAuthor",Book.class)
				.setParameter("author", author).getResultList();
		return result;
	}

	@Override 
	public Boolean approveBook(int id) {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		Book book = session.find(Book.class, id);
		book.setStatus(Status.AVAILABLE);
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		return true;
	}

	@Override
	public Boolean bookBook(Book book) {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		Book dbBook = session.find(Book.class, book.getId());
		dbBook.setStatus(Status.BOOKED);
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		return true;
	}

	@Override
	public List<Book> availableBooks(String ab) {
		List<Book> result=null;
		try {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		result= session.createNamedQuery("findByStatus",Book.class)
				.setParameter("status",Status.valueOf(ab))
				.getResultList();
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		
		}catch(Exception e) {
			System.out.println("exception....");
			e.printStackTrace();
			e.fillInStackTrace();
		}
		return result;
	}

	
	@Override
	public int getcountBooks() {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<Book> result = session.createQuery("from Book", Book.class).getResultList();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		int all=result.size();
		return all;
	}

	@Override
	public List<Book> getUserBook(int id) {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		User user = new User();
		user.setId(id);
		List<Book> result = session.createNamedQuery("findByUser",Book.class).setParameter("user",user).getResultList();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return result;
	}

	@Override
	public List<Book> findOtherBooks(User user) {
		String av="AVAILABLE";
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		try{
			List<Book> result = session.createNamedQuery("findOtherBook",Book.class)
				.setParameter("status",Status.valueOf(av))
				.setParameter("user",user).getResultList();
		session.getTransaction().commit();
		System.out.println(result);
		return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (session.isOpen()) {
			session.close();
		}
		return null;
	}
	
	
	

}
