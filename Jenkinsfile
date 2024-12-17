pipeline {
    agent any

    environment {
        DOCKERHUB_CREDS = credentials('dockerhub-token')
        GITHUB_CREDS = credentials('github-token') 
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-token', url: 'https://github.com/mladenovskistefan111/app-springboot', branch: 'dev'
            }
        }

        stage('Get Latest Git Tag') {
            steps {
                script {
                    def latestTag = sh(script: "git describe --tags --abbrev=0", returnStdout: true).trim()

                    if (latestTag == '') {
                        error('No tags found in the repository!')
                    }

                    env.NEW_TAG = latestTag
                    echo "Using Docker tag: ${latestTag}"

                }
            }
        }

        stage('Build Maven Project') {
            steps {
                script {
                    sh 'mvn install -DskipTests'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'echo ${env.NEW_TAG}'
                    sh 'docker build -t mladenovskistefan/app-springboot:${env.NEW_TAG} .'
                    sh "docker tag mladenovskistefan/app-springboot:${env.NEW_TAG} mladenovskistefan/app-springboot:latest"
                }
            }
        }

        stage('Push to DockerHub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-token', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                        sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
                        sh "docker push mladenovskistefan/app-springboot:${env.NEW_TAG}"
                        sh "docker push mladenovskistefan/app-springboot:latest"
                    }
                }
            }
        }
    }

    post {
        failure {
            echo 'Build failed!'
        }
        success {
            echo 'Build succeeded!'
        }
    }
}
