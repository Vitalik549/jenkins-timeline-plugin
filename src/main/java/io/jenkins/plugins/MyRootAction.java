package io.jenkins.plugins;

import hudson.Extension;
import hudson.model.Job;
import hudson.model.RootAction;
import hudson.model.Run;
import io.jenkins.plugins.data.TimelineData;
import io.jenkins.plugins.data.TimelineJob;
import io.jenkins.plugins.data.TimelineRun;
import jenkins.model.Jenkins;

import javax.annotation.CheckForNull;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Extension
public class MyRootAction implements RootAction {
    @CheckForNull
    @Override
    public String getIconFileName() {
        return "clipboard.png";
    }

    @CheckForNull
    @Override
    public String getDisplayName() {
        return "Timeline";
    }

    @CheckForNull
    @Override
    public String getUrlName() {
        return "timeline";
    }

    public List<TimelineRun> getRuns(Job job) {
        List<Run> runs = job.getBuilds();
        return runs
                .stream()
                .map(run -> {
                    TimelineRun timelineRun = new TimelineRun();
                    timelineRun.duration = run.getDuration();
                    timelineRun.startTime = run.getStartTimeInMillis();
                    timelineRun.result = run.getResult() == null ? "Unknown" : run.getResult().toString();
                    timelineRun.number = run.getNumber();
                    return timelineRun;
                })
                .collect(toList());
    }

    public TimelineJob toTimelineJob(Job job) {
        TimelineJob timelineJob = new TimelineJob();
        timelineJob.name = job.getName();
        timelineJob.runs = getRuns(job);
        System.out.println(timelineJob);
        return timelineJob;
    }

    public TimelineData getTimelineData() {
        TimelineData timelineData = new TimelineData();

        timelineData.jobs = Jenkins.get().getAllItems(Job.class)
                .stream()
                .map(this::toTimelineJob)
                .collect(toList());
        return timelineData;
    }
}
