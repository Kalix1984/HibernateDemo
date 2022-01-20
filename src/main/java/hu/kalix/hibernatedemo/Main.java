package hu.kalix.hibernatedemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import hu.kalix.hibernatedemo.entity.Authority;
import hu.kalix.hibernatedemo.entity.Role;
import hu.kalix.hibernatedemo.entity.User;

public class Main {
	public static EntityManagerFactory sessionFactory = null;

	public static void main(String[] args) throws Exception {
		setUp();
		save();
		getAll();

	}

	protected static void setUp() throws Exception {
		final Map<String, String> params = new HashMap<>();
		params.put("hibernate.connection.driver_class", "org.postgresql.Driver");
		params.put("hibernate.connection.url", "jdbc:postgresql://domain:port/database");
		params.put("hibernate.connection.username", "(user)");
		params.put("hibernate.connection.password", "(password)");
		params.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
	
		sessionFactory = Persistence.createEntityManagerFactory("jpa", params);
	}

	public static void save() {
		EntityManager entityManager = sessionFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Authority create_user_profile = new Authority("create_user_profile");
		Authority read_user_profile= new Authority("read_user_profile");
		Authority update_user_passwordreset = new Authority("update_user_passwordreset");
		Authority update_user_name = new Authority("update_user_name");
		
		entityManager.persist(create_user_profile);
		entityManager.persist(read_user_profile);
		entityManager.persist(update_user_passwordreset);
		entityManager.persist(update_user_name);
		
		Role role1 = new Role();
		role1.setRoleName("Superuser");
		role1.setAuthorities(Arrays.asList(create_user_profile, read_user_profile, update_user_passwordreset, update_user_name));
		Role role2 = new Role();
		role2.setRoleName("Admin");
		role2.setAuthorities(Arrays.asList(create_user_profile, read_user_profile));
		Role role3 = new Role();
		role3.setRoleName("Logger");
		role3.setAuthorities(Arrays.asList(read_user_profile));
		
		entityManager.persist(role1);
		entityManager.persist(role2);
		entityManager.persist(role3);
		
		User user1 = new User();
		user1.setLoginName("admin1");
		user1.setPassword("password");
		user1.setFirstName("István");
		user1.setLastName("Horváth");
		user1.setRole(role1);
		
		User user2 = new User();
		user2.setLoginName("admin2");
		user2.setPassword("password");
		user2.setFirstName("Jenő");
		user2.setLastName("Kiss");
		user2.setRole(role1);
		
		entityManager.persist(user1);
		entityManager.persist(user2);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public static void getAll() {
		EntityManager entityManager = sessionFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<User> result = entityManager.createQuery("from User", User.class).getResultList();
		for (User role : result) {
			System.out.println(role);
		}
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
