package java8.ex03;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 03 - Méthode statique
 */
public class Method_03_Test {

	interface IDao {
		List<Person> findAll();

		// Methode statique IDao getDefaultInstance() qui retourne une instance de la classe DaoA
		static IDao getDefaultInstance() {
			Method_03_Test mm = new Method_03_Test();
			return mm.new DaoA();
		}
	}

	class DaoA implements IDao {
		List<Person> people = Data.buildPersonList(20);

		@Override
		public List<Person> findAll() {
			return people;
		}
	}

	@Test
	public void test_getDefaultInstance() throws Exception {
		IDao result = IDao.getDefaultInstance();

		assert result.findAll().size() == 20;
	}
}