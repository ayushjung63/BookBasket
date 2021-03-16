package BookBasket.Repo;

import java.util.List;
import javax.persistence.EntityManager;

import com.mysql.cj.Query;

import BookBasket.model.Book;
import BookBasket.utils.SessionFactory;

public class BookRepoManager implements BookRepo {
	private static org.hibernate.SessionFactory sessionFactory;
	private EntityManager session;

	public BookRepoManager() {
		sessionFactory = SessionFactory.getInstance();
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
	public Boolean edit(int id) {
		  session=sessionFactory.createEntityManager();
		  session.getTransaction().begin();
		  session.find(Book.class,id);
		  session.remove(session);
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
		return result;
	}

	@Override
	public List<Book> findByAvailable() {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		System.out.println("test");
		javax.persistence.Query q=session.createNativeQuery("from Book where available=:condition");
		q.setParameter("condition","true");
		List<Book> available=q.getResultList();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return available;
	}

	@Override
	public List<Book> findByPending() {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<Book> pending = session.createQuery("from Book where accepted="+"false", Book.class).getResultList();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return pending;
	}

	@Override
	public Boolean delete(int id) {
		session=sessionFactory.createEntityManager();
		session.getTransaction().begin();
		Book book=session.find(Book.class,id);
		System.out.println(book);
		session.remove(book);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return true;
	}

}
