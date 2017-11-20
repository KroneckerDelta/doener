#!/usr/bin/env groovy
//@Library('god-jenkins-lib@god-jenkins-lib-1.3.3') _
@Library('god-jenkins-lib@develop') _
godJavaPipeline {
    artifactTypes = ['war']
    globalTimeout = 60
    jdkVendor = 'oracle'
    jdkVersion = '1.8'
    mvnVersion = '3'
    mailRecipients = ['']
    projectName = 'doenerapp' // naming convention for tags / branches
    //gav should be de.god.codecamp.doener
    metricFoundingFailedCount = '25' // threshold for metrics to fail a build
    metricFoundingUnstableCount = '15' // threshold for metrics to mark a build unstable
    additionalMvnOpts = ''
    testbed_rampup_timeout = 1800 // in seconds
}
