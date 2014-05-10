package model;

import org.junit.After;
import org.junit.Before;
import play.db.jpa.JPA;
import play.db.jpa.JPAPlugin;
import play.test.FakeApplication;
import scala.Option;

import javax.persistence.EntityManager;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.start;

/**
 * Created by pl on 10.05.14.
 */
public abstract class BaseTest {


    private EntityManager em;

    /**
     * Setup the test
     */
    @Before
    public void setupTest() {
        FakeApplication app = fakeApplication();
        start(app);
        em = app.getWrappedApplication().plugin(JPAPlugin.class).get().em("default");
        JPA.bindForCurrentThread(em);
    }

    @After
    public void tearDownIntegrationTest() {
        JPA.bindForCurrentThread(null);
        em.close();
    }




}
