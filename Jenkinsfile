node {
    stage('Clone code') {
        git 'https://github.com/manasworks/VyTrack_Cucumber_BDD.git'
    }

    stage('Run tests'){
        if(isUnix()){
            sh "mvn clean test"
        } else {
            bat "mvn clean test"
        }
    }

    stage('Generate report'){
           cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
    }

    post {
            changed {
                script {
                    if (currentBuild.currentResult == 'FAILURE') { // Other values: SUCCESS, UNSTABLE
                        // Send an email only if the build status has changed from green/unstable to red
                        emailext subject: '$DEFAULT_SUBJECT',
                            body: '$DEFAULT_CONTENT',
                            recipientProviders: [
                                [$class: 'CulpritsRecipientProvider'],
                                [$class: 'DevelopersRecipientProvider'],
                                [$class: 'RequesterRecipientProvider']
                            ],
                            replyTo: '$DEFAULT_REPLYTO',
                            to: '$DEFAULT_RECIPIENTS'
                    }
                }
            }
        }
    }
}