# File downloader #
Multi threaded application which downloads files given by urls into a specified location on local disk.
Supports various protocols : HTTP, HTTPS, FTP, FTPS and SFTP.


# Building the project
cd into folder filedownloader and run following command
mvn clean install

# Running the project
java -cp [jar name] [Main class] [storage location on local disk] [multiple space separated urls of files to be downloaded]

# Sample command
java -cp target/fd-0.0.1-full.jar com.leo.util.Main "/data" "http://che.org.il/wp-content/uploads/2016/12/pdf-sample.pdf" "ftp://speedtest.tele2.net/5MB.zip"
