package io.jenkins.plugins.data;

public class TimelineRun {
    public TimelineRun() {
    }

    public TimelineRun(long startTime, long duration, String result, int number) {
        this.startTime = startTime;
        this.duration = duration;
        this.result = result;
        this.number = number;
    }

    public long startTime;
    public long duration;
    public String result;
    public int number;

    public long getStartTime() {
        return startTime;
    }

    public TimelineRun setStartTime(long startTime) {
        this.startTime = startTime;
        return this;
    }

    public long getDuration() {
        return duration;
    }

    public TimelineRun setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    public String getResult() {
        return result;
    }

    public TimelineRun setResult(String result) {
        this.result = result;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public TimelineRun setNumber(int number) {
        this.number = number;
        return this;
    }
}
