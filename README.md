# SpringReact2024
This is a spring boot React CRUD Application. 
The controller contains the methods to List, Save, Update and Delete the Employees.
Initially the application.properties was written to connect to the local database. Then it was changed to connect to the mySQL in AWS. Both the config details are present in the properties file.
The spring Boot application was deployed in AWS using Elastic Beanstalk . As a result, The EBS itself creates the S3, and Ec2. So we need not manually set up S3 and Ec2. To create the EBS, we had to set up the IAM role . Also the database username and password was also provided(This username and password was initially set when we created the MySQL database using RDS).
The server port was also set to 5000 in application.properties and in the EBS config . 
you can get the url from the EBS details.
Also I had set up the alarm in cloudwatch and created the SNS top AWS Billing alarm when the USD exceeds 2 dollar.

