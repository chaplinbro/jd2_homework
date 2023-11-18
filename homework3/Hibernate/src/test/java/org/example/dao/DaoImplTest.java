package org.example.dao;

import junit.framework.TestCase;
import org.example.dao.data.TestConfig;
import org.example.dao.data.TestSessionFactory;
import org.example.pojo.Person;
import org.junit.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DaoImplTest extends TestCase {

    private static Dao dao;
    Connection conn;

    @Before
    public void setUp() throws Exception {
        dao = new DaoImpl(TestSessionFactory.getSessionFactory());
        conn = TestConfig.connection();
        conn.createStatement().executeUpdate("DELETE FROM T_PERSON");
    }

    @After
    public void tearDown() throws Exception {
        dao = null;
        conn = TestConfig.connection();
//        conn.createStatement().executeUpdate("DELETE FROM T_PERSON");
        conn.close();
    }

    @Test
    public void testSavePerson() throws SQLException, ClassNotFoundException {

        //Given
        Person person = new Person(null, "Jaha", "Tamoa", 5559789);
        //when
        Long testPerson = dao.savePerson(person);
        //then
        assertNotNull(testPerson);
        conn = TestConfig.connection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_PERSON where name = 'Jaha'");
        rs.next();
        long actualId = rs.getLong(1);
        Assert.assertEquals(1, actualId);
        conn.close();
    }

    @Test
    public void testDeletePerson() throws SQLException, ClassNotFoundException {
        //Given
        conn = TestConfig.connection();
        long testId = 1;
        conn.createStatement().executeUpdate(
                "insert into T_PERSON values ('" + testId + "', 'Tarik', '5556677', 'Mr.Delete')");
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
        conn = TestConfig.connection();
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
        assertEquals("Gosha", person.getName());
        assertEquals("Finder", person.getSurname());
        assertEquals(5322332, person.getNumber());
        conn.close();
    }

    @Test
    public void testGetPerson() throws SQLException, ClassNotFoundException {
        //Given
        conn = TestConfig.connection();
        long testId = 21;
        conn.createStatement().executeUpdate(
                "insert into T_PERSON values ('" + testId + "', 'Tarik', '5556677', 'Mr.Get')");

        //when
        Person person = dao.getPerson(testId);
        //then
        assertNotNull(person);
        assertEquals("Tarik", person.getName());
        assertEquals(5556677, person.getNumber());
        assertEquals("Mr.Get", person.getSurname());
        conn.close();
    }

    @Test
    public void testLoadPerson() throws SQLException, ClassNotFoundException {
        //Given
        long personId = prepareTestDataForLoad();
        //when
        Person loadPerson = dao.loadPerson(personId);
        //then
        conn = TestConfig.connection();
        conn.createStatement().executeQuery(
                "select * from T_PERSON where id = '" + personId + "';"
        );
        assertNotNull(loadPerson);
        conn.close();
    }

    public Long prepareTestDataForLoad() {
        long testId = 33;
        Person person = new Person(testId, "Clark", "Kent", 4336655);
        dao.savePerson(person);
        return person.getId();
    }

    @Test
    public void testUpdatePerson() throws SQLException, ClassNotFoundException {
        // Given
        // 1. save record via JDBC: insert into my_entity values();
        long testId = 11L;
        conn.createStatement().executeUpdate(
                "insert into T_PERSON values ('" + testId + "', 'Update', '5556677', 'Object')"
        );

        // When
        // 2. call DAO update method
        ResultSet rs1 = conn.createStatement().executeQuery(
                "select * from T_PERSON where id = '" + testId + "'"
        );
        rs1.next();
        long id = rs1.getLong(1);
        String name1 = rs1.getString(2);
        String surname1 = rs1.getString(4);
        int number = rs1.getInt(3);
        Person person = new Person(id, name1, surname1, number);
        person.setName("Nikita");
        person.setSurname("Super");
        dao.updatePerson(person);

        // Then
        // 3. read updated record: select * from my_entity;
        ResultSet rs2 = conn.createStatement().executeQuery(
                "select * from T_PERSON where id = '" + testId + "'"
        );
        rs2.next();
        String name2 = rs2.getString(2);
        String surName2 = rs2.getString(4);

        // 4. assert: check changed fields
        assertEquals("Nikita", name2);
        assertEquals("Super", surName2);

    }
}