package com.example.gerryeka.aplikasiscoreboard1.Model;

/**
 * Created by gerry eka on 10/23/2019.
 */

public class Model_history {
    String id,nama1,nama2,set_score,set_score1,set_score2;

    public Model_history() {
    }

    public Model_history(String id, String nama1, String nama2, String set_score, String set_score1, String set_score2) {
        this.id = id;
        this.nama1 = nama1;
        this.nama2 = nama2;
        this.set_score = set_score;
        this.set_score1 = set_score1;
        this.set_score2 = set_score2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama1() {
        return nama1;
    }

    public void setNama1(String nama1) {
        this.nama1 = nama1;
    }

    public String getNama2() {
        return nama2;
    }

    public void setNama2(String nama2) {
        this.nama2 = nama2;
    }

    public String getSet_score() {
        return set_score;
    }

    public void setSet_score(String set_score) {
        this.set_score = set_score;
    }

    public String getSet_score1() {
        return set_score1;
    }

    public void setSet_score1(String set_score1) {
        this.set_score1 = set_score1;
    }

    public String getSet_score2() {
        return set_score2;
    }

    public void setSet_score2(String set_score2) {
        this.set_score2 = set_score2;
    }
}
