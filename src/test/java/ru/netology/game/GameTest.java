package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();

    Player player1 = new Player(1,"Ukon",15);
    Player player2 = new Player(2,"Nil",35);
    Player player3 = new Player(3,"Tigre",15);
    Player player4 = new Player(4,"",21);

    @Test
    void shouldFindAll(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        Player[] expected = new Player[]{player1,player2,player3};
        Player[] actual = game.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRoundResultZero(){
        game.register(player1);
        game.register(player3);
        assertEquals(0,game.round(player1, player3));
    }

    @Test
    void shouldRoundResultOne(){
        game.register(player4);
        game.register(player3);
        assertEquals(1,game.round(player4, player3));
    }

    @Test
    void shouldRoundResultTwo(){
        game.register(player1);
        game.register(player2);
        assertEquals(2,game.round(player1, player2));
    }

    @Test
    void shouldCatchExceptionOneNotRegistered(){
       game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round(player1, player4));
    }

    @Test
    void shouldCatchExceptionTwoNotRegistered(){
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round(player1, player4));
    }
}