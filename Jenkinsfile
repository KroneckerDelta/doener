#!/usr/bin/env groovy
//@Library('god-jenkins-lib@god-jenkins-lib-1.3.3') _
@Library('god-jenkins-lib@nextgen') _
godJavaPipeline {
    artifactTypes = ['jar']
    publishDockerImages = true
    globalTimeout = 60
    jdkVersion = '1.8'
    mailRecipients = ['thomas.michael@god.de', 'maik.goedecke@god.de', 'nils.hoffmann@god.de']
    projectName = 'doenerapp' // naming convention for tags / branches
    //gav should be de.god.codecamp.doener
    metricFoundingFailedCount = '1217' // threshold for metrics to fail a build
    metricFoundingUnstableCount = '1115' // threshold for metrics to mark a build unstable
    additionalMvnOpts = '-Dmaven.deploy.skip=true'
    testbed_rampup_timeout = 180 // in seconds
    publish_to_daily_sys = true  
}
