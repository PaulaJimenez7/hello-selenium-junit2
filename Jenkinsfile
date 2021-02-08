#!/usr/bin/env groovy
pipeline {
    agent any
    
    options {
        ansiColor('xterm')
    }

    stages { 
        stage('build') {
            steps {
                withGradle{
                    sh './gradlew assemble'
                }              
            }
        }
        stage('test') {
            steps {
                withGradle{
                    sh './gradlew clean test'
                    sh './gradlew check'
                }              
            }
            post{
                always{
                    junit 'build/test-results/test/TEST-*.xml'
                    recordIssues(
                        enabledForFailure: true,
                        tool: checkStyle(pattern:'build/reports/checkstyle/*.xml')
                    )
                }
            }
        }
    }
}
