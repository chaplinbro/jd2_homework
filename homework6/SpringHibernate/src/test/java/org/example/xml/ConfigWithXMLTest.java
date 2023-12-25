//package org.example.data;
//
//import junit.framework.TestCase;
//import org.example.ConfigWithXML;
//import org.example.TestConfig;
//import org.example.TestSessionFactory;
//import org.example.entity.User;
//import org.junit.After;
//import org.junit.Before;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class ConfigWithXMLTest extends TestCase {
//
//    @Autowired
//    ConfigWithXML configWithXML;
//    Connection conn;
//
//    @Before
//    public void setUp() throws Exception {
//        configWithXML = new ConfigWithXML(TestSessionFactory.getSessionFactory());
//        conn = TestConfig.connection();
//        conn.createStatement().executeUpdate("delete from user");
//    }
//    @After
//    public void tearDown() throws Exception {
//        configWithXML = null;
//        conn = TestConfig.connection();
////        conn.createStatement().executeUpdate("delete from user");
//        conn.close();
//    }
//
//    public void testSaveUser() throws SQLException, ClassNotFoundException {
//        User user = new User(1L, "testSave", 12);
//
//        configWithXML.saveUser(user);
//
//        conn = TestConfig.connection();
//        ResultSet rs = conn.createStatement().executeQuery(
//                "select count(*) from user where name = 'testSave'");
//        rs.next();
//        long count = rs.getLong(1);
//        assertEquals(1, count);
//        conn.close();
//    }
//
//    public void testGetUser() throws SQLException, ClassNotFoundException {
//        conn = TestConfig.connection();
//        long testId = 10;
//        conn.createStatement().executeUpdate(
//                "insert into user values ('" + testId + "', '34', 'testGet')");
//
//        User user = configWithXML.getUser(testId);
//
//        assertNotNull(user);
//        assertEquals("testGet", user.getName());
//        conn.close();
//    }
//
//    public void testDeleteUser() throws SQLException, ClassNotFoundException {
//
//        conn = TestConfig.connection();
//        long testId = 10;
//        conn.createStatement().executeUpdate(
//                "insert into user values ('" + testId + "', '23', 'testDelete')");
//
//        configWithXML.deleteUser(testId);
//
//        ResultSet rs = conn.createStatement().executeQuery(
//                "select count(*) from user where id = '" + testId + "';");
//        rs.next();
//        long actualId = rs.getLong(1);
//        assertEquals(0, actualId);
//        conn.close();
//    }
//}