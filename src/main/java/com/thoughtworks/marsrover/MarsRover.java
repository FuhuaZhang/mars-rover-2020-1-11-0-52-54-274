package com.thoughtworks.marsrover;

class MarsRoverPos {
    int x;
    int y;
    MarsRoverDirection direction;

    public MarsRoverPos(int x, int y, MarsRoverDirection direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    enum MarsRoverDirection {
        N, S, W, E,
    }
}

public class MarsRover {

    public MarsRoverPos explore(MarsRoverPos marsRoverPos) {
        return marsRoverPos;
    }
}
