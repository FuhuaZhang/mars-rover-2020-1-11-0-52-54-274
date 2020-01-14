package com.thoughtworks.marsrover;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {
    MarsRover marsRover = new MarsRover();
    @Test
    void should_return_the_init_position_and_direction_info_given_only_init_order() {
        MarsRoverPos marsRoverPos = new MarsRoverPos(1, 1, MarsRoverPos.MarsRoverDirection.N);
        MarsRoverPos newMarsRoverPos = marsRover.explore(marsRoverPos, new MoveOrTurn[]{});
        assertEquals(marsRoverPos, newMarsRoverPos);
    }

    @Test
    void should_return_the_position_after_move() {
        MarsRoverPos marsRoverPos = new MarsRoverPos(1, 1, MarsRoverPos.MarsRoverDirection.N);
        MoveOrTurn[] moveOrTurns = {MoveOrTurn.M};
        MarsRoverPos newMarsRoverPos = marsRover.explore(marsRoverPos, moveOrTurns);
        MarsRoverPos expect = new MarsRoverPos(1, 2, MarsRoverPos.MarsRoverDirection.N);
        assertSame(expect, newMarsRoverPos);
    }
}
