package sse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class GameControllerTest {

    GameController ctl;

    @Before
    public void setUp() throws Exception {
        ctl=new GameController();
    }

    @After
    public void tearDown() throws Exception {
        ctl=null;
    }
}