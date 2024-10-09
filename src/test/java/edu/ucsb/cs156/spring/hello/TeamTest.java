package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object_true() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_other_class_false() {
        int other_class = 1;
        assertEquals(false, team.equals(other_class));
    }

    @Test
    public void equals_different_name_false() {
        Team other = new Team("other-team");
        assertEquals(false, team.equals(other));
    }

    @Test
    public void equals_different_members_false() {
        team.addMember("Bob");
        Team other = new Team("test-team");
        other.addMember("Jean");
        assertEquals(false, team.equals(other));
    }
    
    @Test
    public void equals_true() {
        team.addMember("Jean");
        Team other = new Team("test-team");
        other.addMember("Jean");
        assertEquals(true, team.equals(other));
    }

    @Test
    public void hashCode_same_object_true() {
        assertEquals(true, team.hashCode() == team.hashCode());
    }

    @Test
    public void hashCode_other_class_false() {
        int other_class = 1;
        assertEquals(false, team.hashCode() == other_class);
    }

    @Test
    public void hashCode_different_name_false() {
        Team other = new Team("other-team");
        assertEquals(false, team.hashCode() == other.hashCode());
    }

    @Test
    public void hashCode_different_members_false() {
        team.addMember("Bob");
        Team other = new Team("test-team");
        other.addMember("Jean");
        assertEquals(false, team.hashCode() == other.hashCode());
    }
    
    @Test
    public void hashCode_true() {
        team.addMember("Jean");
        Team other = new Team("test-team");
        other.addMember("Jean");
        assertEquals(true, team.hashCode() == other.hashCode());
    }
}
