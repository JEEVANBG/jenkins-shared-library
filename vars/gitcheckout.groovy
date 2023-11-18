def call (String git_branch = 'main', String git_credentials = 'gitlogin', String git_url = 'https://github.com/jaintpharsha/Devops-ITD-May-2023.git') {
    echo "This is gitcheckout.groovy"
    checkout([$class: 'GITSCM',
            branches: [[name: "*/${git_branch}"]],
            userRemoteConfigs: [[credentialsId: "${git_credentials}", url: "${git_branch}"]]
    ])
    sh "ls -lrt"
}
