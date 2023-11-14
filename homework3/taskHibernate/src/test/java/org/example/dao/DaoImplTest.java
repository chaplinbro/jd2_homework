package org.example.dao;

import junit.framework.TestCase;
import org.example.dao.data.TestConfig;
import org.example.dao.data.TestSessionFactory;
import org.example.pojo.Person;
import org.junit.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoImplTest extends TestCase {

    private static Dao dao;

    @Before
    public void setUp() throws Exception {
        dao = new DaoImpl(TestSessionFactory.getSessionFactory());
        Connection conn = TestConfig.connection();
        conn.createStatement().executeUpdate("DELETE FROM T_PERSON");
    }

    @After
    public void tearDown() throws Exception {
        dao = null;
        Connection conn = TestConfig.connection();
//        conn.createStatement().executeUpdate("DELETE FROM T_PERSON");
    }

    @Test
    public void testSavePerson() throws SQLException, ClassNotFoundException {

        //Given
        Person person = new Person(null, "Jaha", "Tamoa", 5559789);
        //when
        Long testPerson = dao.savePerson(person);
        //then
        assertNotNull(testPerson);
        Connection conn = TestConfig.connection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_PERSON where name = 'Jaha'");
        rs.next();
        long actualId = rs.getLong(1);
        Assert.assertEquals(1, actualId);

    }

    @Test
    public void testDeletePerson() throws SQLException, ClassNotFoundException {
        //Given
        Connection conn = TestConfig.connection();
        long testId = 1;
        conn.createStatement().executeUpdate(
                "insert into T_PERSON values ('" + testId + "', 'Tarik', '5556677', 'Delete')");
        //When
        boolean del = dao.deletePerson(testId);
        //Then
        assertTrue(del);
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_PERSON where id = '" + testId + "';");
        rs.next();
        long actualId = rs.getLong(1);
        assertEquals(0, actualId);
        conn.close();
    }

    @Test
    public void testFindPerson() throws SQLException, ClassNotFoundException {
        //Given
        Connection conn = TestConfig.connection();
        long testId = 12;
        conn.createStatement().executeUpdate(
                "insert into T_PERSON values ('11', 'Pasha', 5225232, 'Finder')," +
                        " ('12', 'Gosha', 5322332, 'Finder')," +
                        " ('13', 'Dasha', 8979898, 'Finder');"
        );
        //when
        Person person = dao.findPerson(testId);
        //then
        assertNotNull(person);
        assertNotNull(String.valueOf(testId), person.getId());
        assertEquals("Gosha", person.getName());
        assertEquals("Finder", person.getSurname());
        assertEquals(5322332, person.getNumber());
    }

    @Test
    public void testGetPerson() {
    }

    @Test
    public void testLoadPerson() {
    }

    @Test
    public void testUpdatePerson() {
    }
}