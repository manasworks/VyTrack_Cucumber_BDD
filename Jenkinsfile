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

    environment {
            EMAIL_TO = 'manasworks@gmail.com'
        }
    post {
            failure {
                emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}',
                        to: "${EMAIL_TO}",
                        subject: 'Build failed in Jenkins: $PROJECT_NAME - #$BUILD_NUMBER'
            }
            unstable {
                emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}',
                        to: "${EMAIL_TO}",
                        subject: 'Unstable build in Jenkins: $PROJECT_NAME - #$BUILD_NUMBER'
            }
            changed {
                emailext body: 'Check console output at $BUILD_URL to view the results.',
                        to: "${EMAIL_TO}",
                        subject: 'Jenkins build is back to normal: $PROJECT_NAME - #$BUILD_NUMBER'
            }
        }
    }
}