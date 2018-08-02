from this folder location inside the terminal
Run the below command from the terminal -> 
-> mvn clean package
then run the below command by providing the appropriate location of the input csv files

-> java -jar target/leftouterjoin-1.0-SNAPSHOT.jar "/Users/mohitha/Downloads/Misc/employee_names.csv" "/Users/mohitha/Downloads/Misc/employee_pay.csv" "/Users/mohitha/Downloads/Misc/employee_join.csv"