package service;

import com.dh.proyect.DentalAppoiments.model.Dentist;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DentistServiceTest {
    DentistService dentistService = new DentistService(new DentistH2Dao());

    @Before
    public void resetDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'table.sql'", "sa", "");
        Statement statement = connection.createStatement();
        String truncate = "truncate table dentist";
        statement.execute(truncate);
    }

    //testing the method of listing dentists
  @Test
 public void getTheListOfLoadedDentists() {
      //Arrange
      List<Dentist> dentists = dentistService.list();
       //Assertions
     assertTrue(dentists.size() > 0);
  }
    @Test
    //testing the method of creating dentists
    public void creating_dentists() {
        DentistService dentistService = new DentistService(new DentistH2Dao());
        //Arrange
        Dentist d1 = new Dentist(1, 123344, "Carla", "Irizar");
        Dentist d2 = new Dentist(1, 123344, "Carla", "Irizar");
        Dentist d3 = new Dentist(1, 123344, "Carla", "Irizar");
        //Act
        dentistService.create(d1);
        dentistService.create(d2);
        dentistService.create(d3);
        //Assertions
        assertEquals(3, dentistService.list().size());
    }
}
    //Testing methods of modified dentist
//    @Test
//public void testing_modify_method_by_Id() {
//        //Arrange
//        //Act
//        //Assertions
//    }
//}

