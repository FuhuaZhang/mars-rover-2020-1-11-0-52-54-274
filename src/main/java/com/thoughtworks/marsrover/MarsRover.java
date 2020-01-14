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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarsRoverPos){
            MarsRoverPos marsRoverPos = (MarsRoverPos) obj;
            return this.x == marsRoverPos.x && this.y == marsRoverPos.y && this.direction == marsRoverPos.direction;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
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
                default:
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
        switch (marsRoverPos.direction){
            case N:
                marsRoverPos.direction = MarsRoverPos.MarsRoverDirection.E;
                break;
            case S:
                marsRoverPos.direction = MarsRoverPos.MarsRoverDirection.W;
                break;
            case E:
                marsRoverPos.direction = MarsRoverPos.MarsRoverDirection.S;
                break;
            case W:
                marsRoverPos.direction = MarsRoverPos.MarsRoverDirection.N;
                break;
        }
        return marsRoverPos;
    }

    MarsRoverPos handleTurnL(MarsRoverPos marsRoverPos){
        switch (marsRoverPos.direction){
            case N:
                marsRoverPos.direction = MarsRoverPos.MarsRoverDirection.W;
                break;
            case S:
                marsRoverPos.direction = MarsRoverPos.MarsRoverDirection.E;
                break;
            case E:
                marsRoverPos.direction = MarsRoverPos.MarsRoverDirection.N;
                break;
            case W:
                marsRoverPos.direction = MarsRoverPos.MarsRoverDirection.S;
                break;
        }
        return marsRoverPos;
    }
}
