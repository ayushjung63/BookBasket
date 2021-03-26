package BookBasket.Repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	public Boolean edit(int id,Book b) {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		Book b1=session.find(Book.class, id);
		
		b1.setId(id);
		b1.setTitle(b.getTitle());
		b1.setAuthor(b.getAuthor());
		b1.setCategory(b.getCategory());
		b1.setDescription(b.getDescription());
		b1.setPrice(b.getPrice());
		b1.setImage(b.getImage());
		/* b1.setStatus(b.getStatus()); */
		b1.setType(b.getType());

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
	public List<Book> getByType(String type) {
		session = sessionFactory.createEntityManager();
		session.getTransaction().begin();
		Query q=session.createNamedQuery("from Book where type=:type",Book.class);
		q.setParameter("type",type);
		List<Book> result=q.getResultList();
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

}
