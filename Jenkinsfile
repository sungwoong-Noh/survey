pipeline {
    agent any
    triggers {
        githubPush()
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/sungwoong-Noh/survey.git'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Archive JAR') {
            steps {
                archiveArtifacts artifacts: 'build/libs/*.jar', allowEmptyArchive: false
            }
        }
    }
    post {
        success {
            echo 'Build completed successfully and JAR file archived.'
        }
        failure {
            echo 'Build failed.'
        }
    }
}