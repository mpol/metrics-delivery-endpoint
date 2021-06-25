pipeline {
    agent any

    triggers {
        cron("H H(20-23) * * 1-5")
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: "5"))
        timeout time: 60, unit: "MINUTES"
    }

    post {
        always {
            warnings canComputeNew: false, canResolveRelativePaths: false, categoriesPattern: '', consoleParsers: [[parserName: 'Maven'], [parserName: 'Java Compiler (javac)']], defaultEncoding: '', excludePattern: '', healthy: '', includePattern: '', messagesPattern: '', unHealthy: ''
            junit "**/target/surefire-reports/*.xml"
            jacoco()
            cleanWs()
        }

        failure {
            emailext (
                subject: "Build failed in Jenkins: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Failed job '${env.JOB_NAME}' #${env.BUILD_NUMBER}: check console output at ${env.BUILD_URL}.",
                recipientProviders:  [developers()]
            )
        }
    }
}
