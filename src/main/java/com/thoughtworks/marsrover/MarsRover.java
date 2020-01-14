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
        N, E, S, W,
    }
}

enum MoveOrTurn {
    M, L, R,
}

public class MarsRover {

    public MarsRoverPos explore(MarsRoverPos marsRoverPos, MoveOrTurn[] moveOrTurns) {
        MarsRoverPos result = marsRoverPos;
        for (MoveOrTurn moveOrTurn : moveOrTurns) {
            switch (moveOrTurn) {
                case M:
                    result = handleMove(marsRoverPos);
                    break;
                case R:
                    result = handleTurnR(marsRoverPos);
                    break;
                case L:
                    result = handleTurnL(marsRoverPos);
                    break;
            }
        }
        return result;
    }

    MarsRoverPos handleMove(MarsRoverPos marsRoverPos){
        switch (marsRoverPos.direction){
            case N:
                marsRoverPos.y += 1;
                break;
            case S:
                marsRoverPos.y -= 1;
                break;
            case E:
                marsRoverPos.x += 1;
                break;
            case W:
                marsRoverPos.x -= 1;
                break;
        }
        return marsRoverPos;
    }

    MarsRoverPos handleTurnR(MarsRoverPos marsRoverPos){
        marsRoverPos.direction
                = MarsRoverPos.MarsRoverDirection.values()[(marsRoverPos.direction.ordinal() + 1) % 4];
        return marsRoverPos;
    }

    MarsRoverPos handleTurnL(MarsRoverPos marsRoverPos){
        marsRoverPos.direction
                = MarsRoverPos.MarsRoverDirection.values()[(marsRoverPos.direction.ordinal() + 3) % 4];
        return marsRoverPos;
    }
}
