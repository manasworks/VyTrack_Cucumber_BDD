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

agent any
     stages {
         stage('Test') {
             steps {
                 sh 'echo "Fail!"; exit 1'
             }
         }
     }
     post {
         always {
             echo 'This will always run'
         }
         success {
             echo 'This will run only if successful'
         }
         failure {
             mail bcc: '', body: "<b>Example</b><br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL}", cc: '', charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "ERROR CI: Project name -> ${env.JOB_NAME}", to: "manasworks@gmail.com";
         }
         unstable {
             echo 'This will run only if the run was marked as unstable'
         }
         changed {
             echo 'This will run only if the state of the Pipeline has changed'
             echo 'For example, if the Pipeline was previously failing but is now successful'
         }
     }
}