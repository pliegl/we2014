package model;

import org.joda.time.DateTime;
import org.junit.Test;
import play.db.jpa.JPA;
import play.libs.F;
import service.PersistenceService;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for the persitence service
 */
public class PersistenceTest extends BaseTest {

    final PersistenceService persistence = PersistenceService.INSTANCE;

    @Test
    public void testStoreAndRetrieveStudents() {

        JPA.withTransaction(new F.Callback0() {
            @Override
            public void invoke() throws Throwable {

                Student student = new Student();
                student.setName("Max Mustermann");
                student.setRegistrationNumber("0123565");
                student.setLoginTime(new DateTime(2014, 12, 12, 14, 00, 00));

                //Save the student
                persistence.persist(student);

                //Get a list of all students
                List<Student> students = persistence.findEntity(Student.class);
                //Expecting values to be correctly persisted
                assertTrue(students.size() == 1);
                student = students.get(0);
                assertEquals("0123565", student.getRegistrationNumber());
            }
        });


        try  {
            JPA.withTransaction(new F.Callback0() {
                @Override
                public void invoke() throws Throwable {

                    Student student = persistence.getStudent("0123565");

                    //Assign a scholarship to the student
                    Scholarship scholarship = new Scholarship();
                    scholarship.setAmount(1000);
                    scholarship.setDescription("Scholarship A");
                    scholarship.setGrantedTo(student);

                    //Assign it to the student and try to persist it
                    student.setScholarship(scholarship);

                    student = persistence.merge(student);

                    //The student must have the scholarship assigned
                    assertEquals("Scholarship A", student.getScholarship().getDescription());

                    student.setScholarship(null);
                    student = persistence.merge(student);

                    assertNull(student.getScholarship());

                }
            });

        }
        catch (Exception e) {
           fail();
        }









    }


}
