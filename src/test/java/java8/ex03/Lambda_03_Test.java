package java8.ex03;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 03 - ForEach
 */
public class Lambda_03_Test {

	// tag::PersonProcessor[]
	interface PersonProcessor {
		void process(Person p);
	}
	// end::PersonProcessor[]

	// tag::forEach[]
	private void forEach(List<Person> source, PersonProcessor processor) {
		for (Person person : source) {
			processor.process(person);
		}
	}
	// end::forEach[]

	// tag::test_verify_person[]
	@Test
	public void test_verify_person() throws Exception {

		List<Person> personList = Data.buildPersonList(100);

		// Verification ( via une assertion (mot clé assert) ) = prenom d'une personne commence par first
		PersonProcessor verifyPerson = person -> assertTrue(person.getFirstname().startsWith("first"));

		// Verification ( via une assertion (mot clé assert) )= nom d'une personne commence par last
		verifyPerson = person -> assertTrue(person.getLastname().startsWith("last"));

		// Verification ( via une assertion (mot clé assert) ) = age d'une personne > 0
		verifyPerson = person -> assertTrue(person.getAge() > 0);

		assert verifyPerson != null;

		forEach(personList, verifyPerson);
	}
	// end::test_verify_person[]

}
