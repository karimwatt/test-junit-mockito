package com.sesam.formation.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.fail;

/**
 * Created by Karim on 29/06/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class RuleTest {

   @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void Test() throws IOException {

        File file = new File(folder.getRoot(),"toto");

        file.createNewFile();

        if (!file.exists()) fail();

    }
}
