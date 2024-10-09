package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // <https://bit.ly/cs156-f24-teams>
        assertEquals("Logan", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        // <https://bit.ly/cs156-f24-teams>
        assertEquals("lodetrick", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("f24-07", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Kanav"),"Team should contain Kanav");
        assertTrue(t.getMembers().contains("Divya"),"Team should contain Divya");
        assertTrue(t.getMembers().contains("Eugene W"),"Team should contain Eugene W");
        assertTrue(t.getMembers().contains("Logan"),"Team should contain Logan");
        assertTrue(t.getMembers().contains("Noah"),"Team should contain Noah");
        assertTrue(t.getMembers().contains("Ramon"),"Team should contain Ramon");
    }
}
