package com.example.gerryeka.aplikasiscoreboard1.Model;

/**
 * Created by gerry eka on 10/10/2019.
 */

public class Model_live {
    String id,nama1,nama2,set_score1,set_score2,score1,score2;

    public Model_live(String id, String nama1, String nama2, String set_score1, String set_score2, String score1, String score2) {
        this.id = id;
        this.nama1 = nama1;
        this.nama2 = nama2;
        this.set_score1 = set_score1;
        this.set_score2 = set_score2;
        this.score1=score1;
        this.score2=score2;
    }

    public String getId() {
        return id;
    }

    public String getNama1() {
        return nama1;
    }

    public String getNama2() {
        return nama2;
    }

    public String getSet_score1() {
        return set_score1;
    }

    public String getSet_score2() {
        return set_score2;
    }

    public String getScore1() {
        return score1;
    }

    public String getScore2() {
        return score2;
    }
}
