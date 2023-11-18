def call (String git_branch = 'main', String git_credentials = null, String git_url = null) {
    echo "This is gitcheckout.groovy"
    checkout([$class: 'GITSCM',
            branches: [[name: "*/${git_branch}"]],
            userRemoteConfigs: [[credentialsId: "${git_credentials}", url: "${git_branch}"]]
    ])
    sh "ls -lrt"
}
