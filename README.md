# SpringReact2024
This is a spring boot React CRUD Application. 
The controller contains the methods to List, Save, Update and Delete the Employees.
Initially the application.properties was written to connect to the local database. Then it was changed to connect to the mySQL in AWS. Both the config details are present in the properties file.
The spring Boot application was deployed in AWS using Elastic Beanstalk . As a result, The EBS itself creates the S3, and Ec2. So we need not manually set up S3 and Ec2. To create the EBS, we had to set up the IAM role . Also the database username and password was also provided(This username and password was initially set when we created the MySQL database using RDS).
The server port was also set to 5000 in application.properties and in the EBS config . 
you can get the url from the EBS details.
Also I had set up the alarm in cloudwatch and created the SNS top AWS Billing alarm when the USD exceeds 2 dollar.

There was a issue with POST. because the id colum in the Employee Entity was set to autogenerate the value, but the auto_increment option was not provided in the database. Then I had to alter the table to add auto_increment property to the column "id" in database.

AWS CLI was installed and then following steps done
aws --version -->Will show whether aws cli is installed and what version
aws configure --> It will ask to provide the access key and the secret key which is generated from the IAM user.(Provided in the text file locally)
ssh -i SpringBootTestKey.pem ec2-user@ec2-54-235-129-230.compute-1.amazonaws.com -->This is the pem file used to connect to Ec2. You can see it in the AWS instance as well.  and connect to the IPv4 id of the instance




