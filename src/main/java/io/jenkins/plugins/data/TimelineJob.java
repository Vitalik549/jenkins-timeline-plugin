package io.jenkins.plugins.data;

import java.util.ArrayList;
import java.util.List;

public class TimelineJob {

    public List<TimelineRun> runs = new ArrayList<>();
    public String name;

    public TimelineJob() {
    }

    public TimelineJob(List<TimelineRun> runs, String name) {
        this.runs = runs;
        this.name = name;
    }

    public List<TimelineRun> getRuns() {
        return runs;
    }

    public TimelineJob setRuns(List<TimelineRun> runs) {
        this.runs = runs;
        return this;
    }

    public String getName() {
        return name;
    }

    public TimelineJob setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "TimelineJob{" +
                "runs=" + runs +
                ", name='" + name + '\'' +
                '}';
    }
}
