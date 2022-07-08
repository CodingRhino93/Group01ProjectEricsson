package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@SpringBootTest
@Sql({"/populate_db.sql"})
public class NodeRepositoryTest {

    @Autowired
    private NodeRepository nodeRepository;

    @Test
    public void testFindAllNodes(){
        assertThat(nodeRepository.getNodes().size(), is(2));
    }

    @Test
    public void testForNodeName(){
        assertThat(nodeRepository.getNode(1).getName(), is("Test123"));
    }

}
