package java8.ex02;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test  {	
// public class Lambda_02_Test <T> {
// soit <T> List<T>, soit Lambda_02_Test <T> - premier <T> precise a Java que cette methode / class manipule des generiques
	
	interface PersonMapper<T> {
		T map(Person p);
	}
	
	// Transforme une liste de personnes en liste de accounts / firstnames
	private <T> List<T> map(List<Person> personList, PersonMapper<T> mapper) {
		List<T> accounts = new ArrayList<>();
		for (Person person : personList) {
			accounts.add(mapper.map(person));
		}
		return accounts;
	}

	@Test
	public void test_map_person_to_account() throws Exception {
		List<Person> personList = Data.buildPersonList(100);

		// Transforme la liste de personnes en liste de accounts, dont tous les accounts ont un solde à 100 par défaut
		List<Account> result = map(personList, person -> new Account(person, new Integer(100)));

		assert result.size() == personList.size();
		for (Account account : result) {
			assert account.getBalance().equals(100);
			assert account.getOwner() != null;
		}
	}

	@Test
	public void test_map_person_to_firstname() throws Exception {

		List<Person> personList = Data.buildPersonList(100);

		// Transforme la liste de personnes en liste de prénoms
		List<String> result = map(personList, person -> person.getFirstname());

		assert result.size() == personList.size();
		for (String firstname : result) {
			assert firstname.startsWith("first");
		}
	}
}
