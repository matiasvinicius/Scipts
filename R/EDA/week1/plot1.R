library(dplyr)

#Getting the data
if (!dir.exists('assets')) {
  dir.create('assets')
  url <- "https://d396qusza40orc.cloudfront.net/exdata%2Fdata%2Fhousehold_power_consumption.zip"
  download.file(url, destfile = "assets/data.zip")
  unzip('assets/data.zip', 'household_power_consumption.txt')
  file.remove('assets/data.zip')
  file.rename(from='household_power_consumption.txt',to='assets/data.txt')
}

#Cleannig the data
data <- read.delim(file='assets/data.txt', sep=';')
data <- as_tibble(data)
data2 <- with(data, as.POSIXct(paste(Date, Time)))

head(data2)