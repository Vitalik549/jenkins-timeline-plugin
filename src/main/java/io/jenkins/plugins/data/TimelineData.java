package io.jenkins.plugins.data;

import java.util.ArrayList;
import java.util.List;

public class TimelineData {

    public TimelineData() {
    }

    public List<TimelineJob> jobs = new ArrayList<>();

    public List<TimelineJob> getJobs() {
        return jobs;
    }

    public TimelineData setJobs(List<TimelineJob> jobs) {
        this.jobs = jobs;
        return this;
    }

    public TimelineData(List<TimelineJob> jobs) {
        this.jobs = jobs;
    }
}

