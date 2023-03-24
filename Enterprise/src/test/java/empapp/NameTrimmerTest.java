package empapp;

import junit.framework.TestCase;

public class NameTrimmerTest extends TestCase {

    public void testTrimmer(){
        assertEquals("John Doe", new NameTrimmer().trimName("   John Doe    "));
    }

}