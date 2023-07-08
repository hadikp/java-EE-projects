package org.example.itext;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItextTest {

    @Test
    void test(){
        Itext itext = new Itext();
        itext.createPdf();
    }

}