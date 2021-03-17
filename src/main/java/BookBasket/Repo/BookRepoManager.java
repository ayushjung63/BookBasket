package BookBasket.Repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.annotations.Where;

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
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		session.find(Book.class, id);
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

		Query query = session.createQuery("from Book as book where book.Available= :condition",Book.class);
		query.setParameter("condition", "true");
		List<Book> available =query.getResultList();

		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		System.out.println(available);
		return available;
	}

	@Override
	public List<Book> findByPending() {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		List<Book> pending=(List<Book>) session.createQuery("from Book where Available=false",Book.class).getResultList();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return pending;
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

}
