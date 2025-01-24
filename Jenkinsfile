pipeline {
    agent any

    tools {
        jdk 'JDK'    // Вказати назву, яку ти задав в Global Tool Configuration
        gradle 'Gradle'  // Вказати назву для Gradle
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Tests') {
            steps {
                bat 'gradle build'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'gradle test'
            }
        }

        stage('Publish Reports') {
            steps {
                junit '**/build/test-results/test/*.xml'
            }
        }
    }

    post {
        success {
            echo 'Tests executed successfully!'
        }
        failure {
            echo 'Tests failed!'
        }
    }
}
