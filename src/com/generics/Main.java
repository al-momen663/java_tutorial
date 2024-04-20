package com.generics;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
	    FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
//        adelaideCrows.addPlayer(pat);
//        adelaideCrows.addPlayer(beckham);

        System.out.println(adelaideCrows.numPlayers());
        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago cubs");
        baseballTeam.addPlayer(pat);
        Team<SoccerPlayer> brokenTeam = new Team<>("This wont work");
        brokenTeam.addPlayer(beckham);
        System.out.println(baseballTeam.numPlayers());

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);


        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2, 1);
//        adelaideCrows.matchResult(baseballTeam, 1, 1);

        System.out.println("Ranking: ");
        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());

        System.out.println(melbourne.getName() + ": " + fremantle.ranking());

        System.out.println(fremantle.getName() + ": " + fremantle.ranking());

        System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());

        System.out.println(adelaideCrows.compareTo(melbourne));
        System.out.println(adelaideCrows.compareTo(hawthorn));
        System.out.println(hawthorn.compareTo(adelaideCrows));
        System.out.println(melbourne.compareTo(fremantle));


        League<Team<FootballPlayer>> footballLeague = new League<>("AFL");
        footballLeague.add(adelaideCrows);
        footballLeague.add(melbourne);
        footballLeague.add(fremantle);
        footballLeague.add(hawthorn);

        footballLeague.showLeagueTable();

        Team rawTeam = new Team("Raw Team");
        rawTeam.addPlayer(beckham); // unchecked warning
        rawTeam.addPlayer(pat);     // unchecked warning

        footballLeague.add(rawTeam);     // unchecked warning

        League<Team> rawLeague = new League<>("Raw");
        rawLeague.add(adelaideCrows);     // no warning
        rawLeague.add(baseballTeam);    // no warning
        rawLeague.add(rawTeam);         // no warning

        League reallyRaw = new League("Really raw");
        reallyRaw.add(adelaideCrows);     // unchecked warning
        reallyRaw.add(baseballTeam);    // unchecked warning
        reallyRaw.add(rawTeam);         // unchecked warning

        rawLeague.showLeagueTable();
        reallyRaw.showLeagueTable();


    }
}
