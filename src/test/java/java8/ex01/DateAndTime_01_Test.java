package java8.ex01;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Exercice 01 - Les dates avant Java 8
 */
public class DateAndTime_01_Test {

    // Vous vous souvenez de java.util.Date (Java 1) ?
    @Test
    public void test_date() {

        // Modifier les paramètres pour que le test soit passant
        Date date = new Date(117, 2, 24, 1, 2, 3);
        assertThat(date.toString(), is("Fri Mar 24 01:02:03 CET 2017"));

        // une date est mutable... :-(
        // Modifier le jour de la date pour que le test soit passant
        date.setDate(25);
        assertThat(date.toString(), is("Sat Mar 25 01:02:03 CET 2017"));
    }

    // Vous vous souvenez de java.util.Calendar (Java 1.1) ?

    @Test
    public void test_calendar() throws Exception {
        Calendar calendar = Calendar.getInstance();

        // Modifier l'objet calendar pour que le test soit passant
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 2);
        calendar.set(Calendar.DAY_OF_MONTH, 24);
        calendar.set(Calendar.HOUR_OF_DAY, 1);
        calendar.set(Calendar.MINUTE, 2);
        calendar.set(Calendar.SECOND, 3);        
        assertThat(calendar.getTime().toString(), is("Fri Mar 24 01:02:03 CET 2017"));

        // calendar est mutable... :-(
        // Modifier l'objet calendar pour que le test soit passant
        // calendar.set(Calendar.DAY_OF_MONTH, 25);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        assertThat(calendar.getTime().toString(), is("Sat Mar 25 01:02:03 CET 2017"));
    }


}