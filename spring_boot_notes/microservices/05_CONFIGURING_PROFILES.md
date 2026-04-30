# Configuring Profiles for the limits-service

- DEV > SIT > UAT > PERF > PROD > COB

Create multiple files in your local git config-repo:

```bash
cd /Users/rafael1642/Desktop/Computer_Science/Java/Microservices/git-localconfig-repo

touch limits-service-dev.properties
touch limits-service-uat.properties
touch limits-service-prod.properties

git add .
git commit -m "Add multiple profiles for different environments"
```

Call your service:  
`localhost:8888/limits-service/[dev|uat|prod]`