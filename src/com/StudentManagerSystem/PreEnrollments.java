
package com.StudentManagerSystem;

public class PreEnrollments {

    private int score = -1;
    private int studentUniID = -1;
    private int subjectID = -1;
    private int semester;
    private String proffesorName;
    private Status status = null;

    public enum Status {
        FAILED, ABSENCE_FAIL, PASSED, REMOVED
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {

        if (score <= 100 && score >= 0)
            this.score = score;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
