package ru.netology.game;

import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.Collection;

public class Game {
    private Collection<Player> players = new ArrayList<Player>();

    public Player[] findAll() {
        return players.toArray(new Player[0]);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

    public boolean register(Player player) {
        if (findByName(player.getName()) != null) return false;
        else {
            players.add(player);
            return true;
        }
    }

    public int round(Player playerName1, Player playerName2) {
        Player player1 = findByName(playerName1.getName());
        Player player2 = findByName(playerName2.getName());
        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("One of the players is not registered");
        } else {
            if (player1.getStrength() == player2.getStrength()) return 0;
            return player1.getStrength() > player2.getStrength() ? 1 : 2;
        }
    }
}
