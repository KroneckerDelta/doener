#!/usr/bin/env groovy
//@Library('god-jenkins-lib@god-jenkins-lib-1.3.3') _
@Library('god-jenkins-lib@for-god-jenkins-lib-consumer') _
godJavaPipeline {
    artifactTypes = ['war']
    globalTimeout = 60
    jdkVendor = 'oracle'
    jdkVersion = '1.8'
    mvnVersion = '3'
    mailRecipients = ['thomas.michael@god.de']
    projectName = 'doenerapp' // naming convention for tags / branches
    //gav should be de.god.codecamp.doener
    metricFoundingFailedCount = '1217' // threshold for metrics to fail a build
    metricFoundingUnstableCount = '1115' // threshold for metrics to mark a build unstable
    additionalMvnOpts = '-Dmaven.deploy.skip=true'
    testbed_rampup_timeout = 180 // in seconds
}
